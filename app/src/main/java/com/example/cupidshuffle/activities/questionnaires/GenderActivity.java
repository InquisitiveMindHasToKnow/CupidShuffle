package com.example.cupidshuffle.activities.questionnaires;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.LoginActivity;

public class GenderActivity extends AppCompatActivity {
    private static final String USER_PREFS_KEY = "user shared preference";
    private static final String USER_GENDER_KEY = "user gender";
    private static final String NEW_USER_KEY = "NEW USER KEY";
    private SharedPreferences userSharedPreferences;
    private Button maleButton;
    private Button femaleButton;
    private Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionairre);
        maleButton = findViewById(R.id.male_button);
        femaleButton = findViewById(R.id.female_button);

        userSharedPreferences = getApplicationContext().getSharedPreferences(USER_PREFS_KEY, MODE_PRIVATE);
        final SharedPreferences.Editor editor = userSharedPreferences.edit();


        if (userSharedPreferences.getBoolean(NEW_USER_KEY, false)){
            Intent intent = new Intent(GenderActivity.this, LoginActivity.class);
            startActivity(intent);

        }

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(USER_GENDER_KEY,"Male");
                editor.putBoolean(NEW_USER_KEY,true);
                editor.apply();
                intent = new Intent(GenderActivity.this, AgeActivity.class);
                startActivity(intent);
            }
        });


        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(USER_GENDER_KEY,"Female");
                editor.putBoolean(NEW_USER_KEY,true);
                editor.apply();
                intent = new Intent(GenderActivity.this, AgeActivity.class);
                startActivity(intent);
            }
        });

    }


}
