package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
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
    private Button letsShuffleButton;
    private Button messageMeButton;

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

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        int size = navView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navView.getMenu().getItem(i).setCheckable(false);
        }

        fillOutProfileIntent = getIntent();

        individualProfilePageUserName = findViewById(R.id.individual_profile_username_textview);
        individualProfilePageUserBio = findViewById(R.id.individual_profile_bio_textview);
        individualProfilePageUserLocation = findViewById(R.id.individual_profile_location_textview);
        individualProfilePageUserPicture = findViewById(R.id.individual_profile_circular_imageview);
        individualProfilePageUserOccupation = findViewById(R.id.individual_profile_occupation_textview);
        letsShuffleButton = findViewById(R.id.letsshufflebutton);
        messageMeButton = findViewById(R.id.sendmessagetouserbutton);


        individualUserAge = fillOutProfileIntent.getStringExtra(USER_AGE);

        individualProfilePageUserName.setText(fillOutProfileIntent.getStringExtra(USER_NAME) + ", " + individualUserAge );
        individualProfilePageUserBio.setText(fillOutProfileIntent.getStringExtra(USER_BIO));
        individualProfilePageUserLocation.setText(fillOutProfileIntent.getStringExtra(USER_LOCATION));
        individualProfilePageUserOccupation.setText(fillOutProfileIntent.getStringExtra(USER_OCCUPATION));


        Picasso.get()
                .load(getIntent().getStringExtra(USER_PICTURE))
                .into(individualProfilePageUserPicture);

        letsShuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(IndividualProfilePage.this, "You can shuffle once we implement this page.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent toMainProfileIntent = new Intent(IndividualProfilePage.this, FragmentHolderActivity.class);
                    startActivity(toMainProfileIntent);

                    return true;
                case R.id.navigation_discover:
                    Intent toViewAllUserAccountsIntent = new Intent(IndividualProfilePage.this, ViewUserProfilesActivity.class);
                    startActivity(toViewAllUserAccountsIntent);
                    return true;

                case R.id.navigation_notifications:
                    Intent toMessagesAndConnectRequestIntent = new Intent(IndividualProfilePage.this, ViewPrivateMessagesAndConnectionRequest.class);
                    startActivity(toMessagesAndConnectRequestIntent);
                    return true;

                case R.id.navigation_shuffle:
                    Intent toShuffledLoveBirdIntent = new Intent(IndividualProfilePage.this, ShuffleTheLoveBirdsActivity.class);
                    startActivity(toShuffledLoveBirdIntent);
                    return true;
            }

            return false;
        }
    };
}
