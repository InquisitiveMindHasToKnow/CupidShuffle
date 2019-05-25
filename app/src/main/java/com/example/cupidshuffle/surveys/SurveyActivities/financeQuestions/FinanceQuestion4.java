package com.example.cupidshuffle.surveys.SurveyActivities.financeQuestions;

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


public class FinanceQuestion4 extends AppCompatActivity {
    private String[] financeQuestions;
    private String[] financeQuestion4_choices;

    private TextView financeQuestion4;

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
        setContentView(R.layout.activity_finance_question4);

        financeQuestions = getResources().getStringArray(R.array.finance_surveyQuestions_array);
        financeQuestion4_choices = getResources().getStringArray(R.array.finance_surveyChoices_question4_array);

        findViews();
        setViews();
    }

    private void setViews() {
        financeQuestion4.setText(financeQuestions[3]);

        yourChoice1.setText(financeQuestion4_choices[0]);
        yourChoice2.setText(financeQuestion4_choices[1]);

        acceptedChoice1.setText(financeQuestion4_choices[0]);
        acceptedChoice2.setText(financeQuestion4_choices[1]);

        yourChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.finance_question2_yourChoice1_button:

                        break;
                    case R.id.finance_question2_yourChoice2_button:

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
                Intent saveIntent = new Intent(FinanceQuestion4.this, FinanceQuestion5.class);
                //LOGIC TO SAVE RESPONSES HERE!!
                startActivity(saveIntent);
            }
        });

        skipAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipIntent = new Intent(FinanceQuestion4.this, FinanceQuestion5.class);
                startActivity(skipIntent);
            }
        });

    }

    private void findViews() {
        financeQuestion4 = findViewById(R.id.finance_question4_text);

        yourChoices = findViewById(R.id.finance_question4_radioGroup);
        yourChoice1 = findViewById(R.id.finance_question4_yourChoice1_button);
        yourChoice2 = findViewById(R.id.finance_question4_yourChoice2_button);

        acceptedChoice1 = findViewById(R.id.finance_question4_acceptedChoice1_checkbox);
        acceptedChoice2 = findViewById(R.id.finance_question4_acceptedChoice2_checkbox);

        explainAnswer = findViewById(R.id.explainAnswer_finance4_editText);
        revealAnswerSwitch = findViewById(R.id.questionPrivacy_finance4_toggleSwitch);

        saveAnswer = findViewById(R.id.save_finance_Question4_button);
        skipAnswer = findViewById(R.id.skip_finance_Question4_button);
    }
}