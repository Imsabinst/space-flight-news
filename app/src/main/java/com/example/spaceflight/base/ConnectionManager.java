package com.example.spaceflight.base;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;


public class ConnectionManager {
    public static boolean isNetworkConnected(Activity context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() !=null;
    }
}

