package com.example.cupidshuffle.activities.questionnaires;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cupidshuffle.R;

public class AgeActivity extends AppCompatActivity {
    private static final String USER_PREFS_KEY = "user shared preference";
    private static final String USER_AGE_KEY = "user age";
    private EditText ageEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        ageEditText = findViewById(R.id.age_editText);
        Button ageSubmitButton = findViewById(R.id.ageSubmit_button);

        SharedPreferences userSharedPreferences = getApplicationContext().getSharedPreferences(USER_PREFS_KEY, MODE_PRIVATE);
        final SharedPreferences.Editor editor = userSharedPreferences.edit();

        ageSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.parseInt(ageEditText.getText().toString());
                editor.putInt(USER_AGE_KEY, age);
                editor.apply();
                Intent intent = new Intent(AgeActivity.this, OccupationActivity.class);
                startActivity(intent);

            }
        });
    }

}
