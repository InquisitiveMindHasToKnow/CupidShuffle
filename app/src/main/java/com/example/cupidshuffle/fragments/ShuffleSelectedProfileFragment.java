package com.example.cupidshuffle.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.network.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.activities.MainActivity;
import com.example.cupidshuffle.model.UserProfile;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.services.UserProfileService;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShuffleSelectedProfileFragment extends Fragment {

    private static final String USER_SELECTED = "USER SELECTED";
    private View rootView;
    private static final String TAG = "UserProfilesJSON.TAG";
    public static final String SHUFFLED_USER_KEY = "shuffled User";
    public static String USER_NAME = "";
    public static String CHOSEN_DATES_PICTURE = "";
    private List<UserProfile> userProfileList = new ArrayList<>();
    private TextView profilePageUserName;
    private TextView profilePageUserLocation;
    private TextView profilePageUserBio;
    private TextView shuffledProfilePageUserAge;
    private TextView profilePageUserOccupation;
    private CircularImageView profilePageUserPicture;
    private Button shuffledProfileLetsShuffleButton;
    private UserProfile profileSelected;
    private Button shuffledProfileMessageMeButton;
    private Intent getShuffledProfileIntent;
    private String shuffledIndividualUserAge;
    private UserProfile userProfile;




    public ShuffleSelectedProfileFragment() {
        // Required empty public constructor
    }

    public static ShuffleSelectedProfileFragment newInstance(UserProfile userProfile) {
        ShuffleSelectedProfileFragment fragment = new ShuffleSelectedProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(USER_SELECTED, userProfile);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userProfile = getArguments().getParcelable(USER_SELECTED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       rootView = inflater.inflate(R.layout.fragment_shuffle_selected_profile, container, false);

        profilePageUserName = rootView.findViewById(R.id.shuffled_profile_username_textview);
        profilePageUserBio = rootView.findViewById(R.id.shuffled_profile__bio_textview);
        profilePageUserLocation = rootView.findViewById(R.id.shuffled_profile_location_textview);
        profilePageUserPicture = rootView.findViewById(R.id.shuffled_profile_circular_imageview);
        profilePageUserOccupation = rootView.findViewById(R.id.shuffled_profile_occupation_textview);
        shuffledProfileLetsShuffleButton = rootView.findViewById(R.id.shuffled_profile_letsshuffle_button);
        shuffledProfileMessageMeButton = rootView.findViewById(R.id.shuffled_profile_send_message_to_user_button);

       return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (userProfile == null) {
            Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
            UserProfileService userProfileService = retrofit.create(UserProfileService.class);
            userProfileService.getProfiles().enqueue(new Callback<UserProfilesAPI>() {
                @Override
                public void onResponse(Call<UserProfilesAPI> call, Response<UserProfilesAPI> response) {
                    Log.d(TAG, "This retrofit works, Omar! " + response.body().getProfiles().get(2).getPicture());
                    userProfileList.addAll(response.body().getProfiles());


                    Random randomNumber = new Random();
                    profileSelected = userProfileList.get(randomNumber.nextInt(userProfileList.size() - 1) + 1);


                    profilePageUserName.setText(profileSelected.getUser() + ", " + profileSelected.getAge());
                    profilePageUserBio.setText(profileSelected.getBio());
                    profilePageUserLocation.setText(profileSelected.getLocation());
                    profilePageUserOccupation.setText(profileSelected.getOccupation());

                    USER_NAME = profileSelected.getUser();
                    CHOSEN_DATES_PICTURE = profileSelected.getPicture();


                    Picasso.get()
                            .load(profileSelected.getPicture())
                            .into(profilePageUserPicture);
                }

                @Override
                public void onFailure(Call<UserProfilesAPI> call, Throwable t) {
                    Log.d(TAG, "Retrofit call failed" + t.getMessage());
                }
            });
        }else {
            profilePageUserName.setText(userProfile.getUser());
            profilePageUserBio.setText(userProfile.getBio());
            profilePageUserLocation.setText(userProfile.getLocation());
            profilePageUserOccupation.setText(userProfile.getOccupation());

            USER_NAME = userProfile.getUser();
            CHOSEN_DATES_PICTURE = userProfile.getPicture();


            Picasso.get()
                    .load(userProfile.getPicture())
                    .into(profilePageUserPicture);

            profileSelected = userProfile;

        }

        shuffledProfileLetsShuffleButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.putExtra(SHUFFLED_USER_KEY, profileSelected);
            startActivity(intent);
        });
    }

}
