package com.example.cupidshuffle.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.rv.QuestionaireViewholder;
import com.example.cupidshuffle.surveys.models.Questionaire;

import java.util.List;


public class QuestionaireAdapter extends RecyclerView.Adapter<QuestionaireViewholder> {
    private List<Questionaire> questionaires;

    public QuestionaireAdapter(List<Questionaire> questionaires) {
        this.questionaires = questionaires;
    }

    @NonNull
    @Override
    public QuestionaireViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.questionaire_itemview, viewGroup, false);
        return new QuestionaireViewholder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionaireViewholder questionaireViewholder, int i) {
        questionaireViewholder.onBind(questionaires.get(i));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
