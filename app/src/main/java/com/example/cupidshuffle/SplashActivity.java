package com.example.cupidshuffle;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cupidshuffle.activities.LoginActivity;
import pl.droidsonroids.gif.GifImageView;

public class SplashActivity extends AppCompatActivity {
    private GifImageView cupidShoots;
    private GifImageView ppHearts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cupidShoots = findViewById(R.id.cupid_shoot_gif);
        ppHearts = findViewById(R.id.pphearts_gif);

        ppHearts.setAlpha(0f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cupidShoots.setVisibility(View.GONE);
                ppHearts.setImageResource(R.drawable.pphearts);
                ppHearts.animate()
                        .setDuration(1000)
                        .alpha(1f);
            }
        }, 1100);


        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this,
                        LoginActivity.class));
                finish();
            }
        }, secondsDelayed * 3700);
    }
}

