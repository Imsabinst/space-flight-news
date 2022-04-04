package com.example.spaceflight.news;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spaceflight.R;
import com.example.spaceflight.base.BaseAdapter;
import com.example.spaceflight.news.objects.ArticlesObject;

import java.util.List;

public class NewsAdapter extends BaseAdapter<ArticlesObject> {

    public NewsAdapter(List<ArticlesObject> list, Activity activity) {
        this.mItemList = list;
        this.a = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof NewsViewHolder);
        NewsViewHolder holder = (NewsViewHolder) viewHolder;
        ArticlesObject obj = (ArticlesObject) mItemList.get(position);
        holder.setupViews(obj.getTitle(),  obj.getImageUrl());


        /**
         *
         * When each item in the landing page is clicked, the corresponding page (NewsDetailActivity) will have title, image, summary, and news Site.
         * **/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a, NewsDetailActivity.class);
                intent.putExtra("title", obj.getTitle());
                intent.putExtra("image_url", obj.getImageUrl());
                intent.putExtra("summary", obj.getSummary());
                intent.putExtra("news_site", obj.getNewsSite());
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(a,(View)holder.news_image,"news_image");
                a.startActivity(intent,options.toBundle());

            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}