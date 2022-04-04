package com.example.spaceflight.base.retrofit;

import android.app.Activity;
import android.app.ProgressDialog;

import com.example.spaceflight.R;
import com.example.spaceflight.base.AppController;
import com.example.spaceflight.base.ConnectionManager;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;

public class SetRequest {
        Call<JsonArray> call;
        Gson g = null;
        Activity a;
        Boolean pd = false;
        ProgressDialog pDialog;

        SetRequest SetRequest() {
            return this;
        }

        public SetRequest set(Call<JsonArray> c) {
            call = c;
            return this;
        }
    public SetRequest get(Activity activity) {
        this.a = activity;
        g = AppController.get(activity).getGson();
        return this;
    }

        public SetRequest start(final OnResponse r) {
            if (ConnectionManager.isNetworkConnected(a)) {
                call.enqueue(new Callback<JsonArray>() {
                    @Override
                    public void onResponse(Call<JsonArray> call, retrofit2.Response<JsonArray> response) {
                        if (pd) {
                            pDialog.dismiss();
                        }
                        switch (response.code()) {
                            case 200:
                                r.OnSuccess(response.body());
                                break;
                            case 500:
                                r.OnError(a.getString(R.string.server_error), "S", response.code(), R.drawable.ic_error);
                                break;
                            case 400:
                                r.OnError(a.getString(R.string.server_error), "S", response.code(), R.drawable.ic_server_error);
                                break;
                            default:
                                r.OnError(a.getString(R.string.try_again), "D", response.code(), R.drawable.ic_server_error);
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonArray> call, Throwable t) {

                            r.OnError(a.getString(R.string.try_again), "D", 0, R.drawable.ic_error);

                    }
                });
            } else {
                if (pd) {
                    pDialog.dismiss();
                }
                r.OnError(a.getString(R.string.no_internet), "N", 1, R.drawable.ic_no_connection);
            }
            return this;
        }

    }

