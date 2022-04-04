package com.example.spaceflight;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spaceflight.news.NewsActivity;

public class SplashScreenActivity extends AppCompatActivity {

    /**
     *    the next activity will start after completion of 2000 ms.
     */
    private static int SPLASH_SCREEN_TIME_OUT=1300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         *   binds SplashScreenActivity.class file with activity_splash_screen.
         * */

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(SplashScreenActivity.this,
                        NewsActivity.class);

                /**  invokes the SecondActivity.**/
                startActivity(i);

                /**  the current activity ends.**/
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
