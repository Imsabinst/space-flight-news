package com.example.spaceflight.base.retrofit;

import static com.example.spaceflight.base.retrofit.URL_api.articles;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET(articles)
    Call<JsonArray> requestArticle();

}

