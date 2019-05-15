package com.example.cupidshuffle;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pl.droidsonroids.gif.GifImageView;

public class SplashActivity extends AppCompatActivity {
    private GifImageView pphearts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pphearts = findViewById(R.id.pphearts_gif);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pphearts.setImageResource(R.drawable.pphearts);
            }
        }, 1300);


        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this,
                        MainActivity.class));
                finish();
            }
        }, secondsDelayed * 3700);
    }
}

