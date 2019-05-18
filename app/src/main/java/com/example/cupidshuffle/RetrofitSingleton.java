package com.example.cupidshuffle;

import com.example.cupidshuffle.services.SurveyService;
import com.example.cupidshuffle.surveys.models.QuestionaireList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "https://gist.githubusercontent.com/sheriffameen/";
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


    private SurveyService getSurveyService(){
        return retrofit.create(SurveyService.class);
    }

    public Call<QuestionaireList> getQuestionaireResponse(){
        return getSurveyService().getQuestionaire();
    }
}
