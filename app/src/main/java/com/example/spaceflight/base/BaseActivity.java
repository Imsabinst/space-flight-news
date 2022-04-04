package com.example.spaceflight.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.spaceflight.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseActivity extends AppCompatActivity {
    @BindView(R.id.app_bar_title)
    TextView mTitle;
    @BindView(R.id.shadow_toolbar)
    View shadow_toolbar;
    @BindView(R.id.img_back)
    ImageView img_back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(myLayout());
        activityCreated();
    }

    public void pageTitle(String title, Boolean home) {
       ButterKnife.bind(getActivityContext());
        mTitle.setText(title);
        if (home) {
            img_back.setVisibility(View.VISIBLE);
        } else {
            img_back.setVisibility(View.GONE);
        }
    }

    public void hideShadow() {
        shadow_toolbar.setVisibility(View.GONE);
    }

    public abstract Activity getActivityContext();

    public abstract int myLayout();

    protected abstract void activityCreated();


    @OnClick(R.id.img_back)
    public void goBack() {
        finish();
    }

}
