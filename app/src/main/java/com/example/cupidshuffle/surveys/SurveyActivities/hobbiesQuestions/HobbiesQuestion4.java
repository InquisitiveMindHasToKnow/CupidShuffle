package com.example.cupidshuffle.surveys.SurveyActivities.hobbiesQuestions;

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


public class HobbiesQuestion4 extends AppCompatActivity {
    private String[] hobbiesQuestions;
    private String[] hobbiesQuestion4_choices;

    private TextView hobbiesQuestion4;

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
        setContentView(R.layout.activity_hobbies_question4);

        hobbiesQuestions = getResources().getStringArray(R.array.hobbies_surveyQuestions_array);
        hobbiesQuestion4_choices = getResources().getStringArray(R.array.hobbies_surveyChoices_question4_array);

        findViews();
        setViews();
    }

    private void setViews() {
        hobbiesQuestion4.setText(hobbiesQuestions[3]);

        yourChoice1.setText(hobbiesQuestion4_choices[0]);
        yourChoice2.setText(hobbiesQuestion4_choices[1]);
        yourChoice3.setText(hobbiesQuestion4_choices[2]);

        acceptedChoice1.setText(hobbiesQuestion4_choices[0]);
        acceptedChoice2.setText(hobbiesQuestion4_choices[1]);
        acceptedChoice3.setText(hobbiesQuestion4_choices[2]);

        yourChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.hobbies_question4_yourChoice1_button:

                        break;
                    case R.id.hobbies_question4_yourChoice2_button:

                        break;
                    case R.id.hobbies_question4_yourChoice3_button:

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
                Intent saveIntent = new Intent(HobbiesQuestion4.this, HobbiesQuestion5.class);
                //LOGIC TO SAVE RESPONSES HERE!!
                startActivity(saveIntent);
            }
        });

        skipAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipIntent = new Intent(HobbiesQuestion4.this, HobbiesQuestion5.class);
                startActivity(skipIntent);
            }
        });

    }

    private void findViews() {
        hobbiesQuestion4 = findViewById(R.id.hobbies_question4_text);

        yourChoices = findViewById(R.id.hobbies_question4_radioGroup);
        yourChoice1 = findViewById(R.id.hobbies_question4_yourChoice1_button);
        yourChoice2 = findViewById(R.id.hobbies_question4_yourChoice2_button);
        yourChoice3 = findViewById(R.id.hobbies_question4_yourChoice3_button);

        acceptedChoice1 = findViewById(R.id.hobbies_question4_acceptedChoice1_checkbox);
        acceptedChoice2 = findViewById(R.id.hobbies_question4_acceptedChoice2_checkbox);
        acceptedChoice3 = findViewById(R.id.hobbies_question4_acceptedChoice3_checkbox);

        explainAnswer = findViewById(R.id.explainAnswer_hobbies4_editText);
        revealAnswerSwitch = findViewById(R.id.questionPrivacy_hobbies4_toggleSwitch);

        saveAnswer = findViewById(R.id.save_hobbies_Question4_button);
        skipAnswer = findViewById(R.id.skip_hobbies_Question4_button);
    }
}