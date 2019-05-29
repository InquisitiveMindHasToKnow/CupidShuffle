package com.example.cupidshuffle.network;

import com.example.cupidshuffle.model.FourSquarePhotoResponse;
import com.example.cupidshuffle.model.SearchVenuesResponse;
import com.example.cupidshuffle.services.FourSquareService;

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

    private FourSquareService getFourSquareService(){
        return retrofit.create(FourSquareService.class);
    }


    public Call<SearchVenuesResponse> getVenues(String topCategoryOne,String topCategoryTwo,String topCategoryThree){
        return getFourSquareService().getVenues(topCategoryOne,topCategoryTwo,topCategoryThree);
    }

    public Call<FourSquarePhotoResponse> getPhotos(String venueId){
        return getFourSquareService().getPhotos(venueId);
    }
}
