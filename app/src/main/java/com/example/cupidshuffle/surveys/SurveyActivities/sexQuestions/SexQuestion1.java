package com.example.cupidshuffle.surveys.SurveyActivities.sexQuestions;

import android.content.Intent;
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


public class SexQuestion1 extends AppCompatActivity {
    private String[] sexQuestions;
    private String[] sexQuestion1_choices;

    private TextView sexQuestion1;

    private RadioGroup yourChoices;
    private RadioButton yourChoice1;
    private RadioButton yourChoice2;

    private CheckBox acceptedChoice1;
    private CheckBox acceptedChoice2;

    private EditText explainAnswer;

    private Switch revealAnswerSwitch;

    private Button saveAnswer;
    private Button skipAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex_question1);

        sexQuestions = getResources().getStringArray(R.array.sex_surveyQuestions_array);
        sexQuestion1_choices = getResources().getStringArray(R.array.sex_surveyChoices_question1_array);

        findViews();
        setViews();
    }

    private void setViews() {
        sexQuestion1.setText(sexQuestions[0]);

        yourChoice1.setText(sexQuestion1_choices[0]);
        yourChoice2.setText(sexQuestion1_choices[1]);

        acceptedChoice1.setText(sexQuestion1_choices[0]);
        acceptedChoice2.setText(sexQuestion1_choices[1]);

        yourChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sex_question1_yourChoice1_button:

                        break;
                    case R.id.sex_question1_yourChoice2_button:

                        break;
                }
            }
        });

        //CAN I PLACE THESE INTO A SWITCH CASE?!
        if (acceptedChoice1.isChecked()) {
            //save answer
        }
        if (acceptedChoice2.isChecked()) {
            //save answer
        }

        explainAnswer.getText();

        revealAnswerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
            }
        });

        saveAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveIntent = new Intent(SexQuestion1.this, SexQuestion2.class);
                //LOGIC TO SAVE RESPONSES HERE!!
                startActivity(saveIntent);
            }
        });

        skipAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipIntent = new Intent(SexQuestion1.this, SexQuestion2.class);
                startActivity(skipIntent);
            }
        });

    }

    private void findViews() {
        sexQuestion1 = findViewById(R.id.sex_question1_text);

        yourChoices = findViewById(R.id.sex_question1_radioGroup);
        yourChoice1 = findViewById(R.id.sex_question1_yourChoice1_button);
        yourChoice2 = findViewById(R.id.sex_question1_yourChoice2_button);

        acceptedChoice1 = findViewById(R.id.sex_question1_acceptedChoice1_checkbox);
        acceptedChoice2 = findViewById(R.id.sex_question1_acceptedChoice2_checkbox);

        explainAnswer = findViewById(R.id.explainAnswer_sex1_editText);
        revealAnswerSwitch = findViewById(R.id.questionPrivacy_sex1_toggleSwitch);

        saveAnswer = findViewById(R.id.save_sex_Question1_button);
        skipAnswer = findViewById(R.id.skip_sex_Question1_button);
    }
}