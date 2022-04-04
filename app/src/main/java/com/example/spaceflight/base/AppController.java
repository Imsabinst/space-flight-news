package com.example.spaceflight.base;

import android.app.Activity;
import android.app.Application;

import com.example.spaceflight.base.retrofit.ApiService;
import com.example.spaceflight.base.retrofit.URL_api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppController extends Application {
    ApiService service;
    Gson gson;
    public static Activity mactivity;

    public static AppController get(Activity activity) {
        mactivity = activity;
        return (AppController) activity.getApplication();
    }


    public static AppController getApp(Application application) {
        return (AppController) application;
    }

    public ApiService getService() {
        return service;
    }

    public Gson getGson() {
        return gson;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_api.host)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        gson = builder.create();
    }


}
