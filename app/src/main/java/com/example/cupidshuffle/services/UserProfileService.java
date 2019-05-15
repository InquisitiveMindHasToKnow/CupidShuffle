package com.example.cupidshuffle.services;

import com.example.cupidshuffle.model.UserProfilesAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserProfileService {

    @GET("InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/a77df69ba943dd6eb089daef8cc61ef1cc0de995/CupidShuffleProfiles.txt")
    Call<UserProfilesAPI> getProfiles();
}
