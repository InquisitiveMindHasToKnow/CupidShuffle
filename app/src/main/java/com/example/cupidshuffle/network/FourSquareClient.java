package com.example.cupidshuffle.network;

import com.example.cupidshuffle.model.FourSquareResponse;
import com.example.cupidshuffle.services.CategoryService;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FourSquareClient {
    public static final String BASE_URL = "https://api.foursquare.com/v2/";
    private static FourSquareClient instance;
    private Retrofit retrofit;


    public static FourSquareClient getInstance(){
        if (instance == null){
            instance = new FourSquareClient();
        }
        return instance;
    }

    private FourSquareClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    private CategoryService getCategoryService(){
        return retrofit.create(CategoryService.class);
    }

    public Call<FourSquareResponse> getCategoryResponse(){
        return getCategoryService().getFourSquareResponse();
    }
}
