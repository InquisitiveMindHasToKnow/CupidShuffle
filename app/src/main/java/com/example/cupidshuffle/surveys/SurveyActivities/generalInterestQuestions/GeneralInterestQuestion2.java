package com.example.cupidshuffle.surveys.SurveyActivities.generalInterestQuestions;

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


public class GeneralInterestQuestion2 extends AppCompatActivity {
    private String[] generalInterestQuestions;
    private String[] generalInterestQuestion2_choices;

    private TextView generalQuestion2;

    private RadioGroup yourChoices;
    private RadioButton yourChoice1;
    private RadioButton yourChoice2;
    private RadioButton yourChoice3;
    private RadioButton yourChoice4;
    private RadioButton yourChoice5;
    private RadioButton yourChoice6;
    private RadioButton yourChoice7;
    private RadioButton yourChoice8;

    private CheckBox acceptedChoice1;
    private CheckBox acceptedChoice2;
    private CheckBox acceptedChoice3;
    private CheckBox acceptedChoice4;
    private CheckBox acceptedChoice5;
    private CheckBox acceptedChoice6;
    private CheckBox acceptedChoice7;
    private CheckBox acceptedChoice8;

    private EditText explainAnswer;

    private Switch revealAnswerSwitch;

    private Button saveAnswer;
    private Button skipAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_interest_question2);

        generalInterestQuestions = getResources().getStringArray(R.array.generalInterest_surveyQuestions_array);
        generalInterestQuestion2_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question2_array);

        findViews();
        setViews();
    }

    private void setViews() {
        generalQuestion2.setText(generalInterestQuestions[1]);

        yourChoice1.setText(generalInterestQuestion2_choices[0]);
        yourChoice2.setText(generalInterestQuestion2_choices[1]);
        yourChoice3.setText(generalInterestQuestion2_choices[2]);
        yourChoice4.setText(generalInterestQuestion2_choices[3]);
        yourChoice5.setText(generalInterestQuestion2_choices[4]);
        yourChoice6.setText(generalInterestQuestion2_choices[5]);
        yourChoice7.setText(generalInterestQuestion2_choices[6]);
        yourChoice8.setText(generalInterestQuestion2_choices[7]);

        acceptedChoice1.setText(generalInterestQuestion2_choices[0]);
        acceptedChoice2.setText(generalInterestQuestion2_choices[1]);
        acceptedChoice3.setText(generalInterestQuestion2_choices[2]);
        acceptedChoice4.setText(generalInterestQuestion2_choices[3]);
        acceptedChoice5.setText(generalInterestQuestion2_choices[4]);
        acceptedChoice6.setText(generalInterestQuestion2_choices[5]);
        acceptedChoice7.setText(generalInterestQuestion2_choices[6]);
        acceptedChoice8.setText(generalInterestQuestion2_choices[7]);

        yourChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.generalInterest_question2_yourChoice1_button:

                        break;
                    case R.id.generalInterest_question2_yourChoice2_button:

                        break;
                    case R.id.generalInterest_question2_yourChoice3_button:

                        break;
                    case R.id.generalInterest_question2_yourChoice4_button:

                        break;
                    case R.id.generalInterest_question2_yourChoice5_button:

                        break;
                    case R.id.generalInterest_question2_yourChoice6_button:

                        break;
                    case R.id.generalInterest_question2_yourChoice7_button:

                        break;
                        case R.id.generalInterest_question2_yourChoice8_button:

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
        if (acceptedChoice5.isChecked()) {
            //save answer
        }
        if (acceptedChoice6.isChecked()) {
            //save answer
        }
        if (acceptedChoice7.isChecked()) {
            //save answer
        }
        if (acceptedChoice8.isChecked()) {
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
                Intent saveIntent = new Intent(GeneralInterestQuestion2.this, GeneralInterestQuestion3.class);
                //LOGIC TO SAVE RESPONSES HERE!!
                startActivity(saveIntent);
            }
        });

        skipAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipIntent = new Intent(GeneralInterestQuestion2.this, GeneralInterestQuestion3.class);
                startActivity(skipIntent);
            }
        });

    }

    private void findViews() {
        generalQuestion2 = findViewById(R.id.generalInterest_question2_text);

        yourChoices = findViewById(R.id.generalInterest_question2_radioGroup);
        yourChoice1 = findViewById(R.id.generalInterest_question2_yourChoice1_button);
        yourChoice2 = findViewById(R.id.generalInterest_question2_yourChoice2_button);
        yourChoice3 = findViewById(R.id.generalInterest_question2_yourChoice3_button);
        yourChoice4 = findViewById(R.id.generalInterest_question2_yourChoice4_button);
        yourChoice5 = findViewById(R.id.generalInterest_question2_yourChoice5_button);
        yourChoice6 = findViewById(R.id.generalInterest_question2_yourChoice6_button);
        yourChoice7 = findViewById(R.id.generalInterest_question2_yourChoice7_button);
        yourChoice8 = findViewById(R.id.generalInterest_question2_yourChoice8_button);

        acceptedChoice1 = findViewById(R.id.generalInterest_question2_acceptedChoice1_checkbox);
        acceptedChoice2 = findViewById(R.id.generalInterest_question2_acceptedChoice2_checkbox);
        acceptedChoice3 = findViewById(R.id.generalInterest_question2_acceptedChoice3_checkbox);
        acceptedChoice4 = findViewById(R.id.generalInterest_question2_acceptedChoice4_checkbox);
        acceptedChoice5 = findViewById(R.id.generalInterest_question2_acceptedChoice5_checkbox);
        acceptedChoice6 = findViewById(R.id.generalInterest_question2_acceptedChoice6_checkbox);
        acceptedChoice7 = findViewById(R.id.generalInterest_question2_acceptedChoice7_checkbox);
        acceptedChoice8 = findViewById(R.id.generalInterest_question2_acceptedChoice8_checkbox);

        explainAnswer = findViewById(R.id.explainAnswer_gI2_editText);
        revealAnswerSwitch = findViewById(R.id.questionPrivacy_gI2_toggleSwitch);

        saveAnswer = findViewById(R.id.save_gI_Question2_button);
        skipAnswer = findViewById(R.id.skip_gI_Question2_button);
    }
}