package com.example.cupidshuffle.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.activities.ShuffleSelectedProfileActivity;
import com.example.cupidshuffle.activities.ShuffleTheLoveBirdsActivity;
import com.example.cupidshuffle.model.UserProfiles;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.navigation.FragNav;
import com.example.cupidshuffle.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ShuffleTheLoveBirdsFragment extends Fragment {

    private static final String TAG = "UserProfilesJSON.TAG";
    private List<UserProfiles> userProfileList = new ArrayList<>();
    private View rootView;

    private FragNav fragNav;


    public ShuffleTheLoveBirdsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shuffle_the_love_birds, container, false);


        Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
        final UserProfileService userProfileService = retrofit.create(UserProfileService.class);
        userProfileService.getProfiles().enqueue(new Callback<UserProfilesAPI>() {
            @Override
            public void onResponse(Call<UserProfilesAPI> call, Response<UserProfilesAPI> response) {
                Log.d(TAG, "This retrofit works, Omar! " + response.body().getProfiles().get(2).getPicture());
                userProfileList.addAll(response.body().getProfiles());


                Random randomNumber = new Random();
                UserProfiles shuffledUserProfilePicked = userProfileList.get(randomNumber.nextInt(userProfileList.size() - 1) + 1);

                fragNav = (FragNav) getContext();
                fragNav.goToSelectedProfileAfterShuffle(shuffledUserProfilePicked.getUser(), shuffledUserProfilePicked.getAge(), shuffledUserProfilePicked.getPicture(),
                        shuffledUserProfilePicked.getOccupation(), shuffledUserProfilePicked.getLocation(), shuffledUserProfilePicked.getBio());

            }

            @Override
            public void onFailure(Call<UserProfilesAPI> call, Throwable t) {
                Log.d(TAG, "Retrofit call failed" + t.getMessage());
            }
        });
        return rootView;
    }

}

