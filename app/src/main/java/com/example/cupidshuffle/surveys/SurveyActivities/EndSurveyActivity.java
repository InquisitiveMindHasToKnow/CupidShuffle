package com.example.cupidshuffle.surveys.SurveyActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.FragmentHolder;


public class EndSurveyActivity extends AppCompatActivity {
    private Button endSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_survey);

        endSurvey = findViewById(R.id.endSurvey_nextButton);
        endSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent endSurveyIntent = new Intent(EndSurveyActivity.this, FragmentHolder.class);
                startActivity(endSurveyIntent);
            }
        });

    }
}
