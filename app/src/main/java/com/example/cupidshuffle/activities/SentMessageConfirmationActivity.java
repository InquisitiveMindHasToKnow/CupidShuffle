package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.squareup.picasso.Picasso;

public class SentMessageConfirmationActivity extends AppCompatActivity {

    private TextView sentConfirmationTextview;
    private String confirmationMessage = "Response Sent! ";
    private ImageView checkMarkImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_message_confirmation);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        int size = navView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navView.getMenu().getItem(i).setCheckable(false);
        }


        checkMarkImageView = findViewById(R.id.green_checkmark_imageview);
        sentConfirmationTextview = findViewById(R.id.message_confirmation_sent_textview);

        Picasso.get()
                .load(R.drawable.greencheckmark)
                .into(checkMarkImageView);

        sentConfirmationTextview.setText(confirmationMessage);

    }


}
