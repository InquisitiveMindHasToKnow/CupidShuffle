package com.example.cupidshuffle;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.cupidshuffle.surveys.models.Questionaire;
import java.util.List;

public class QuestionaireViewholder extends RecyclerView.ViewHolder {
    private TextView questionText;


    public QuestionaireViewholder(@NonNull View itemView) {
        super(itemView);
        questionText = itemView.findViewById(R.id.question_textView);
    }

    public void onBind(Questionaire questionaire){
        questionText.setText(questionaire.getCultureLifestyle().getQuestionOne().getQuestion());
        List<String> numberOfChoices= questionaire.getCultureLifestyle().getQuestionOne().getAnswer();
        Log.d(QuestionaireViewholder.class.getName(), "onBind: "+ numberOfChoices.toString());
        int choiceCounter = 0;
        for (int row = 0; row < 1; row++) {
            RadioGroup radioGroup = new RadioGroup(itemView.getContext());
            radioGroup.setOrientation(LinearLayout.VERTICAL);

            for (int i = 1; i <= numberOfChoices.size(); i++) {
                RadioButton radioButton = new RadioButton(itemView.getContext());
                radioButton.setId(View.generateViewId());
                radioButton.setText(numberOfChoices.get(choiceCounter));
                choiceCounter++;
                radioGroup.addView(radioButton);
            }
            ((ViewGroup) itemView.findViewById(R.id.questionChoice_radioGroup)).addView(radioGroup);
        }
    }
}
