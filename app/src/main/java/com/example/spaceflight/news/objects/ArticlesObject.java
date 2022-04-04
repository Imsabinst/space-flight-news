package com.example.spaceflight.news.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticlesObject {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("newsSite")
    @Expose
    private String newsSite;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("featured")
    @Expose
    private Boolean featured;
    @SerializedName("launches")
    @Expose
    private List<LaunchObject> launches = null;
    @SerializedName("events")
    @Expose
    private List<Object> events = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public List<LaunchObject> getLaunches() {
        return launches;
    }

    public void setLaunches(List<LaunchObject> launches) {
        this.launches = launches;
    }

    public List<Object> getEvents() {
        return events;
    }

    public void setEvents(List<Object> events) {
        this.events = events;
    }

}

