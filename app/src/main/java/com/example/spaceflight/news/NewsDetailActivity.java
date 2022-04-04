package com.example.spaceflight.news;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.spaceflight.R;
import com.example.spaceflight.base.BaseActivity;

import butterknife.BindView;

public class NewsDetailActivity extends BaseActivity {
    @BindView(R.id.tv_news_title)
    TextView news_title;
    @BindView(R.id.iv_news_detail_background)
    ImageView news_image;
    @BindView(R.id.tv_news_summary)
    TextView news_summary;
    @BindView(R.id.tv_news_site)
    TextView new_site;

    @Override
    public Activity getActivityContext() {
        return this;
    }

    @Override
    public int myLayout() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void activityCreated() {
        pageTitle("", true);
        Bundle b = getIntent().getExtras();

        String image_url = b.getString("image_url");

        Glide.with(getActivityContext())
                .load(image_url)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_space))
                .apply(RequestOptions.centerCropTransform())
                .into(news_image);
        news_title.setText(b.getString("title"));
        news_summary.setText(b.getString("summary"));
        new_site.setText("News Site: " +  b.getString("news_site"));

    }
}
