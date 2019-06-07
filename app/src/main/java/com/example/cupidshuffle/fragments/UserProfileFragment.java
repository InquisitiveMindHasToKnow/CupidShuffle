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

    private String[] generalInterest_1_choices;
    private String[] generalInterest_5_choices;

    private String[] hobbies_5_choices;

    private String[] cultureLifestyle_1_choices;
    private String[] cultureLifestyle_3_choices;

    private String[] finance_1_choices;
    private String[] finance_2_choices;
    private String[] finance_3_choices;

    private TextView question01;
    private TextView question05;
    private TextView question10;
    private TextView question11;
    private TextView question13;
    private TextView question16;
    private TextView question17;
    private TextView question18;

    private RadioButton question01_answer;
    private RadioButton question05_answer;
    private RadioButton question10_answer;
    private RadioButton question11_answer;
    private RadioButton question13_answer;
    private RadioButton question16_answer;
    private RadioButton question17_answer;
    private RadioButton question18_answer;

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

        generalInterest_1_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question1_array);
        generalInterest_5_choices = getResources().getStringArray(R.array.generalInterest_surveyChoices_question5_array);

        hobbies_5_choices = getResources().getStringArray(R.array.hobbies_surveyChoices_question5_array);

        cultureLifestyle_1_choices = getResources().getStringArray(R.array.culture_surveyChoices_question1_array);
        cultureLifestyle_3_choices = getResources().getStringArray(R.array.culture_surveyChoices_question3_array);

        finance_1_choices = getResources().getStringArray(R.array.finance_surveyChoices_question1_array);
        finance_2_choices = getResources().getStringArray(R.array.finance_surveyChoices_question2_array);
        finance_3_choices = getResources().getStringArray(R.array.finance_surveyChoices_question3_array);
    }

    private void findViews(@NonNull View view) {
        revealAnswers_scrollView = view.findViewById(R.id.revealAnswers_scrollView);

        question01 = view.findViewById(R.id.userProfile_question01_revealedAnswer_text);
        question05 = view.findViewById(R.id.userProfile_question05_revealedAnswer_text);
        question10 = view.findViewById(R.id.userProfile_question10_revealedAnswer_text);
        question11 = view.findViewById(R.id.userProfile_question11_revealedAnswer_text);
        question13 = view.findViewById(R.id.userProfile_question13_revealedAnswer_text);
        question16 = view.findViewById(R.id.userProfile_question16_revealedAnswer_text);
        question17 = view.findViewById(R.id.userProfile_question17_revealedAnswer_text);
        question18 = view.findViewById(R.id.userProfile_question18_revealedAnswer_text);

        question01_answer =  view.findViewById(R.id.userProfile_question01_revealedAnswer_answer);
        question05_answer =  view.findViewById(R.id.userProfile_question05_revealedAnswer_answer);
        question10_answer =  view.findViewById(R.id.userProfile_question10_revealedAnswer_answer);
        question11_answer =  view.findViewById(R.id.userProfile_question11_revealedAnswer_answer);
        question13_answer =  view.findViewById(R.id.userProfile_question13_revealedAnswer_answer);
        question16_answer =  view.findViewById(R.id.userProfile_question16_revealedAnswer_answer);
        question17_answer =  view.findViewById(R.id.userProfile_question17_revealedAnswer_answer);
        question18_answer =  view.findViewById(R.id.userProfile_question18_revealedAnswer_answer);

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

        question05.setText(generalInterestQuestions[4]);
        question05_answer.setText(generalInterest_5_choices[0]);



        question10.setText(hobbiesQuestions[4]);
        question10_answer.setText(hobbies_5_choices[0]);




        question11.setText(cultureLifestyleQuestions[0]);
        question11_answer.setText(cultureLifestyle_1_choices[1]);

        question13.setText(cultureLifestyleQuestions[2]);
        question13_answer.setText(cultureLifestyle_3_choices[2]);


        question16.setText(financeQuestions[0]);
        question16_answer.setText(finance_1_choices[1]);

        question17.setText(financeQuestions[1]);
        question17_answer.setText(finance_2_choices[1]);

        question18.setText(financeQuestions[2]);
        question18_answer.setText(finance_3_choices[2]);

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

