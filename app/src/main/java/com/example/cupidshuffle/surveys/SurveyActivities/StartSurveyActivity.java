package com.example.cupidshuffle.surveys.SurveyActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.surveys.SurveyActivities.generalInterestQuestions.GeneralInterestQuestion1;


public class StartSurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_survey);

        Intent startSurveyIntent = new Intent(StartSurveyActivity.this, GeneralInterestQuestion1.class);
    }
}
