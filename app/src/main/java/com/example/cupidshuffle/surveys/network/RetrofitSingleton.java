package com.example.cupidshuffle.surveys.network;

import com.example.cupidshuffle.surveys.models.Questionaire;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "https://gist.githubusercontent.com/sheriffameen/";
    private static Retrofit retrofit;

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

    private RetrofitSingleton() {
    }

    private SurveyService getSurveyService(){
        return retrofit.create(SurveyService.class);
    }

    public Call<Questionaire> getQuestionaireResponse(){
        return getSurveyService().getQuestionaire();
    }
}
