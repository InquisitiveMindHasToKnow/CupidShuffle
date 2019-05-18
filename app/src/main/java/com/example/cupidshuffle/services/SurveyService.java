package com.example.cupidshuffle.services;

import com.example.cupidshuffle.surveys.models.QuestionaireList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SurveyService {
    @GET("b0174113e9f67cb0640896d73a3907bd/raw/f739ae80c2baead33ae3b9dadaa353474e4e02bc/Cupid%2520Shuffle%2520Questionnaire")
    Call<QuestionaireList> getQuestionaire();
}
