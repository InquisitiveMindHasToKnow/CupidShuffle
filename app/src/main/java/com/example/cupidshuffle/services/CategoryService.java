package com.example.cupidshuffle.services;

import com.example.cupidshuffle.model.FourSquareResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
    @GET("venues/categories?client_id=QC31QQ55L51RLZ2NA1LMOHGMYYLCYUCPF01SB5F0LRGUEBMW&client_secret=T5WNDOLGTJIBSII2NVACH0WD0UMOMWMIXRBXB3CRSNIAJQI1&v=20190512")
    Call<FourSquareResponse>getFourSquareResponse();
}
