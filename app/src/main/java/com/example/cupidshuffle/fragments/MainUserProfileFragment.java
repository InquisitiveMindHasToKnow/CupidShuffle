package com.example.cupidshuffle.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.PageAfterLoginActivity;
import com.example.cupidshuffle.activities.ShuffleTheLoveBirdsActivity;
import com.example.cupidshuffle.activities.ViewPrivateMessagesAndConnectionRequest;
import com.example.cupidshuffle.activities.ViewUserProfilesActivity;

public class MainUserProfileFragment extends Fragment {

    private View rootView;

    public MainUserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_user_profile, container, false);

        BottomNavigationView navView = rootView.findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        return rootView;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;

                case R.id.navigation_discover:
                    Intent toViewAllUserAccountsIntent = new Intent(getContext(), ViewUserProfilesActivity.class);
                    startActivity(toViewAllUserAccountsIntent);
                    return true;

                case R.id.navigation_notifications:
                    Intent toMessagesAndConnectRequestIntent = new Intent(getContext(), ViewPrivateMessagesAndConnectionRequest.class);
                    startActivity(toMessagesAndConnectRequestIntent);
                    return true;

                case R.id.navigation_shuffle:
                    Intent toShuffledLoveBirdIntent = new Intent(getContext(), ShuffleTheLoveBirdsActivity.class);
                    startActivity(toShuffledLoveBirdIntent);
                    return true;
            }

            return false;
        }
    };

    }

