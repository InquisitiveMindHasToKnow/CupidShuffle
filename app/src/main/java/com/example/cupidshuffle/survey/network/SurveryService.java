package com.example.cupidshuffle.survey.network;

import com.example.cupidshuffle.survey.model.Questionaire;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SurveryService {
    @GET("b0174113e9f67cb0640896d73a3907bd/raw/d73e51e78dd1249a5e9c60049383f0ec5f3a0e19/Cupid%2520Shuffle%2520Questionnaire")
    Call<Questionaire> getQuestionaire();
}
