package com.oguz.news;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RESTInterface {

    @GET("news")
    Call<JSON> getJSON();

    @PUT("news/{id}")
    Call<News> putNews(@Path("id") int id, @Body News news);

    @PATCH("news/{id}")
    Call<News> patchNews(@Path("id") int id, @Body News news);
}
