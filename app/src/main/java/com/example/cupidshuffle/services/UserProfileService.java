package com.example.cupidshuffle.services;

import com.example.cupidshuffle.model.UserProfilesAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserProfileService {
    /**
     * https://gist.githubusercontent.com/InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/e784eafea0d9ff8f64be49e4c17840e00cd4b4c7/CupidShuffleProfiles.txt
     * https://gist.githubusercontent.com/InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/e784eafea0d9ff8f64be49e4c17840e00cd4b4c7/CupidShuffleProfiles.txt
     * InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/e784eafea0d9ff8f64be49e4c17840e00cd4b4c7/CupidShuffleProfiles.txt
     * @return
     */
    @GET("InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/6b9c895d7ee965e4d6f1f8192504deba49df8bb9/CupidShuffleProfiles.txt")
    Call<UserProfilesAPI> getProfiles();
}
