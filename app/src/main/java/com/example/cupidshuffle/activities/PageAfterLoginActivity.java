package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.MainUserProfileFragment;
import com.example.cupidshuffle.fragments.ViewAllUserProfilesFragment;

public class PageAfterLoginActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_after_login);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        MainUserProfileFragment mainFragment = new MainUserProfileFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment_container, mainFragment);
        fragmentTransaction.commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           Fragment clickedNavTabFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    clickedNavTabFragment = new MainUserProfileFragment();
                    break;

                case R.id.navigation_discover:

                    clickedNavTabFragment = new ViewAllUserProfilesFragment();
//                    Intent toViewAllUserAccountsIntent = new Intent(PageAfterLoginActivity.this, ViewUserProfilesActivity.class);
//                    startActivity(toViewAllUserAccountsIntent);
                    break;

                case R.id.navigation_notifications:
                    Intent toMessagesAndConnectRequestIntent = new Intent(PageAfterLoginActivity.this, ViewPrivateMessagesAndConnectionRequest.class);
                    startActivity(toMessagesAndConnectRequestIntent);
                    return true;

                case R.id.navigation_shuffle:
                    Intent toShuffledLoveBirdIntent = new Intent(PageAfterLoginActivity.this, ShuffleTheLoveBirdsActivity.class);
                    startActivity(toShuffledLoveBirdIntent);
                    return true;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, clickedNavTabFragment).commit();

            return true;
        }
    };

}
