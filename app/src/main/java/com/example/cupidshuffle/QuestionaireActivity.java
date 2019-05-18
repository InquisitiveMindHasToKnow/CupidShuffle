package com.example.cupidshuffle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.cupidshuffle.surveys.models.QuestionaireList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionaireActivity extends AppCompatActivity implements Callback<QuestionaireList> {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        recyclerView = findViewById(R.id.questionaire_recycler);
    }

    public void getQuestionaires() {
        Call<QuestionaireList> questionaireCall = RetrofitSingleton.getInstance().getQuestionaireResponse();
        questionaireCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<QuestionaireList> call, Response<QuestionaireList> response) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new QuestionaireAdapter(response.body().getQuestionaireList()));
        recyclerView.hasFixedSize();
    }

    @Override
    public void onFailure(Call<QuestionaireList> call, Throwable t) {

    }
}
