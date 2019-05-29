package com.example.cupidshuffle.services;


import com.example.cupidshuffle.model.FourSquarePhotoResponse;
import com.example.cupidshuffle.model.SearchVenuesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FourSquareService {

    @GET("venues/search?ll=40.7484,-73.9857&client_id=QC31QQ55L51RLZ2NA1LMOHGMYYLCYUCPF01SB5F0LRGUEBMW&client_secret=T5WNDOLGTJIBSII2NVACH0WD0UMOMWMIXRBXB3CRSNIAJQI1&v=20190512")
    Call<SearchVenuesResponse> getVenues(@Query("categoryId") String topCategoryOne,
                                         @Query("categoryId") String topCategoryTwo,
                                         @Query("categoryId") String topCategoryThree);

    @GET("venues/{venueId}/photos?client_id=QC31QQ55L51RLZ2NA1LMOHGMYYLCYUCPF01SB5F0LRGUEBMW&client_secret=T5WNDOLGTJIBSII2NVACH0WD0UMOMWMIXRBXB3CRSNIAJQI1&v=20190512")
    Call<FourSquarePhotoResponse>getPhotos(@Path("venueId") String venueId);
}
