package com.example.spaceflight.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.spaceflight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    /**
     * from row_news_item
     * */

    @BindView(R.id.tv_news_title)
    TextView newsHeadline;
    @BindView(R.id.iv_background)
    ImageView news_image;
    View view;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.view = itemView;
    }
    public void setupViews(String title, String image_url) {
        this.newsHeadline.setText(title);
        Glide.with(view.getContext())
                .load(image_url)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_space))
                .into(news_image);
    }
}
