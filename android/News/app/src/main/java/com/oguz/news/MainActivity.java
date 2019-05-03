package com.oguz.news;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.oguz.news.Adapter;
import com.oguz.news.News;

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
    private List<News> filteredNews = new ArrayList<News>();
    private Adapter adapter;
    private String tag = MainActivity.class.getSimpleName();

    private ArrayAdapter<CharSequence> sp_adapter;
    private Spinner spinner;
    private String selectCategory = "Tum haberler";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        spinner = (Spinner) findViewById(R.id.category_spinner);
        sp_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.category, android.R.layout.simple_spinner_item);
        sp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(sp_adapter);

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
                        filteredNews.clear();
                    }
                    news = response.body().getEmbedded().getNews();
                    if (selectCategory.equals("Tum haberler")) {
                        filteredNews = news;
                    } else {
                        for (News haber : news) {
                            if (haber.getCategory().equals(selectCategory)) {
                                filteredNews.add(haber);
                            }
                        }
                    }
                    Collections.reverse(filteredNews);
                    adapter = new Adapter(filteredNews, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    initListener();
                    initListener2();
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
                News haber = filteredNews.get(position);
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

    private void initListener2() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectCategory = parent.getItemAtPosition(position).toString();
                //TextView textView = findViewById(R.id.textView2);
                //textView.setText(selectCategory);
                loadJson();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                loadJson();
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
