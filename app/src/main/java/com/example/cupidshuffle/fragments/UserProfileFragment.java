package com.example.cupidshuffle.fragments;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cupidshuffle.R;

public class UserProfileFragment extends Fragment {
    private String[] generalInterestQuestions;
    private String[] hobbiesQuestions;
    private String[] cultureLifestyleQuestions;
    private String[] financeQuestions;
    private String[] sexQuestions;

    private String[] generalInterest_1_choices;
    private String[] generalInterest_2_choices;
    private String[] generalInterest_3_choices;
    private String[] generalInterest_4_choices;
    private String[] generalInterest_5_choices;

    private String[] hobbies_1_choices;
    private String[] hobbies_2_choices;
    private String[] hobbies_3_choices;
    private String[] hobbies_4_choices;
    private String[] hobbies_5_choices;

    private String[] cultureLifestyle_1_choices;
    private String[] cultureLifestyle_2_choices;
    private String[] cultureLifestyle_3_choices;
    private String[] cultureLifestyle_4_choices;
    private String[] cultureLifestyle_5_choices;

    private String[] finance_1_choices;
    private String[] finance_2_choices;
    private String[] finance_3_choices;
    private String[] finance_4_choices;
    private String[] finance_5_choices;

    private String[] sex_1_choices;
    private String[] sex_2_choices;
    private String[] sex_3_choices;
    private String[] sex_4_choices;
    private String[] sex_5_choices;

    private TextView question01;
    private TextView question02;
    private TextView question03;
    private TextView question04;
    private TextView question05;
    private TextView question06;
    private TextView question07;
    private TextView question08;
    private TextView question09;
    private TextView question10;
    private TextView question11;
    private TextView question12;
    private TextView question13;
    private TextView question14;
    private TextView question15;
    private TextView question16;
    private TextView question17;
    private TextView question18;
    private TextView question19;
    private TextView question20;
    private TextView question21;
    private TextView question22;
    private TextView question23;
    private TextView question24;
    private TextView question25;

    private RadioButton question01_answer;
    private RadioButton question02_answer;
    private RadioButton question03_answer;
    private RadioButton question04_answer;
    private RadioButton question05_answer;
    private RadioButton question06_answer;
    private RadioButton question07_answer;
    private RadioButton question08_answer;
    private RadioButton question09_answer;
    private RadioButton question10_answer;
    private RadioButton question11_answer;
    private RadioButton question12_answer;
    private RadioButton question13_answer;
    private RadioButton question14_answer;
    private RadioButton question15_answer;
    private RadioButton question16_answer;
    private RadioButton question17_answer;
    private RadioButton question18_answer;
    private RadioButton question19_answer;
    private RadioButton question20_answer;
    private RadioButton question21_answer;
    private RadioButton question22_answer;
    private RadioButton question23_answer;
    private RadioButton question24_answer;
    private RadioButton question25_answer;

    private Button revealAnswersButton;
    private Button hideAnswersButton;

    private ScrollView revealAnswers_scrollView;

