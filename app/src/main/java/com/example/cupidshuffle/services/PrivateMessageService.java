package com.example.cupidshuffle.services;

import com.example.cupidshuffle.model.PrivateMessagesAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PrivateMessageService {

    @GET("InquisitiveMindHasToKnow/4f808cbc3a5a334c36bd0f2e2a5ecb4f/raw/37e8efdef558ba37b8a3b89efbd7e727171c0711/messages")
    Call<PrivateMessagesAPI> getPrivateMessages();
}
