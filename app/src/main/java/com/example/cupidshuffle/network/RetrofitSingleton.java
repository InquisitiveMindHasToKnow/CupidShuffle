package com.example.cupidshuffle.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "https://gist.githubusercontent.com/";
    private static Retrofit retrofit;

    private static RetrofitSingleton instance;

    public static RetrofitSingleton getInstance(){
        if (instance == null){
            return new RetrofitSingleton();
        }
        return instance;
    }

    public static Retrofit getSinglenstance() {
        if (retrofit != null) {
            return retrofit;
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }



}