    public UserProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStringResources();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_user_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViews(view);
        setViews();
    }




    private void setStringResources() {
        generalInterestQuestions = getResources().getStringArray(R.array.generalInterest_surveyQuestions_array);
        hobbiesQuestions = getResources().getStringArray(R.array.hobbies_surveyQuestions_array);
        cultureLifestyleQuestions = getResources().getStringArray(R.array.culture_surveyQuestions_array);
        financeQuestions = getResources().getStringArray(R.array.finance_surveyQuestions_array);
        sexQuestions = getResources().getStringArray(R.array.sex_surveyQuestions_array);

        generalInterest_1_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question1_array);
        generalInterest_2_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question2_array);
        generalInterest_3_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question3_array);
        generalInterest_4_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question4_array);
        generalInterest_5_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question5_array);

        hobbies_1_choices = getResources().getStringArray(R.array.hobbies_surveyChoices_question1_array);
        hobbies_2_choices = getResources().getStringArray(R.array.hobbies_surveyChoices_question2_array);
        hobbies_3_choices = getResources().getStringArray(R.array.hobbies_surveyChoices_question3_array);
        hobbies_4_choices = getResources().getStringArray(R.array.hobbies_surveyChoices_question4_array);
        hobbies_5_choices = getResources().getStringArray(R.array.hobbies_surveyChoices_question5_array);

        cultureLifestyle_1_choices = getResources().getStringArray(R.array.culture_surveyChoices_question1_array);
        cultureLifestyle_2_choices = getResources().getStringArray(R.array.culture_surveyChoices_question2_array);
        cultureLifestyle_3_choices = getResources().getStringArray(R.array.culture_surveyChoices_question3_array);
        cultureLifestyle_4_choices = getResources().getStringArray(R.array.culture_surveyChoices_question4_array);
        cultureLifestyle_5_choices = getResources().getStringArray(R.array.culture_surveyChoices_question5_array);

        finance_1_choices = getResources().getStringArray(R.array.finance_surveyChoices_question1_array);
        finance_2_choices = getResources().getStringArray(R.array.finance_surveyChoices_question2_array);
        finance_3_choices = getResources().getStringArray(R.array.finance_surveyChoices_question3_array);
        finance_4_choices = getResources().getStringArray(R.array.finance_surveyChoices_question4_array);
        finance_5_choices = getResources().getStringArray(R.array.finance_surveyChoices_question5_array);

        sex_1_choices = getResources().getStringArray(R.array.sex_surveyChoices_question1_array);
        sex_2_choices = getResources().getStringArray(R.array.sex_surveyChoices_question2_array);
        sex_3_choices = getResources().getStringArray(R.array.sex_surveyChoices_question3_array);
        sex_4_choices = getResources().getStringArray(R.array.sex_surveyChoices_question4_array);
        sex_5_choices = getResources().getStringArray(R.array.sex_surveyChoices_question5_array);
    }

    private void findViews(@NonNull View view) {
        revealAnswers_scrollView = view.findViewById(R.id.revealAnswers_scrollView);

        question01 = view.findViewById(R.id.userProfile_question01_revealedAnswer_text);
        question02 = view.findViewById(R.id.userProfile_question02_revealedAnswer_text);
        question03 = view.findViewById(R.id.userProfile_question03_revealedAnswer_text);
        question04 = view.findViewById(R.id.userProfile_question04_revealedAnswer_text);
        question05 = view.findViewById(R.id.userProfile_question05_revealedAnswer_text);
        question06 = view.findViewById(R.id.userProfile_question06_revealedAnswer_text);
        question07 = view.findViewById(R.id.userProfile_question07_revealedAnswer_text);
        question08 = view.findViewById(R.id.userProfile_question08_revealedAnswer_text);
        question09 = view.findViewById(R.id.userProfile_question09_revealedAnswer_text);
        question10 = view.findViewById(R.id.userProfile_question10_revealedAnswer_text);
        question11 = view.findViewById(R.id.userProfile_question11_revealedAnswer_text);
        question12 = view.findViewById(R.id.userProfile_question12_revealedAnswer_text);
        question13 = view.findViewById(R.id.userProfile_question13_revealedAnswer_text);
        question14 = view.findViewById(R.id.userProfile_question14_revealedAnswer_text);
        question15 = view.findViewById(R.id.userProfile_question15_revealedAnswer_text);
        question16 = view.findViewById(R.id.userProfile_question16_revealedAnswer_text);
        question17 = view.findViewById(R.id.userProfile_question17_revealedAnswer_text);
        question18 = view.findViewById(R.id.userProfile_question18_revealedAnswer_text);
        question19 = view.findViewById(R.id.userProfile_question19_revealedAnswer_text);
        question20 = view.findViewById(R.id.userProfile_question20_revealedAnswer_text);
        question21 = view.findViewById(R.id.userProfile_question21_revealedAnswer_text);
        question22 = view.findViewById(R.id.userProfile_question22_revealedAnswer_text);
        question23 = view.findViewById(R.id.userProfile_question23_revealedAnswer_text);
        question24 = view.findViewById(R.id.userProfile_question24_revealedAnswer_text);
        question25 = view.findViewById(R.id.userProfile_question25_revealedAnswer_text);

        question01_answer =  view.findViewById(R.id.userProfile_question01_revealedAnswer_answer);
        question02_answer =  view.findViewById(R.id.userProfile_question02_revealedAnswer_answer);
        question03_answer =  view.findViewById(R.id.userProfile_question03_revealedAnswer_answer);
        question04_answer =  view.findViewById(R.id.userProfile_question04_revealedAnswer_answer);
        question05_answer =  view.findViewById(R.id.userProfile_question05_revealedAnswer_answer);
        question06_answer =  view.findViewById(R.id.userProfile_question06_revealedAnswer_answer);
        question07_answer =  view.findViewById(R.id.userProfile_question07_revealedAnswer_answer);
        question08_answer =  view.findViewById(R.id.userProfile_question08_revealedAnswer_answer);
        question09_answer =  view.findViewById(R.id.userProfile_question09_revealedAnswer_answer);
        question10_answer =  view.findViewById(R.id.userProfile_question10_revealedAnswer_answer);
        question11_answer =  view.findViewById(R.id.userProfile_question11_revealedAnswer_answer);
        question12_answer =  view.findViewById(R.id.userProfile_question12_revealedAnswer_answer);
        question13_answer =  view.findViewById(R.id.userProfile_question13_revealedAnswer_answer);
        question14_answer =  view.findViewById(R.id.userProfile_question14_revealedAnswer_answer);
        question15_answer =  view.findViewById(R.id.userProfile_question15_revealedAnswer_answer);
        question16_answer =  view.findViewById(R.id.userProfile_question16_revealedAnswer_answer);
        question17_answer =  view.findViewById(R.id.userProfile_question17_revealedAnswer_answer);
        question18_answer =  view.findViewById(R.id.userProfile_question18_revealedAnswer_answer);
        question19_answer =  view.findViewById(R.id.userProfile_question19_revealedAnswer_answer);
        question20_answer =  view.findViewById(R.id.userProfile_question20_revealedAnswer_answer);
        question21_answer =  view.findViewById(R.id.userProfile_question21_revealedAnswer_answer);
        question22_answer =  view.findViewById(R.id.userProfile_question22_revealedAnswer_answer);
        question23_answer =  view.findViewById(R.id.userProfile_question23_revealedAnswer_answer);
        question24_answer =  view.findViewById(R.id.userProfile_question24_revealedAnswer_answer);
        question25_answer =  view.findViewById(R.id.userProfile_question25_revealedAnswer_answer);

        revealAnswersButton = view.findViewById(R.id.revealAnswers_button);
        hideAnswersButton = view.findViewById(R.id.hideAnswers_button);
    }

    private void setViews() {
        revealAnswers_scrollView.setVisibility(View.GONE);
        hideAnswersButton.setVisibility(View.GONE);

        revealAnswersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revealAnswers_scrollView.setVisibility(View.VISIBLE);
                hideAnswersButton.setVisibility(View.VISIBLE);
                revealAnswersButton.setVisibility(View.GONE);
            }
        });

        question01.setText(generalInterestQuestions[0]);
        question01_answer.setText(generalInterest_1_choices[1]);

        question02.setText(generalInterestQuestions[1]);
        question02_answer.setText(generalInterest_2_choices[3]);

        question03.setText(generalInterestQuestions[2]);
        question03_answer.setText(generalInterest_3_choices[4]);

        question04.setText(generalInterestQuestions[3]);
        question04_answer.setText(generalInterest_4_choices[4]);

        question05.setText(generalInterestQuestions[4]);
        question05_answer.setText(generalInterest_5_choices[0]);


        question06.setText(hobbiesQuestions[0]);
        question06_answer.setText(hobbies_1_choices[4]);

        question07.setText(hobbiesQuestions[1]);
        question07_answer.setText(hobbies_2_choices[0]);

        question08.setText(hobbiesQuestions[2]);
        question08_answer.setText(hobbies_3_choices[1]);

        question09.setText(hobbiesQuestions[3]);
        question09_answer.setText(hobbies_4_choices[1]);

        question10.setText(hobbiesQuestions[4]);
        question10_answer.setText(hobbies_5_choices[0]);


        question11.setText(cultureLifestyleQuestions[0]);
        question11_answer.setText(cultureLifestyle_1_choices[1]);

        question12.setText(cultureLifestyleQuestions[1]);
        question12_answer.setText(cultureLifestyle_2_choices[2]);

        question13.setText(cultureLifestyleQuestions[2]);
        question13_answer.setText(cultureLifestyle_3_choices[2]);

        question14.setText(cultureLifestyleQuestions[3]);
        question14_answer.setText(cultureLifestyle_4_choices[1]);

        question15.setText(cultureLifestyleQuestions[4]);
        question15_answer.setText(cultureLifestyle_5_choices[2]);


        question16.setText(financeQuestions[0]);
        question16_answer.setText(finance_1_choices[1]);

        question17.setText(financeQuestions[1]);
        question17_answer.setText(finance_2_choices[1]);

        question18.setText(financeQuestions[2]);
        question18_answer.setText(finance_3_choices[2]);

        question19.setText(financeQuestions[3]);
        question19_answer.setText(finance_4_choices[1]);

        question20.setText(financeQuestions[4]);
        question20_answer.setText(finance_5_choices[3]);


        question21.setText(sexQuestions[0]);
        question21_answer.setText(sex_1_choices[0]);

        question22.setText(sexQuestions[1]);
        question22_answer.setText(sex_2_choices[0]);

        question23.setText(sexQuestions[2]);
        question23_answer.setText(sex_3_choices[1]);

        question24.setText(sexQuestions[3]);
        question24_answer.setText(sex_4_choices[2]);

        question25.setText(sexQuestions[4]);
        question25_answer.setText(sex_5_choices[3]);

        hideAnswersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revealAnswersButton.setVisibility(View.VISIBLE);
                revealAnswers_scrollView.setVisibility(View.GONE);
                hideAnswersButton.setVisibility(View.GONE);
            }
        });
    }
}

