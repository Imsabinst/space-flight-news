package com.example.spaceflight.news.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaunchObject {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("provider")
    @Expose
    private String provider;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

}

