package com.oguz.news;

import com.oguz.news.MainActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView date, header, content, category, likes, dislikes, views;
    private String mUrl, mImg, mHeader, mDate, mContent, mCategory, mLikes, mDislikes, mViews, mId;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<News> news = new ArrayList<News>();
    private Adapter adapter;


    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        imageView = findViewById(R.id.img);
        date = findViewById(R.id.publishedAt);
        header = findViewById(R.id.header);
        content = findViewById(R.id.content);
        category = findViewById(R.id.category);
        likes = findViewById(R.id.likes);
        dislikes = findViewById(R.id.dislikes);
        views = findViewById(R.id.views);

        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        mImg = intent.getStringExtra("img");
        mHeader = intent.getStringExtra("header");
        mContent = intent.getStringExtra("content");
        mCategory = intent.getStringExtra("category");
        mDate = intent.getStringExtra("date");
        mLikes = intent.getStringExtra("likes");
        mDislikes = intent.getStringExtra("dislikes");
        mViews = Integer.toString(Integer.parseInt(intent.getStringExtra("views")) + 1);
        mId = intent.getStringExtra("id");

        News haber = new News(mId, mCategory, mHeader, mContent, mImg, mDate, mLikes, mDislikes, mViews);
        RESTInterface restInterface = RESTClient.getClient().create(RESTInterface.class);
        Call<News> call = restInterface.patchNews(Integer.parseInt(mId), haber);
        call.enqueue(new Callback<News>() {

            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (!response.isSuccessful()) {
                    return;
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(Utils.getRandomDrawbleColor());

        Glide.with(this)
                .load(mImg)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);

        date.setText(Utils.DateFormat(mDate));
        header.setText(mHeader);
        content.setText(mContent);
        category.setText(mCategory);
        likes.setText(mLikes);
        dislikes.setText(mDislikes);
        likes.setText("Likes: " + mLikes);
        dislikes.setText("Dislikes: " + mDislikes);
        views.setText("Goruntulenme: " + mViews);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewsDetailActivity.this, MainActivity.class));
            }
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLikes = Integer.toString(Integer.parseInt(mLikes) + 1);
                likes.setText("Likes: " + mLikes);
                News haber = new News(mId, mCategory, mHeader, mContent, mImg, mDate, mLikes, mDislikes, mViews);
                RESTInterface restInterface = RESTClient.getClient().create(RESTInterface.class);
                Call<News> call = restInterface.patchNews(Integer.parseInt(mId), haber);
                call.enqueue(new Callback<News>() {

                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (!response.isSuccessful()) {
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {

                    }
                });
            }
        });

        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDislikes = Integer.toString(Integer.parseInt(mDislikes) + 1);
                dislikes.setText("Dislikes: " + mDislikes);
                News haber = new News(mId, mCategory, mHeader, mContent, mImg, mDate, mLikes, mDislikes, mViews);
                RESTInterface restInterface = RESTClient.getClient().create(RESTInterface.class);
                Call<News> call = restInterface.patchNews(Integer.parseInt(mId), haber);
                call.enqueue(new Callback<News>() {

                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (!response.isSuccessful()) {
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {

                    }
                });
            }
        });
    }

    /**
    public List<News> loadJson() {
        RESTInterface restInterface = RESTClient.getClient().create(RESTInterface.class);
        Call<JSON> call = restInterface.getJSON();
        call.enqueue(new Callback<JSON>() {
            @Override
            public void onResponse(Call<JSON> call, Response<JSON> response) {
                if (response.isSuccessful() && response.body().getEmbedded().getNews() != null) {
                    news = response.body().getEmbedded().getNews();
                } else {
                    Toast.makeText(NewsDetailActivity.this, "No result!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSON> call, Throwable t) {

            }
        });
        return news;
    }
     */

    public void updateJson(int id) {
        News haber = new News();
        RESTInterface restInterface = RESTClient.getClient().create(RESTInterface.class);
        Call<News> call = restInterface.patchNews(id, haber);
        call.enqueue(new Callback<News>() {

            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (!response.isSuccessful()) {
                    return;
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
