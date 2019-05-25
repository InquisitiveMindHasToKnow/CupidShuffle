package com.example.cupidshuffle.surveys.SurveyActivities.cultureQuestions;

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


public class CultureQuestion1 extends AppCompatActivity {
    private String[] cultureQuestions;
    private String[] cultureQuestion1_choices;

    private TextView cultureQuestion1;

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
        setContentView(R.layout.activity_culture_question1);

        cultureQuestions = getResources().getStringArray(R.array.culture_surveyQuestions_array);
        cultureQuestion1_choices = getResources().getStringArray(R.array.culture_surveyChoices_question1_array);

        findViews();
        setViews();
    }

    private void setViews() {
        cultureQuestion1.setText(cultureQuestions[0]);

        yourChoice1.setText(cultureQuestion1_choices[0]);
        yourChoice2.setText(cultureQuestion1_choices[1]);
        yourChoice3.setText(cultureQuestion1_choices[2]);
        yourChoice4.setText(cultureQuestion1_choices[3]);

        acceptedChoice1.setText(cultureQuestion1_choices[0]);
        acceptedChoice2.setText(cultureQuestion1_choices[1]);
        acceptedChoice3.setText(cultureQuestion1_choices[2]);
        acceptedChoice4.setText(cultureQuestion1_choices[3]);

        yourChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.cultureLifestyle_question1_yourChoice1_button:

                        break;
                    case R.id.cultureLifestyle_question1_yourChoice2_button:

                        break;
                    case R.id.cultureLifestyle_question1_yourChoice3_button:

                        break;
                    case R.id.cultureLifestyle_question1_yourChoice4_button:

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
        if (acceptedChoice3.isChecked()) {
            //save answer
        }
        if (acceptedChoice4.isChecked()) {
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
                Intent saveIntent = new Intent(CultureQuestion1.this, CultureQuestion2.class);
                //LOGIC TO SAVE RESPONSES HERE!!
                startActivity(saveIntent);
            }
        });

        skipAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipIntent = new Intent(CultureQuestion1.this, CultureQuestion2.class);
                startActivity(skipIntent);
            }
        });

    }

    private void findViews() {
        cultureQuestion1 = findViewById(R.id.cultureLifestyle_question1_text);

        yourChoices = findViewById(R.id.cultureLifestyle_question1_radioGroup);
        yourChoice1 = findViewById(R.id.cultureLifestyle_question1_yourChoice1_button);
        yourChoice2 = findViewById(R.id.cultureLifestyle_question1_yourChoice2_button);
        yourChoice3 = findViewById(R.id.cultureLifestyle_question1_yourChoice3_button);
        yourChoice4 = findViewById(R.id.cultureLifestyle_question1_yourChoice4_button);

        acceptedChoice1 = findViewById(R.id.cultureLifestyle_question1_acceptedChoice1_checkbox);
        acceptedChoice2 = findViewById(R.id.cultureLifestyle_question1_acceptedChoice2_checkbox);
        acceptedChoice3 = findViewById(R.id.cultureLifestyle_question1_acceptedChoice3_checkbox);
        acceptedChoice4 = findViewById(R.id.cultureLifestyle_question1_acceptedChoice4_checkbox);

        explainAnswer = findViewById(R.id.explainAnswer_cL1_editText);
        revealAnswerSwitch = findViewById(R.id.questionPrivacy_cL1_toggleSwitch);

        saveAnswer = findViewById(R.id.save_cL_Question1_button);
        skipAnswer = findViewById(R.id.skip_cL_Question1_button);
    }
}

