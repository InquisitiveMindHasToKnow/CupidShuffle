package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.rv.UserProfilesViewHolder;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class IndividualProfilePage extends AppCompatActivity {

    private TextView individualProfilePageUserName;
    private TextView individualProfilePageUserLocation;
    private TextView individualProfilePageUserBio;
    private TextView individualProfilePageUserAge;
    private TextView individualProfilePageUserOccupation;
    private CircularImageView individualProfilePageUserPicture;
    private Intent fillOutProfileIntent;

    private static final String USER_NAME = "username";
    private static final String USER_AGE = "userage";
    private static final String USER_OCCUPATION = "useroccupation";
    private static final String USER_PICTURE = "userpicture";
    private static final String USER_LOCATION = "userlocation";
    private static final String USER_BIO = "userbio";

    private String individualUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_profile_page);

        fillOutProfileIntent = getIntent();

        individualProfilePageUserName = findViewById(R.id.individual_profile_username_textview);
        individualProfilePageUserBio = findViewById(R.id.individual_profile_bio_textview);
        individualProfilePageUserLocation = findViewById(R.id.individual_profile_location_textview);
        individualProfilePageUserPicture = findViewById(R.id.individual_profile_circular_imageview);
        individualProfilePageUserOccupation = findViewById(R.id.individual_profile_occupation_textview);


        individualUserAge = fillOutProfileIntent.getStringExtra(USER_AGE);

        individualProfilePageUserName.setText(fillOutProfileIntent.getStringExtra(USER_NAME) + ", " + individualUserAge );
        individualProfilePageUserBio.setText(fillOutProfileIntent.getStringExtra(USER_BIO));
        individualProfilePageUserLocation.setText(fillOutProfileIntent.getStringExtra(USER_LOCATION));
        individualProfilePageUserOccupation.setText(fillOutProfileIntent.getStringExtra(USER_OCCUPATION));


        Picasso.get()
                .load(getIntent().getStringExtra(USER_PICTURE))
                .into(individualProfilePageUserPicture);
    }
}
