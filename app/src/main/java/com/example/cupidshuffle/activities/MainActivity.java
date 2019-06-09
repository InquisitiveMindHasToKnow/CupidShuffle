package com.example.cupidshuffle.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.FragmentNavigation;
import com.example.cupidshuffle.fragments.GoogleMapsFragment;
import com.example.cupidshuffle.fragments.MapToProfileNavigation;
import com.example.cupidshuffle.model.SearchVenuesResponse;
import com.example.cupidshuffle.model.UserProfile;
import com.example.cupidshuffle.model.Venue;
import com.example.cupidshuffle.model.VenuesResponse;
import com.example.cupidshuffle.network.FourSquareClient;
import com.example.cupidshuffle.rv.VenuesAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment.SHUFFLED_USER_KEY;

public class MainActivity extends AppCompatActivity implements FragmentNavigation, MapToProfileNavigation {
    private static final String TAG = "MainActivity";
    private UserProfile userProfile;
    private String topCategoryOne;
    private String topCategoryTwo;
    private String topCategoryThree;
    private RecyclerView venuesRecyclerView;
    private VenuesAdapter venuesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        venuesRecyclerView = findViewById(R.id.mainActivity_recyclerView);

        Intent intent = getIntent();


        userProfile = intent.getParcelableExtra(SHUFFLED_USER_KEY);


        if (userProfile == null){
            userProfile = intent.getParcelableExtra("USER SELECTED");
            topCategoryOne = userProfile.getTopCategoryOne();
            topCategoryTwo = userProfile.getTopCategoryTwo();
            topCategoryThree = userProfile.getTopCategoryThree();
        }else {
            topCategoryOne = userProfile.getTopCategoryOne();
            topCategoryTwo = userProfile.getTopCategoryTwo();
            topCategoryThree = userProfile.getTopCategoryThree();
        }

        Log.d(TAG, topCategoryOne + topCategoryTwo + topCategoryThree);

        getVenues();

    }

    private void getVenues() {
        Call<SearchVenuesResponse> searchVenuesResponseCall = FourSquareClient.getInstance().getVenues(topCategoryOne, topCategoryTwo, topCategoryThree);
        searchVenuesResponseCall.enqueue(new Callback<SearchVenuesResponse>() {


            @Override
            public void onResponse(Call<SearchVenuesResponse> call, Response<SearchVenuesResponse> response) {
                SearchVenuesResponse searchVenuesResponse = response.body();
                VenuesResponse venuesResponse = searchVenuesResponse.getResponse();
                List<Venue> venues = venuesResponse.getVenues();
                venuesAdapter = new VenuesAdapter(venues,userProfile);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                venuesRecyclerView.setAdapter(venuesAdapter);
                venuesRecyclerView.setLayoutManager(linearLayoutManager);
                Log.d(TAG, venues.toString());

                final int pos = 0;
                new Handler().postDelayed(() -> venuesRecyclerView.findViewHolderForAdapterPosition(pos).itemView.performClick(),1);
            }

            @Override
            public void onFailure(Call<SearchVenuesResponse> call, Throwable t) {
                Log.d(TAG, t.toString());


                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(MainActivity.this)
                                        .setIcon(R.drawable.nointernetconnection)
                                        .setTitle("Uh-Oh!")
                                        .setMessage("Slow or no internet connection. Please check your settings and refresh the page.")
                                        .setPositiveButton("Refresh", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                        builder.create().show();

                    }
                }, 8000);


        }

        });
    }

    @Override
    public void goToLocationOnMap(String lon, String lat, String name) {
        GoogleMapsFragment googleMapsFragment = GoogleMapsFragment.getInstance(lon, lat, name);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_container, googleMapsFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void closeMainActivity() {
        finish();
    }
}
