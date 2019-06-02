package com.example.cupidshuffle.surveys.SurveyActivities.sexQuestions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.cupidshuffle.R;


public class SexQuestion4 extends AppCompatActivity {
    private static final String USER_PREFS_KEY = "user shared preference";

    private static final String USER_CHOICE1_KEY = "question 4 user choice 1";
    private static final String USER_CHOICE2_KEY = "question 4 user choice 2";
    private static final String USER_CHOICE3_KEY = "question 4 user choice 3";
    private static final String USER_CHOICE4_KEY = "question 4 user choice 4";

    private static final String USER_ACCEPTED_CHOICE1_KEY = "question 4 accepted choice 1";
    private static final String USER_ACCEPTED_CHOICE2_KEY = "question 4 accepted choice 2";
    private static final String USER_ACCEPTED_CHOICE3_KEY = "question 4 accepted choice 3";
    private static final String USER_ACCEPTED_CHOICE4_KEY = "question 4 accepted choice 4";

    private static final String USER_EXPLAIN_ANSWER_KEY = "question 4 explanation";

    private String[] sexQuestions;
    private String[] sexQuestion4_choices;

    private TextView sexQuestion4;

    private RadioGroup yourChoices;
    private RadioButton yourChoice1;
    private RadioButton yourChoice2;
    private RadioButton yourChoice3;
    private RadioButton yourChoice4;

    private CheckBox acceptedChoice1;
    private CheckBox acceptedChoice2;
    private CheckBox acceptedChoice3;
    private CheckBox acceptedChoice4;

    private EditText explainAnswer;

    private Switch revealAnswerSwitch;

    private Button saveAnswer;
    private Button skipAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex_question4);

        sexQuestions = getResources().getStringArray(R.array.sex_surveyQuestions_array);
        sexQuestion4_choices = getResources().getStringArray(R.array.sex_surveyChoices_question4_array);

        findViews();
        setViews();
    }

    private void setViews() {
        sexQuestion4.setText(sexQuestions[3]);

        yourChoice1.setText(sexQuestion4_choices[0]);
        yourChoice2.setText(sexQuestion4_choices[1]);
        yourChoice3.setText(sexQuestion4_choices[2]);
        yourChoice4.setText(sexQuestion4_choices[3]);

        acceptedChoice1.setText(sexQuestion4_choices[0]);
        acceptedChoice2.setText(sexQuestion4_choices[1]);
        acceptedChoice3.setText(sexQuestion4_choices[2]);
        acceptedChoice4.setText(sexQuestion4_choices[3]);

        SharedPreferences userSharedPreferences = getApplicationContext().getSharedPreferences(USER_PREFS_KEY, MODE_PRIVATE);
        final SharedPreferences.Editor editor = userSharedPreferences.edit();

        yourChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sex_question4_yourChoice1_button:
                        editor.putString(USER_CHOICE1_KEY, yourChoice1.getText().toString());
                        break;

                    case R.id.sex_question4_yourChoice2_button:
                        editor.putString(USER_CHOICE2_KEY, yourChoice2.getText().toString());
                        break;

                    case R.id.sex_question4_yourChoice3_button:
                        editor.putString(USER_CHOICE3_KEY, yourChoice3.getText().toString());
                        break;

                    case R.id.sex_question4_yourChoice4_button:
                        editor.putString(USER_CHOICE4_KEY, yourChoice4.getText().toString());
                        break;
                }
            }
        });

        //CAN I PLACE THESE INTO A SWITCH CASE?!
        if (acceptedChoice1.isChecked()) {
            editor.putString(USER_ACCEPTED_CHOICE1_KEY, acceptedChoice1.getText().toString());
        }
        if (acceptedChoice2.isChecked()) {
            editor.putString(USER_ACCEPTED_CHOICE2_KEY, acceptedChoice2.getText().toString());
        }
        if (acceptedChoice3.isChecked()) {
            editor.putString(USER_ACCEPTED_CHOICE3_KEY, acceptedChoice3.getText().toString());
        }
        if (acceptedChoice4.isChecked()) {
            editor.putString(USER_ACCEPTED_CHOICE4_KEY, acceptedChoice4.getText().toString());
        }

        editor.putString(USER_EXPLAIN_ANSWER_KEY, explainAnswer.getText().toString());

        revealAnswerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // hide answer from profile;
                    // the isChecked will be true if the switch is in the On position
                }
            }
        });

        saveAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveIntent = new Intent(SexQuestion4.this, SexQuestion5.class);
                editor.apply();
                startActivity(saveIntent);
            }
        });

        skipAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipIntent = new Intent(SexQuestion4.this, SexQuestion5.class);
                startActivity(skipIntent);
            }
        });

    }

    private void findViews() {
        sexQuestion4 = findViewById(R.id.sex_question4_text);

        yourChoices = findViewById(R.id.sex_question4_radioGroup);
        yourChoice1 = findViewById(R.id.sex_question4_yourChoice1_button);
        yourChoice2 = findViewById(R.id.sex_question4_yourChoice2_button);
        yourChoice3 = findViewById(R.id.sex_question4_yourChoice3_button);
        yourChoice4 = findViewById(R.id.sex_question4_yourChoice4_button);

        acceptedChoice1 = findViewById(R.id.sex_question4_acceptedChoice1_checkbox);
        acceptedChoice2 = findViewById(R.id.sex_question4_acceptedChoice2_checkbox);
        acceptedChoice3 = findViewById(R.id.sex_question4_acceptedChoice3_checkbox);
        acceptedChoice4 = findViewById(R.id.sex_question4_acceptedChoice4_checkbox);

        explainAnswer = findViewById(R.id.explainAnswer_sex4_editText);
        revealAnswerSwitch = findViewById(R.id.questionPrivacy_sex4_toggleSwitch);

        saveAnswer = findViewById(R.id.save_sex_Question4_button);
        skipAnswer = findViewById(R.id.skip_sex_Question4_button);
    }
}
