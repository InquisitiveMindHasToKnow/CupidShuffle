package com.example.cupidshuffle.services;

import com.example.cupidshuffle.model.ConnectorAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConnectionRequestService {

    @GET("InquisitiveMindHasToKnow/8a0590599fc678a9676d67ee3401dab3/raw/f762cca1880c8905fe9c37b8dbb31fb3d9cd76b5/CupidShuffleRequests")
    Call<ConnectorAPI> getConnectRequest();
}
