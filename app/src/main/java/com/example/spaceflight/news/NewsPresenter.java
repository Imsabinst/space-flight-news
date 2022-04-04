package com.example.spaceflight.news;

import android.app.Activity;

import com.example.spaceflight.base.AppController;
import com.example.spaceflight.base.retrofit.OnResponse;
import com.example.spaceflight.base.retrofit.SetRequest;
import com.example.spaceflight.news.objects.ArticlesObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class NewsPresenter implements NewsContractor.Presenter {
    NewsContractor.View view;
    Activity activity;
    public NewsPresenter(NewsContractor.View view, Activity activity) {
        this.view = view;
        this.activity = activity;
    }

    @Override
    public void requestArticle() {
        new SetRequest().get(activity).set(AppController.get(activity).getService().requestArticle()).start(new OnResponse() {
            @Override
            public void OnSuccess(JsonArray res) {
                List<ArticlesObject> response = new Gson().fromJson(res, new TypeToken<List<ArticlesObject>>() {
                }.getType());
                view.onResponseSuccess(response);
            }

            @Override
            public void OnError(String err, String errorCode, int code, int image) {
                view.onErrorMessage(err);
            }
        });

    }
}
