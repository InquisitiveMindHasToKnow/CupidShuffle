package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.model.UserProfiles;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.rv.UserProfilesAdapter;
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

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
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
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent toMainProfileIntent = new Intent(ViewUserProfilesActivity.this, PageAfterLoginActivity.class);
                    startActivity(toMainProfileIntent);

                    return true;
                case R.id.navigation_discover:
                    return true;

                case R.id.navigation_notifications:
                    Intent toMessagesAndConnectRequestIntent = new Intent(ViewUserProfilesActivity.this, ViewPrivateMessagesAndConnectionRequest.class);
                    startActivity(toMessagesAndConnectRequestIntent);
                    return true;

                case R.id.navigation_shuffle:
                    Intent toShuffledLoveBirdIntent = new Intent(ViewUserProfilesActivity.this, ShuffleTheLoveBirdsActivity.class);
                    startActivity(toShuffledLoveBirdIntent);
                    return true;
            }

            return false;
        }
    };

}