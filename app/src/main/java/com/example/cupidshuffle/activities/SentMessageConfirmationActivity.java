package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.squareup.picasso.Picasso;

public class SentMessageConfirmationActivity extends AppCompatActivity {

    private TextView sentConfirmationTextview;
    private String confirmationMessage = "Response Sent! ";
    private ImageView checkMarkImageView;
    private Button backToProfileButton;
    private Button keepShufflingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_message_confirmation);


        checkMarkImageView = findViewById(R.id.green_checkmark_imageview);
        backToProfileButton = findViewById(R.id.back_to_profile_button);
        keepShufflingButton = findViewById(R.id.keep_shuffing_button);
        sentConfirmationTextview = findViewById(R.id.message_confirmation_sent_textview);

        Picasso.get()
                .load(R.drawable.greencheckmark)
                .into(checkMarkImageView);

        sentConfirmationTextview.setText(confirmationMessage);

        backToProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToProfileIntent = new Intent(SentMessageConfirmationActivity.this, MainUserProfile.class);
                startActivity(backToProfileIntent);
            }
        });

        keepShufflingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent keepShufflingIntent = new Intent(SentMessageConfirmationActivity.this, ViewUserProfilesActivity.class);
                startActivity(keepShufflingIntent);
            }
        });
    }
}
