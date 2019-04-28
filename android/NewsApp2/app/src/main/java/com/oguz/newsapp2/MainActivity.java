package com.oguz.newsapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/**
 * Yazilim Laboratuvari II Proje 2
 * @author Oguz Aktas & Mert Var
 */
public class MainActivity extends AppCompatActivity {

    private TextView result;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        Button parse = findViewById(R.id.parse);

        mQueue = Volley.newRequestQueue(this);

        /**
         if (Function.isNetworkAvailable(getApplicationContext()))
         {
         DownloadNews newsTask = new DownloadNews();
         newsTask.execute();
         } else {
         Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
         }
         */

        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        String url = "http://192.168.56.1:8080/news";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject = response.getJSONObject("_embedded");
                    JSONArray jsonArray = jsonObject.getJSONArray("news");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject news = jsonArray.getJSONObject(i);
                        String header = news.getString("header");
                        String content = news.getString("content");
                        String category = news.getString("category");
                        String imageurl = news.getString("imageurl");
                        int likes = news.getInt("likes");
                        int dislikes = news.getInt("dislikes");
                        int views = news.getInt("views");
                        result.append(header + ", " + content + ", " + category + ", " + imageurl + ", " + String.valueOf(likes) + ", " + String.valueOf(dislikes) + ", " + String.valueOf(views) + "\n\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}