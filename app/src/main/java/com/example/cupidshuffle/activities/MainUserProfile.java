package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class MainUserProfile extends AppCompatActivity {

    private ImageView mainUserProfilePictureImageView;
    private TextView mainUserProfileUserNameTextView;
    private TextView mainUserProfileUserLocationTextView;
    private TextView mainUserProfileUserOccupationTextView;
    private TextView mainUserProfileUserUserBio;
    private TextView mainUserProfileConnectSuggestionTextView;
    private CircularImageView connectOne;
    private CircularImageView connectTwo;
    private CircularImageView connectThree;
    private CircularImageView connectFour;
    private CircularImageView connectFive;
    private CircularImageView connectSix;
    private CircularImageView connectSeven;
    private CircularImageView connectEight;

    private LinearLayout shuffleLinearLayout;
    private LinearLayout messageLinearLayout;
    private LinearLayout requestLinearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_profile);


        mainUserProfilePictureImageView = findViewById(R.id.main_user_profile_imageview);
        mainUserProfileUserNameTextView = findViewById(R.id.main_user_profile_username_textview);
        mainUserProfileUserLocationTextView = findViewById(R.id.main_user_profile_location_textview);
        mainUserProfileUserOccupationTextView = findViewById(R.id.main_user_profile_occupation_textview);
        mainUserProfileUserUserBio = findViewById(R.id.main_user_profile_bio_textview);
        mainUserProfileConnectSuggestionTextView = findViewById(R.id.main_user_profile_connect_suggestion_textview);
        connectOne = findViewById(R.id.main_user_profile_first_connect);
        connectTwo = findViewById(R.id.main_user_profile_second_connect);
        connectThree = findViewById(R.id.main_user_profile_third_connect);
        connectFour = findViewById(R.id.main_user_profile_fourth_connect);
        connectFive = findViewById(R.id.main_user_profile_fifth_connect);
        connectSix = findViewById(R.id.main_user_profile_sixth_connect);
        connectSeven = findViewById(R.id.main_user_profile_seventh_connect);
        connectEight = findViewById(R.id.main_user_profile_eighth_connect);

        shuffleLinearLayout = findViewById(R.id.main_user_profile_connect_linear_layout);
        messageLinearLayout = findViewById(R.id.main_user_profile_messages_linear_layout);
        requestLinearLayout = findViewById(R.id.main_user_profile_request_linear_layout);

        shuffleLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAllAccountsRecyclerViewIntent = new Intent(MainUserProfile.this, ViewUserProfilesActivity.class);
                startActivity(toAllAccountsRecyclerViewIntent);

            }
        });



        messageLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPrivateMessagesRecyclerViewIntent = new Intent(MainUserProfile.this, ViewPrivateMessagesAndConnectionRequest.class);
                startActivity(toPrivateMessagesRecyclerViewIntent);
            }
        });


        requestLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toConnectionRequestRecyclerViewIntent = new Intent(MainUserProfile.this, ViewPrivateMessagesAndConnectionRequest.class);
                startActivity(toConnectionRequestRecyclerViewIntent);

            }
        });



    }
}
