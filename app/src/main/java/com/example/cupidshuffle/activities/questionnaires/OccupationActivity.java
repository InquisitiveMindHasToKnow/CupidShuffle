package com.example.cupidshuffle.activities.questionnaires;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cupidshuffle.R;

public class OccupationActivity extends AppCompatActivity {
    private static final String USER_PREFS_KEY = "user shared preference";
    private static final String OCCUPATION_KEY = "user occupation";
    private EditText occupationEditText;
    private Button occupationSubmitButton;
    private SharedPreferences userSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupation);

        occupationEditText = findViewById(R.id.occupation_editText);
        occupationSubmitButton = findViewById(R.id.occupation_submitButton);

        SharedPreferences userSharedPreferences = getApplicationContext().getSharedPreferences(USER_PREFS_KEY, MODE_PRIVATE);
        final SharedPreferences.Editor editor = userSharedPreferences.edit();

        occupationSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String occupation = occupationEditText.getText().toString();
                editor.putString(OCCUPATION_KEY,occupation);
                editor.apply();
                Intent intent = new Intent(OccupationActivity.this,CreateProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
