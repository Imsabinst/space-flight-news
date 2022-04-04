package com.example.spaceflight.news;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.example.spaceflight.R;
import com.example.spaceflight.base.BaseActivity;
import com.example.spaceflight.news.objects.ArticlesObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NewsActivity extends BaseActivity implements NewsContractor.View{
    NewsPresenter presenter;
    @BindView(R.id.rv_main)
    RecyclerView recyclerView;
    NewsAdapter adapter;
    List<ArticlesObject> mList = new ArrayList<>();

    @BindView(R.id.swiper)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    public Activity getActivityContext() {
        return this;
    }

    @Override
    public int myLayout() {
        return R.layout.activity_news;
    }

    @Override
    protected void activityCreated() {
        pageTitle("", false);
        presenter = new NewsPresenter(NewsActivity.this, getActivityContext());
        setupViews();
        requestData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData();
            }
        });
    }

    private void requestData() {
        progress.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        presenter.requestArticle();
    }

    private void setupViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivityContext()));
        adapter = new NewsAdapter(mList, getActivityContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResponseSuccess(List<ArticlesObject> response) {
        progress.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
        recyclerView.setVisibility(View.VISIBLE);
        mList.clear();
        mList.addAll(response);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onErrorMessage(String message) {
        progress.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
