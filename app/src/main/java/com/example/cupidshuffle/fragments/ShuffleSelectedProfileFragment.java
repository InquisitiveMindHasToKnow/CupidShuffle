package com.example.cupidshuffle.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.PageAfterLoginActivity;
import com.example.cupidshuffle.activities.ShuffleTheLoveBirdsActivity;
import com.example.cupidshuffle.activities.ViewPrivateMessagesAndConnectionRequest;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class ShuffleSelectedProfileFragment extends Fragment {

    private View rootView;
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



    public ShuffleSelectedProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       rootView = inflater.inflate(R.layout.fragment_shuffle_selected_profile, container, false);


        BottomNavigationView navView = rootView.findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        int size = navView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navView.getMenu().getItem(i).setCheckable(false);
        }

        getShuffledProfileIntent = getActivity().getIntent();

        shuffledProfilePageUserName = rootView.findViewById(R.id.shuffled_profile_username_textview);
        shuffledProfilePageUserBio = rootView.findViewById(R.id.shuffled_profile__bio_textview);
        shuffledProfilePageUserLocation = rootView.findViewById(R.id.shuffled_profile_location_textview);
        shuffledProfilePageUserPicture = rootView.findViewById(R.id.shuffled_profile_circular_imageview);
        shuffledProfilePageUserOccupation = rootView.findViewById(R.id.shuffled_profile_occupation_textview);
        shuffledProfileLetsShuffleButton = rootView.findViewById(R.id.shuffled_profile_letsshuffle_button);
        shuffledProfileMessageMeButton = rootView.findViewById(R.id.shuffled_profile_send_message_to_user_button);

        shuffledIndividualUserAge = getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_AGE);

        shuffledProfilePageUserName.setText(getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_NAME) + ", " + shuffledIndividualUserAge );
        shuffledProfilePageUserBio.setText(getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_BIO));
        shuffledProfilePageUserLocation.setText(getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_LOCATION));
        shuffledProfilePageUserOccupation.setText(getShuffledProfileIntent.getStringExtra(SHUFFLED_USER_OCCUPATION));


        Picasso.get()
                .load(getActivity().getIntent().getStringExtra(SHUFFLED_USER_PICTURE))
                .into(shuffledProfilePageUserPicture);

       return rootView;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment clickedNavTabFragment = null;
            Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.main_fragment_container);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    clickedNavTabFragment = new MainUserProfileFragment();
                    break;

                case R.id.navigation_discover:

                    clickedNavTabFragment = new ViewAllUserProfilesFragment();
                    FragmentManager fragmentManager =getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.main_fragment_container, clickedNavTabFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;

                case R.id.navigation_notifications:
                    Intent toMessagesAndConnectRequestIntent = new Intent(getContext(), ViewPrivateMessagesAndConnectionRequest.class);
                    startActivity(toMessagesAndConnectRequestIntent);
                    return true;

                case R.id.navigation_shuffle:
                    Intent toShuffledLoveBirdIntent = new Intent(getContext(), ShuffleTheLoveBirdsActivity.class);
                    startActivity(toShuffledLoveBirdIntent);
                    return true;
            }

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, clickedNavTabFragment).commit();
            return true;
        }
    };

}
