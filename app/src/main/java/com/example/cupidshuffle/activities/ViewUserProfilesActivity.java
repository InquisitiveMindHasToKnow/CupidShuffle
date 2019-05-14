package com.example.cupidshuffle.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.UserProfiles;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.rv.UserProfilesAdapter;
import com.example.cupidshuffle.services.RetrofitSingleton;
import com.example.cupidshuffle.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewUserProfilesActivity extends AppCompatActivity {

    private static final String TAG = "UserProfilesJSON.TAG";
    private RecyclerView userProfileRecyclerView;
    private List<UserProfiles> userProfileList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_profiles);

        userProfileRecyclerView = findViewById(R.id.user_profiles_recyclerview);

        Retrofit retrofit = RetrofitSingleton.getRetrofitInstance();
        UserProfileService userProfileService = retrofit.create(UserProfileService.class);
        userProfileService.getProfiles().enqueue(new Callback<UserProfilesAPI>() {
            @Override
            public void onResponse(Call<UserProfilesAPI> call, Response<UserProfilesAPI> response) {
                Log.d(TAG, "This retrofit works, Omar! " + response.body().getProfiles().get(2).getPicture());
                userProfileList.addAll(response.body().getProfiles());
                UserProfilesAdapter userProfilesAdapter = new UserProfilesAdapter(userProfileList);
                userProfileRecyclerView.setAdapter(userProfilesAdapter);
                userProfileRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onFailure(Call<UserProfilesAPI> call, Throwable t) {
                Log.d(TAG, "Retrofit call failed" + t.getMessage());
            }
        });

    }
}