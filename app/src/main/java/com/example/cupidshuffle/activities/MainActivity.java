package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.SearchVenuesResponse;
import com.example.cupidshuffle.model.UserProfile;
import com.example.cupidshuffle.model.Venue;
import com.example.cupidshuffle.model.VenuesResponse;
import com.example.cupidshuffle.network.FourSquareClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment.SHUFFLED_USER_KEY;

public class MainActivity extends AppCompatActivity implements Callback<SearchVenuesResponse> {
    private static final String TAG = "MainActivity";
    private UserProfile userProfile;
    private String topCategoryOne;
    private String topCategoryTwo;
    private String topCategoryThree;
    private RecyclerView recyclerView;
    private VenuesAdapter venuesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        userProfile = intent.getParcelableExtra(SHUFFLED_USER_KEY);
        topCategoryOne = userProfile.getTopCategoryOne();
        topCategoryTwo = userProfile.getTopCategoryTwo();
        topCategoryThree = userProfile.getTopCategoryThree();
        Log.d(TAG,topCategoryOne +topCategoryTwo +topCategoryThree);
        getVenues();
        recyclerView = findViewById(R.id.mainActivity_recyclerView);

    }

    private void getVenues(){
        Call<SearchVenuesResponse> searchVenuesResponseCall = FourSquareClient.getInstance().getVenues(topCategoryOne,topCategoryTwo,topCategoryThree);
        searchVenuesResponseCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<SearchVenuesResponse> call, Response<SearchVenuesResponse> response) {
        SearchVenuesResponse searchVenuesResponse = response.body();
        VenuesResponse venuesResponse = searchVenuesResponse.getResponse();
        List<Venue> venues = venuesResponse.getVenues();
        venuesAdapter = new VenuesAdapter(venues);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(venuesAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        Log.d(TAG,venues.toString());
    }

    @Override
    public void onFailure(Call<SearchVenuesResponse> call, Throwable t) {
        Log.d(TAG,t.toString());

    }
}
