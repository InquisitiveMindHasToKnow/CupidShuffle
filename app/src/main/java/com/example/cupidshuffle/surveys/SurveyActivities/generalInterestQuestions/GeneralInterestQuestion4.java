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


public class GeneralInterestQuestion4 extends AppCompatActivity {
    private String[] generalInterestQuestions;
    private String[] generalInterestQuestion4_choices;

    private TextView generalQuestion4;

    private RadioGroup yourChoices;
    private RadioButton yourChoice1;
    private RadioButton yourChoice2;
    private RadioButton yourChoice3;
    private RadioButton yourChoice4;
    private RadioButton yourChoice5;

    private CheckBox acceptedChoice1;
    private CheckBox acceptedChoice2;
    private CheckBox acceptedChoice3;
    private CheckBox acceptedChoice4;
    private CheckBox acceptedChoice5;

    private EditText explainAnswer;

    private Switch revealAnswerSwitch;

    private Button saveAnswer;
    private Button skipAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_interest_question4);

        generalInterestQuestions = getResources().getStringArray(R.array.generalInterest_surveyQuestions_array);
        generalInterestQuestion4_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question4_array);

        findViews();
        setViews();
    }

    private void setViews() {
        generalQuestion4.setText(generalInterestQuestions[3]);

        yourChoice1.setText(generalInterestQuestion4_choices[0]);
        yourChoice2.setText(generalInterestQuestion4_choices[1]);
        yourChoice3.setText(generalInterestQuestion4_choices[2]);
        yourChoice4.setText(generalInterestQuestion4_choices[3]);
        yourChoice5.setText(generalInterestQuestion4_choices[4]);

        acceptedChoice1.setText(generalInterestQuestion4_choices[0]);
        acceptedChoice2.setText(generalInterestQuestion4_choices[1]);
        acceptedChoice3.setText(generalInterestQuestion4_choices[2]);
        acceptedChoice4.setText(generalInterestQuestion4_choices[3]);
        acceptedChoice5.setText(generalInterestQuestion4_choices[4]);

        yourChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.generalInterest_question4_yourChoice1_button:

                        break;
                    case R.id.generalInterest_question4_yourChoice2_button:

                        break;
                    case R.id.generalInterest_question4_yourChoice3_button:

                        break;
                    case R.id.generalInterest_question4_yourChoice4_button:

                        break;
                    case R.id.generalInterest_question4_yourChoice5_button:

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
                Intent saveIntent = new Intent(GeneralInterestQuestion4.this, GeneralInterestQuestion5.class);
                //LOGIC TO SAVE RESPONSES HERE!!
                startActivity(saveIntent);
            }
        });

        skipAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipIntent = new Intent(GeneralInterestQuestion4.this, GeneralInterestQuestion5.class);
                startActivity(skipIntent);
            }
        });

    }

    private void findViews() {
        generalQuestion4 = findViewById(R.id.generalInterest_question4_text);

        yourChoices = findViewById(R.id.generalInterest_question4_radioGroup);
        yourChoice1 = findViewById(R.id.generalInterest_question4_yourChoice1_button);
        yourChoice2 = findViewById(R.id.generalInterest_question4_yourChoice2_button);
        yourChoice3 = findViewById(R.id.generalInterest_question4_yourChoice3_button);
        yourChoice4 = findViewById(R.id.generalInterest_question4_yourChoice4_button);
        yourChoice5 = findViewById(R.id.generalInterest_question4_yourChoice5_button);

        acceptedChoice1 = findViewById(R.id.generalInterest_question4_acceptedChoice1_checkbox);
        acceptedChoice2 = findViewById(R.id.generalInterest_question4_acceptedChoice2_checkbox);
        acceptedChoice3 = findViewById(R.id.generalInterest_question4_acceptedChoice3_checkbox);
        acceptedChoice4 = findViewById(R.id.generalInterest_question4_acceptedChoice4_checkbox);
        acceptedChoice5 = findViewById(R.id.generalInterest_question4_acceptedChoice5_checkbox);

        explainAnswer = findViewById(R.id.explainAnswer_gI4_editText);
        revealAnswerSwitch = findViewById(R.id.questionPrivacy_gI4_toggleSwitch);

        saveAnswer = findViewById(R.id.save_gI_Question4_button);
        skipAnswer = findViewById(R.id.skip_gI_Question4_button);
    }
}
