package com.oguz.news;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<News> news = new ArrayList<News>();
    private Adapter adapter;
    private String tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        loadJson();
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public void loadJson() {
        RESTInterface restInterface = RESTClient.getClient().create(RESTInterface.class);
        Call<JSON> call = restInterface.getJSON();
        call.enqueue(new Callback<JSON>() {
            @Override
            public void onResponse(Call<JSON> call, Response<JSON> response) {
                if (response.isSuccessful() && response.body().getEmbedded().getNews() != null) {
                    if (!news.isEmpty()) {
                        news.clear();
                    }
                    news = response.body().getEmbedded().getNews();
                    List<News> reverseNews = news;
                    Collections.reverse(reverseNews);
                    adapter = new Adapter(reverseNews, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    initListener();
                } else {
                    Toast.makeText(MainActivity.this, "No result!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSON> call, Throwable t) {

            }
        });
    }

    private void initListener() {
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
                News haber = news.get(position);
                intent.putExtra("url", haber.getUrl());
                intent.putExtra("img", haber.getUrlToImage());
                intent.putExtra("header", haber.getHeader());
                intent.putExtra("content", haber.getContent());
                intent.putExtra("category", haber.getCategory());
                intent.putExtra("likes", haber.getLikes());
                intent.putExtra("dislikes", haber.getDislikes());
                intent.putExtra("views", haber.getViews());
                intent.putExtra("date", haber.getPublishedAt());
                intent.putExtra("id", haber.getId());

                startActivity(intent);
            }
        });
    }

    /**
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Haber ara...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 2) {
                    loadJson();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                loadJson();
                return false;
            }
        });
        searchMenuItem.getIcon().setVisible(false, false);
        return true;
    }
    */
}
