package com.example.cupidshuffle.SurveyActivities.cultureQuestions;

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
import com.example.cupidshuffle.SurveyActivities.financeQuestions.FinanceQuestion1;


public class CultureQuestion5 extends AppCompatActivity {
    private static final String USER_PREFS_KEY = "user shared preference";

    private static final String USER_CHOICE1_KEY = "question 5 user choice 1";
    private static final String USER_CHOICE2_KEY = "question 5 user choice 2";
    private static final String USER_CHOICE3_KEY = "question 5 user choice 3";

    private static final String USER_ACCEPTED_CHOICE1_KEY = "question 5 accepted choice 1";
    private static final String USER_ACCEPTED_CHOICE2_KEY = "question 5 accepted choice 2";
    private static final String USER_ACCEPTED_CHOICE3_KEY = "question 5 accepted choice 3";

    private static final String USER_EXPLAIN_ANSWER_KEY = "question 5 explanation";

    private String[] cultureQuestions;
    private String[] cultureQuestion5_choices;

    private TextView cultureQuestion5;

    private RadioGroup yourChoices;
    private RadioButton yourChoice1;
    private RadioButton yourChoice2;
    private RadioButton yourChoice3;

    private CheckBox acceptedChoice1;
    private CheckBox acceptedChoice2;
    private CheckBox acceptedChoice3;

    private EditText explainAnswer;

    private Switch revealAnswerSwitch;

    private Button saveAnswer;
    private Button skipAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_question5);

        cultureQuestions = getResources().getStringArray(R.array.culture_surveyQuestions_array);
        cultureQuestion5_choices = getResources().getStringArray(R.array.culture_surveyChoices_question5_array);

        findViews();
        setViews();
    }

    private void setViews() {
        cultureQuestion5.setText(cultureQuestions[4]);

        yourChoice1.setText(cultureQuestion5_choices[0]);
        yourChoice2.setText(cultureQuestion5_choices[1]);
        yourChoice3.setText(cultureQuestion5_choices[2]);

        acceptedChoice1.setText(cultureQuestion5_choices[0]);
        acceptedChoice2.setText(cultureQuestion5_choices[1]);
        acceptedChoice3.setText(cultureQuestion5_choices[2]);

        SharedPreferences userSharedPreferences = getApplicationContext().getSharedPreferences(USER_PREFS_KEY, MODE_PRIVATE);
        final SharedPreferences.Editor editor = userSharedPreferences.edit();

        yourChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.cultureLifestyle_question3_yourChoice1_button:
                        editor.putString(USER_CHOICE1_KEY, yourChoice1.getText().toString());
                        break;

                    case R.id.cultureLifestyle_question3_yourChoice2_button:
                        editor.putString(USER_CHOICE2_KEY, yourChoice2.getText().toString());
                        break;

                    case R.id.cultureLifestyle_question3_yourChoice3_button:
                        editor.putString(USER_CHOICE3_KEY, yourChoice3.getText().toString());
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
                Intent saveIntent = new Intent(CultureQuestion5.this, FinanceQuestion1.class);
                editor.apply();
                CultureQuestion5.this.finish();
                startActivity(saveIntent);
            }
        });

        skipAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipIntent = new Intent(CultureQuestion5.this, FinanceQuestion1.class);
                CultureQuestion5.this.finish();
                startActivity(skipIntent);
            }
        });

    }

    private void findViews() {
        cultureQuestion5 = findViewById(R.id.cultureLifestyle_question5_text);

        yourChoices = findViewById(R.id.cultureLifestyle_question5_radioGroup);
        yourChoice1 = findViewById(R.id.cultureLifestyle_question5_yourChoice1_button);
        yourChoice2 = findViewById(R.id.cultureLifestyle_question5_yourChoice2_button);
        yourChoice3 = findViewById(R.id.cultureLifestyle_question5_yourChoice3_button);

        acceptedChoice1 = findViewById(R.id.cultureLifestyle_question5_acceptedChoice1_checkbox);
        acceptedChoice2 = findViewById(R.id.cultureLifestyle_question5_acceptedChoice2_checkbox);
        acceptedChoice3 = findViewById(R.id.cultureLifestyle_question5_acceptedChoice3_checkbox);

        explainAnswer = findViewById(R.id.explainAnswer_cL5_editText);
        revealAnswerSwitch = findViewById(R.id.questionPrivacy_cL5_toggleSwitch);

        saveAnswer = findViewById(R.id.save_cL_Question5_button);
        skipAnswer = findViewById(R.id.skip_cL_Question5_button);
    }
}
