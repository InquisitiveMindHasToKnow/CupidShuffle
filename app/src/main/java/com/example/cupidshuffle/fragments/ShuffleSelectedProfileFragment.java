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
import com.example.cupidshuffle.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.activities.FragmentHolderActivity;
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

    private View rootView;
    private static final String TAG = "UserProfilesJSON.TAG";
    public static final String SHUFFLED_USER_KEY = "shuffled User";
    public static String USER_NAME = "";
    public static String CHOSEN_DATES_PICTURE = "";
    private List<UserProfile> userProfileList = new ArrayList<>();
    private TextView shuffledProfilePageUserName;
    private TextView shuffledProfilePageUserLocation;
    private TextView shuffledProfilePageUserBio;
    private TextView shuffledProfilePageUserAge;
    private TextView shuffledProfilePageUserOccupation;
    private CircularImageView shuffledProfilePageUserPicture;
    private Button shuffledProfileLetsShuffleButton;
    private UserProfile shuffledUserProfilePicked;
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

        shuffledProfilePageUserName = rootView.findViewById(R.id.shuffled_profile_username_textview);
        shuffledProfilePageUserBio = rootView.findViewById(R.id.shuffled_profile__bio_textview);
        shuffledProfilePageUserLocation = rootView.findViewById(R.id.shuffled_profile_location_textview);
        shuffledProfilePageUserPicture = rootView.findViewById(R.id.shuffled_profile_circular_imageview);
        shuffledProfilePageUserOccupation = rootView.findViewById(R.id.shuffled_profile_occupation_textview);
        shuffledProfileLetsShuffleButton = rootView.findViewById(R.id.shuffled_profile_letsshuffle_button);
        shuffledProfileMessageMeButton = rootView.findViewById(R.id.shuffled_profile_send_message_to_user_button);

       return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
        UserProfileService userProfileService = retrofit.create(UserProfileService.class);
        userProfileService.getProfiles().enqueue(new Callback<UserProfilesAPI>() {
            @Override
            public void onResponse(Call<UserProfilesAPI> call, Response<UserProfilesAPI> response) {
                Log.d(TAG, "This retrofit works, Omar! " + response.body().getProfiles().get(2).getPicture());
                userProfileList.addAll(response.body().getProfiles());


                Random randomNumber = new Random();
                shuffledUserProfilePicked = userProfileList.get(randomNumber.nextInt(userProfileList.size() - 1) + 1);



                shuffledProfilePageUserName.setText(shuffledUserProfilePicked.getUser() + ", " + shuffledUserProfilePicked.getAge());
                shuffledProfilePageUserBio.setText(shuffledUserProfilePicked.getBio());
                shuffledProfilePageUserLocation.setText(shuffledUserProfilePicked.getLocation());
                shuffledProfilePageUserOccupation.setText(shuffledUserProfilePicked.getOccupation());

                USER_NAME = shuffledUserProfilePicked.getUser();
                CHOSEN_DATES_PICTURE = shuffledUserProfilePicked.getPicture();


                Picasso.get()
                        .load(shuffledUserProfilePicked.getPicture())
                        .into(shuffledProfilePageUserPicture);
            }

            @Override
            public void onFailure(Call<UserProfilesAPI> call, Throwable t) {
                Log.d(TAG, "Retrofit call failed" + t.getMessage());
            }
        });

        shuffledProfileLetsShuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(SHUFFLED_USER_KEY,shuffledUserProfilePicked);
                startActivity(intent);
            }
        });
    }

}
