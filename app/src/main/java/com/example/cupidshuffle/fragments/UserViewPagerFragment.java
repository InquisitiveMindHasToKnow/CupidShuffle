package com.example.cupidshuffle.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.ViewPagerAdapter;
import com.example.cupidshuffle.model.UserProfile;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.network.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class UserViewPagerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "UserViewPagerFragment";
    public static final List<Fragment> fragmentList = new ArrayList<>();
    private View view;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public UserViewPagerFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static UserViewPagerFragment newInstance() {
        return new UserViewPagerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_view_pager, container, false);

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
        UserProfileService userProfileService = retrofit.create(UserProfileService.class);
        userProfileService.getProfiles().enqueue(new Callback<UserProfilesAPI>() {
            @Override
            public void onResponse(Call<UserProfilesAPI> call, Response<UserProfilesAPI> response) {
                Log.d(TAG,response.body().toString());
                List<UserProfile> userProfiles = response.body().getProfiles();
                for (UserProfile user : userProfiles) {
                    ShuffleSelectedProfileFragment shuffleSelectedProfileFragment = ShuffleSelectedProfileFragment.newInstance(user);
                    fragmentList.add(shuffleSelectedProfileFragment);
                }
                ViewPager viewPager = view.findViewById(R.id.fragment_viewPager);
                viewPager.setAdapter(new ViewPagerAdapter(getActivity().getSupportFragmentManager(),fragmentList));

            }

            @Override
            public void onFailure(Call<UserProfilesAPI> call, Throwable t) {
                Log.d(TAG,t.getMessage());


            }
        });
    }





}
