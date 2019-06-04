package com.example.cupidshuffle.SurveyActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.SurveyActivities.generalInterestQuestions.GeneralInterestQuestion1;


public class StartSurveyActivity extends AppCompatActivity {
    private Button startSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_survey);

        startSurvey = findViewById(R.id.startSurvey_startButton);
        startSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSurveyIntent = new Intent(StartSurveyActivity.this, GeneralInterestQuestion1.class);
                startActivity(startSurveyIntent);
            }
        });

    }
}
