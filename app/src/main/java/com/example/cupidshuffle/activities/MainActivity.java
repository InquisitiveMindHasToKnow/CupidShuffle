package com.example.cupidshuffle.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.Category;
import com.example.cupidshuffle.model.FourSquareResponse;
import com.example.cupidshuffle.services.FourSquareClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<FourSquareResponse> {

    private static final String TAG = "Categories";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCategories();
    }

    private void getCategories(){
        Call<FourSquareResponse> fourSquareResponseCall = FourSquareClient.getInstance().getCategoryResponse();
        fourSquareResponseCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<FourSquareResponse> call, Response<FourSquareResponse> response) {
        FourSquareResponse fourSquareResponse = response.body();
        List<Category> categories = fourSquareResponse.getResponse().getCategories();
        Log.d(TAG,categories.toString());
    }

    @Override
    public void onFailure(Call<FourSquareResponse> call, Throwable t) {
        Log.d(TAG,t.toString());


    }
}
