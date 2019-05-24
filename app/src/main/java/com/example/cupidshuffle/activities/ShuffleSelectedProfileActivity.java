package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class ShuffleSelectedProfileActivity extends AppCompatActivity {

    private static final String SHUFFLED_USER_NAME = "shuffledusername";
    private static final String SHUFFLED_USER_AGE = "shuffleduserage";
    private static final String SHUFFLED_USER_OCCUPATION = "shuffleduseroccupation";
    private static final String SHUFFLED_USER_PICTURE = "shuffleduserpicture";
    private static final String SHUFFLED_USER_LOCATION = "shuffleduserlocation";
    private static final String SHUFFLED_USER_BIO = "shuffleduserbio";

    private TextView shuffledProfilePageUserName;
    private TextView shuffledProfilePageUserLocation;
    private TextView shuffledProfilePageUserBio;
    private TextView shuffledProfilePageUserAge;
    private TextView shuffledProfilePageUserOccupation;
    private CircularImageView shuffledProfilePageUserPicture;
    private Button shuffledProfileLetsShuffleButton;
    private Button shuffledProfileMessageMeButton;
    private Intent getShuffledProfileIntent;

    private String shuffledIndividualUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuffle_selected_profile);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        int size = navView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navView.getMenu().getItem(i).setCheckable(false);
        }

        getShuffledProfileIntent = getIntent();

        shuffledProfilePageUserName = findViewById(R.id.shuffled_profile_username_textview);
        shuffledProfilePageUserBio = findViewById(R.id.shuffled_profile__bio_textview);
        shuffledProfilePageUserLocation = findViewById(R.id.shuffled_profile_location_textview);
        shuffledProfilePageUserPicture = findViewById(R.id.shuffled_profile_circular_imageview);
        shuffledProfilePageUserOccupation = findViewById(R.id.shuffled_profile_occupation_textview);
        shuffledProfileLetsShuffleButton = findViewById(R.id.shuffled_profile_letsshuffle_button);
        shuffledProfileMessageMeButton = findViewById(R.id.shuffled_profile_send_message_to_user_button);

        shuffledIndividualUserAge = getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_AGE);

        shuffledProfilePageUserName.setText(getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_NAME) + ", " + shuffledIndividualUserAge );
        shuffledProfilePageUserBio.setText(getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_BIO));
        shuffledProfilePageUserLocation.setText(getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_LOCATION));
        shuffledProfilePageUserOccupation.setText(getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_OCCUPATION));


        Picasso.get()
                .load(getIntent().getStringExtra(SHUFFLED_USER_PICTURE))
                .into(shuffledProfilePageUserPicture);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent toMainProfileIntent = new Intent(ShuffleSelectedProfileActivity.this, PageAfterLoginActivity.class);
                    startActivity(toMainProfileIntent);

                    return true;

                case R.id.navigation_discover:
                    Intent toViewAllUserAccountsIntent = new Intent(ShuffleSelectedProfileActivity.this, ViewUserProfilesActivity.class);
                    startActivity(toViewAllUserAccountsIntent);
                    return true;

                case R.id.navigation_notifications:
                    Intent toMessagesAndConnectRequestIntent = new Intent(ShuffleSelectedProfileActivity.this, ViewPrivateMessagesAndConnectionRequest.class);
                    startActivity(toMessagesAndConnectRequestIntent);
                    return true;

                case R.id.navigation_shuffle:
                    Intent toShuffledLoveBirdIntent = new Intent(ShuffleSelectedProfileActivity.this, ShuffleTheLoveBirdsActivity.class);
                    startActivity(toShuffledLoveBirdIntent);
                    return true;
            }

            return false;
        }
    };
}
