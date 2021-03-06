package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.AllUserProfilesFragment;
import com.example.cupidshuffle.fragments.ClosePrivateProfileNavigation;
import com.example.cupidshuffle.fragments.UserProfileFragment;
import com.example.cupidshuffle.fragments.UserViewPagerFragment;
import com.example.cupidshuffle.fragments.ViewAllConnectionRequestsFragment;
import com.example.cupidshuffle.fragments.ViewAllPrivateMessagesFragment;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class PrivateProfileActivity extends AppCompatActivity implements ClosePrivateProfileNavigation {

    private static final String REQUESTORS_USER_NAME = "requestorsusername";
    private static final String REQUESTOR_USER_PICTURE = "requestorspicutre";
    private String headerMessage = " Has A Private Profile";
    private String requestorsName;
    private TextView privateProfileUserNameHeader;
    private TextView privateProfileMessage;
    private CircularImageView privateProfileCircularImageView;
    private Button privateProfileConnectRequestButton;
    private Intent getInfoForPrivateUserIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_profile);

        getInfoForPrivateUserIntent = getIntent();

        requestorsName = getInfoForPrivateUserIntent.getStringExtra(REQUESTORS_USER_NAME);

        privateProfileUserNameHeader = findViewById(R.id.private_profile_user_name_textview);
        privateProfileCircularImageView = findViewById(R.id.private_profile_user_picture_circular_imageview);
        privateProfileMessage = findViewById(R.id.private_profile_message_textview);
        privateProfileConnectRequestButton = findViewById(R.id.private_profile_connect_button);

        privateProfileUserNameHeader.setText(getInfoForPrivateUserIntent.getStringExtra(REQUESTORS_USER_NAME));

        privateProfileMessage.setText(requestorsName + headerMessage);


        Picasso.get()
                .load(getInfoForPrivateUserIntent.getStringExtra(REQUESTOR_USER_PICTURE))
                .into(privateProfileCircularImageView);

        privateProfileConnectRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PrivateProfileActivity.this, "Connection request sent to " + requestorsName, Toast.LENGTH_LONG).show();
                closePrivateProfileActivity();

            }
        });

    }

    @Override
    public void closePrivateProfileActivity() {
        finish();
    }
}
