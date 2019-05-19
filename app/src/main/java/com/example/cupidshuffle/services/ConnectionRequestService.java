package com.example.cupidshuffle.services;

import com.example.cupidshuffle.model.ConnectorAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConnectionRequestService {

    @GET("InquisitiveMindHasToKnow/8a0590599fc678a9676d67ee3401dab3/raw/ff8affe9025e5001241e6f304ab4c8d3abf3b32b/CupidShuffleRequests")
    Call<ConnectorAPI> getConnectRequest();
}
