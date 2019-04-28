package com.oguz.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Yazilim Laboratuvari II Proje 2
 * @author Oguz Aktas & Mert Var
 */
public class MainActivity extends AppCompatActivity {

    ListView listNews;
    ProgressBar loader;

    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    static final String KEY_HEADER = "header";
    static final String KEY_CONTENT = "content";
    static final String KEY_CATEGORY = "category";
    static final String KEY_IMAGEURL = "imageurl";
    static final String KEY_PUBLISHDATE = "publishDate";
    static final String KEY_LIKES = "likes";
    static final String KEY_DISLIKES = "dislikes";
    static final String KEY_VIEWS = "views";

    static final String url = "http://192.168.56.1:8080/news";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listNews = (ListView) findViewById(R.id.listNews);
        loader = (ProgressBar) findViewById(R.id.loader);
        listNews.setEmptyView(loader);
        run();
    }

        private void run() {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONObject jsonObject1 = response.getJSONObject("_embedded");
                        JSONArray jsonArray = jsonObject1.getJSONArray("news");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put(KEY_HEADER, jsonObject.getString("header"));
                            map.put(KEY_CONTENT, jsonObject.getString("content"));
                            map.put(KEY_IMAGEURL, jsonObject.getString("imageurl"));
                            map.put(KEY_CATEGORY, jsonObject.getString("category"));
                            map.put(KEY_PUBLISHDATE, jsonObject.getString("publishDate"));
                            map.put(KEY_LIKES, String.valueOf(jsonObject.getInt("likes")));
                            map.put(KEY_DISLIKES, String.valueOf(jsonObject.getInt("dislikes")));
                            map.put(KEY_VIEWS, String.valueOf(jsonObject.getInt("views")));
                            dataList.add(map);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ListNewsAdapter adapter = new ListNewsAdapter(MainActivity.this, dataList);
                    listNews.setAdapter(adapter);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
        }
}