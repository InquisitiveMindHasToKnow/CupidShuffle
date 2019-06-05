package com.example.cupidshuffle.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.ShuffleTheLoveBirdsActivity;
import com.example.cupidshuffle.network.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.model.UserProfile;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.rv.UserProfilesAdapter;
import com.example.cupidshuffle.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AllUserProfilesFragment extends Fragment {


    private View rootView;
    private static final String TAG = "UserProfilesJSON.TAG";
    private RecyclerView userProfileRecyclerView;
    private List<UserProfile> userProfileList = new ArrayList<>();


    public AllUserProfilesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_view_all_user_profiles, container, false);
        userProfileRecyclerView = rootView.findViewById(R.id.user_profiles_recyclerview);


        Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
        UserProfileService userProfileService = retrofit.create(UserProfileService.class);
        userProfileService.getProfiles().enqueue(new Callback<UserProfilesAPI>() {
            @Override
            public void onResponse(Call<UserProfilesAPI> call, Response<UserProfilesAPI> response) {
                Log.d(TAG, "This retrofit works, Omar! " + response.body().getProfiles().get(2).getPicture());
                userProfileList.addAll(response.body().getProfiles());
                UserProfilesAdapter userProfilesAdapter = new UserProfilesAdapter(userProfileList);
                userProfileRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                userProfileRecyclerView.setAdapter(userProfilesAdapter);


            }

            @Override
            public void onFailure(Call<UserProfilesAPI> call, Throwable t) {
                Log.d(TAG, "Retrofit call failed" + t.getMessage());


                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(getContext());
                                        builder.setIcon(R.drawable.nointernetconnection)
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


        return rootView;
    }
}

