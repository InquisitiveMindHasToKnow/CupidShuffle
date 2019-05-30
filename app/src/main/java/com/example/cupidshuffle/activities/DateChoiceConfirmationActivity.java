package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.squareup.picasso.Picasso;

public class DateChoiceConfirmationActivity extends AppCompatActivity {

    private Intent dateIntent;
    private TextView dateMessageTextView;
    private ImageView dateImageView;

    private static final String VENUE_NAME = "venuename";

    String venue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_choice_confirmation);

        dateMessageTextView = findViewById(R.id.date_selection_message_textview);
        dateImageView = findViewById(R.id.date_selection_imageview);

        dateIntent = getIntent();

        venue = dateIntent.getStringExtra(VENUE_NAME);

        dateMessageTextView.setText("You Chose To Go On A Date To " +  venue + " with " + ShuffleSelectedProfileFragment.USER_NAME);

        Picasso.get()
                .load(R.drawable.greencheckmark)
                .into(dateImageView);



    }
}
