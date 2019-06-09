package com.example.cupidshuffle.activities;


import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.AllUserProfilesFragment;
import com.example.cupidshuffle.fragments.UserProfileFragment;
import com.example.cupidshuffle.fragments.UserViewPagerFragment;
import com.example.cupidshuffle.fragments.ViewAllConnectionRequestsFragment;
import com.example.cupidshuffle.fragments.ViewAllPrivateMessagesFragment;

public class SentMessageConfirmationActivity extends AppCompatActivity {

    private TextView sentConfirmationTextview;
    private ImageView heartyHeartsImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_message_confirmation);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        int size = navView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navView.getMenu().getItem(i).setCheckable(false);
        }


        heartyHeartsImageView = findViewById(R.id.hearty_hearts_imageview);
        sentConfirmationTextview = findViewById(R.id.message_confirmation_sent_textview);


        Glide.with(this).load(R.drawable.heartyhearts).into(heartyHeartsImageView);


    }
        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
            Fragment clickedNavTabFragment;

            int mMenuId = item.getItemId();


            switch (mMenuId) {
                case R.id.navigation_home:
                    clickedNavTabFragment = new UserProfileFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;

                case R.id.navigation_discover:

                    clickedNavTabFragment = new AllUserProfilesFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;

                case R.id.navigation_notifications:

                    clickedNavTabFragment = new ViewAllPrivateMessagesFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;

                case R.id.navigation_shuffle:

                    clickedNavTabFragment = new UserViewPagerFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;

                case R.id.navigation_connection_requests:
                    clickedNavTabFragment = new ViewAllConnectionRequestsFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;
            }

            return true;
        };


    private void inflateFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container,fragment)
                .addToBackStack(null)
                .commit();
    }



}
