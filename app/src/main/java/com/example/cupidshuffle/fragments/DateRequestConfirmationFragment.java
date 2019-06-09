package com.example.cupidshuffle.fragments;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cupidshuffle.R;


public class DateRequestConfirmationFragment extends Fragment {

    private BottomNavigationView navView;
    private ImageView heartyHeartsImageView;
    private View rootView;


    public DateRequestConfirmationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_date_request_confirmation, container, false);


        heartyHeartsImageView = rootView.findViewById(R.id.hearty_hearts_imageview);


        Glide.with(this).load(R.drawable.heartyhearts).into(heartyHeartsImageView);


        return rootView;
    }

}
