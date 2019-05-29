package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.model.UserProfile;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShuffleTheLoveBirdsActivity extends AppCompatActivity {

    private static final String TAG = "UserProfilesJSON.TAG";
    private List<UserProfile> userProfileList = new ArrayList<>();

    private static final String SHUFFLED_USER_NAME = "shuffledusername";
    private static final String SHUFFLED_USER_AGE = "shuffleduserage";
    private static final String SHUFFLED_USER_OCCUPATION = "shuffleduseroccupation";
    private static final String SHUFFLED_USER_PICTURE = "shuffleduserpicture";
    private static final String SHUFFLED_USER_LOCATION = "shuffleduserlocation";
    private static final String SHUFFLED_USER_BIO = "shuffleduserbio";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuffle_the_love_birds);



        Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
        UserProfileService userProfileService = retrofit.create(UserProfileService.class);
        userProfileService.getProfiles().enqueue(new Callback<UserProfilesAPI>() {
            @Override
            public void onResponse(Call<UserProfilesAPI> call, Response<UserProfilesAPI> response) {
                Log.d(TAG, "This retrofit works, Omar! " + response.body().getProfiles().get(2).getPicture());
                userProfileList.addAll(response.body().getProfiles());


                Random randomNumber = new Random();
                UserProfile shuffledUserProfilePicked = userProfileList.get(randomNumber.nextInt(userProfileList.size() - 1) + 1);
                Intent shuffledUserProfilePickedIntent = new Intent(getApplicationContext(), ShuffleSelectedProfileActivity.class);
                shuffledUserProfilePickedIntent.putExtra(SHUFFLED_USER_NAME, shuffledUserProfilePicked.getUser());
                shuffledUserProfilePickedIntent.putExtra(SHUFFLED_USER_AGE, shuffledUserProfilePicked.getAge());
                shuffledUserProfilePickedIntent.putExtra(SHUFFLED_USER_BIO, shuffledUserProfilePicked.getBio());
                shuffledUserProfilePickedIntent.putExtra(SHUFFLED_USER_OCCUPATION, shuffledUserProfilePicked.getOccupation());
                shuffledUserProfilePickedIntent.putExtra(SHUFFLED_USER_LOCATION, shuffledUserProfilePicked.getLocation());
                shuffledUserProfilePickedIntent.putExtra(SHUFFLED_USER_PICTURE, shuffledUserProfilePicked.getPicture());
                ShuffleTheLoveBirdsActivity.this.finish();
                startActivity(shuffledUserProfilePickedIntent);

            }

            @Override
            public void onFailure(Call<UserProfilesAPI> call, Throwable t) {
                Log.d(TAG, "Retrofit call failed" + t.getMessage());
            }
        });

    }
}
