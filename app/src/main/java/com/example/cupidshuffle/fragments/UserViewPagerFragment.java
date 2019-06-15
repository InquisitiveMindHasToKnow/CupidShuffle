package com.example.cupidshuffle.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.example.cupidshuffle.R;
import com.example.cupidshuffle.rv.ViewPagerAdapter;
import com.example.cupidshuffle.model.UserProfile;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.network.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.services.UserProfileService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class UserViewPagerFragment extends Fragment {
    public static final String TAG = "UserViewPagerFragment";
    public static final List<Fragment> fragmentList = new ArrayList<>();
    private View view;


    public UserViewPagerFragment() {
        // Required empty public constructor
    }



    public static UserViewPagerFragment newInstance() {
        return new UserViewPagerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
        UserProfileService userProfileService = retrofit.create(UserProfileService.class);
        userProfileService.getProfiles().enqueue(new Callback<UserProfilesAPI>() {
            @Override
            public void onResponse(Call<UserProfilesAPI> call, Response<UserProfilesAPI> response) {
                Log.d(TAG,response.body().toString());
                List<UserProfile> userProfiles = response.body().getProfiles();
                List<UserProfile> womenList = new ArrayList<>();

                for (int i = 0; i < userProfiles.size(); i++) {
                    if (userProfiles.get(i).getGender().equalsIgnoreCase("Female")){
                        womenList.add(userProfiles.get(i));
                    }
                }

                for (UserProfile user : womenList) {
                    ShuffleSelectedProfileFragment shuffleSelectedProfileFragment = ShuffleSelectedProfileFragment.newInstance(user);
                    fragmentList.add(shuffleSelectedProfileFragment);
                }
                ViewPager viewPager = view.findViewById(R.id.fragment_viewPager);
                viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),fragmentList));
                viewPager.setPageTransformer(true, new BackgroundToForegroundTransformer());


            }

            @Override
            public void onFailure(Call<UserProfilesAPI> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_view_pager, container, false);

        return view;
    }
}
