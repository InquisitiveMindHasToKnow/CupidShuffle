package com.example.cupidshuffle.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserProfileRetrofitSingleton {

        private static Retrofit retrofitInstance;

        private UserProfileRetrofitSingleton(){

        }

        public static Retrofit getRetrofitInstance() {
            if (retrofitInstance != null) {
                return retrofitInstance;
            }
            retrofitInstance = new Retrofit
                    .Builder()
                    .baseUrl("https://gist.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofitInstance;
        }
    }
