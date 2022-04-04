package com.example.spaceflight.news;

import com.example.spaceflight.news.objects.ArticlesObject;

import java.util.List;

public interface NewsContractor {
    interface View{
        void onErrorMessage(String message);
        void onResponseSuccess(List<ArticlesObject> response);
    }
    interface Presenter{
        void requestArticle();
    }
}