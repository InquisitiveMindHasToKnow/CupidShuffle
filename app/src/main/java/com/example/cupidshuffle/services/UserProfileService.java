package com.example.cupidshuffle.services;

import com.example.cupidshuffle.model.UserProfilesAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserProfileService {
    /**
     * https://gist.githubusercontent.com/InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/e784eafea0d9ff8f64be49e4c17840e00cd4b4c7/CupidShuffleProfiles.txt
     * https://gist.githubusercontent.com/InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/e784eafea0d9ff8f64be49e4c17840e00cd4b4c7/CupidShuffleProfiles.txt
     * InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/e784eafea0d9ff8f64be49e4c17840e00cd4b4c7/CupidShuffleProfiles.txt
     * https://gist.githubusercontent.com/InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/f421e0b2841328a9044fd0147fdf0d82020a59c7/CupidShuffleProfiles.txt
     * https://gist.githubusercontent.com/InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/6167db52c567774d8d17271f8554d457eaffe69f/CupidShuffleProfiles.txt
     * @return
     */
    @GET("InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/0ffdbd726b13c55ad1e0ed15b4fb392a5d011b8b/CupidShuffleProfiles.txt")
    Call<UserProfilesAPI> getProfiles();
}
