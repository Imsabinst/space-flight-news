package com.example.spaceflight.base.retrofit;

import com.google.gson.JsonArray;

public interface OnResponse {
    public void OnSuccess(JsonArray res);
    public void OnError(String err, String errorCode, int code, int image);
}
