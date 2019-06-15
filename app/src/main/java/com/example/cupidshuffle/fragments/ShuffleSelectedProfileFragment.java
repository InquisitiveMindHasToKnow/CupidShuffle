package com.example.cupidshuffle.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.network.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.activities.MainActivity;
import com.example.cupidshuffle.model.UserProfile;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.services.UserProfileService;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.app.Activity.RESULT_CANCELED;

public class ShuffleSelectedProfileFragment extends Fragment {

    private static final String USER_SELECTED = "USER SELECTED";
    private View rootView;
    public static final String SHUFFLED_USER_KEY = "shuffled User";
    public static String USER_NAME = "shuffled userName";
    public static String CHOSEN_DATES_PICTURE = "";
    private TextView profilePageUserName;
    private TextView profilePageUserLocation;
    private TextView profilePageUserBio;
    private TextView profilePageUserOccupation;
    private CircularImageView profilePageUserPicture;
    private Button shuffledProfileLetsShuffleButton;
    private Button shuffledProfileMessageMeButton;
    private UserProfile userProfile;
    private ImageView financeProgressBar;
    private ImageView hobbiesProgressBar;
    private ImageView cultureProgressBar;
    private ImageView sexProgressBar;
    private ImageView generalProgressBar;


    public ShuffleSelectedProfileFragment() {
        // Required empty public constructor
    }

    public static ShuffleSelectedProfileFragment newInstance(UserProfile userProfile) {
        ShuffleSelectedProfileFragment fragment = new ShuffleSelectedProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(USER_SELECTED, userProfile);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userProfile = getArguments().getParcelable(USER_SELECTED);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_selected_profile, container, false);


        profilePageUserName = rootView.findViewById(R.id.shuffled_profile_username_textview);
        profilePageUserBio = rootView.findViewById(R.id.shuffled_profile__bio_textview);
        profilePageUserLocation = rootView.findViewById(R.id.shuffled_profile_location_textview);
        profilePageUserPicture = rootView.findViewById(R.id.shuffled_profile_circular_imageview);
        profilePageUserOccupation = rootView.findViewById(R.id.shuffled_profile_occupation_textview);
        shuffledProfileLetsShuffleButton = rootView.findViewById(R.id.shuffled_profile_letsshuffle_button);
        shuffledProfileMessageMeButton = rootView.findViewById(R.id.shuffled_profile_send_message_to_user_button);

        financeProgressBar = rootView.findViewById(R.id.finance_progressBar);
        hobbiesProgressBar = rootView.findViewById(R.id.hobbies_progressBar);
        cultureProgressBar = rootView.findViewById(R.id.culture_progressBar);
        sexProgressBar = rootView.findViewById(R.id.sex_progressBar);
        generalProgressBar = rootView.findViewById(R.id.general_progressBar);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (userProfile != null) {


            int financeUserProgressWidth = Integer.valueOf(userProfile.getFinanceWidth());
            int hobbiesUserProgressWidth = Integer.valueOf(userProfile.getHobbiesWidth());
            int cultureUserProgressWidth = Integer.valueOf(userProfile.getCultureWidth());
            int sexUserProgressWidth = Integer.valueOf(userProfile.getSexWidth());
            int generalUserProgressWidth = Integer.valueOf(userProfile.getGeneralWidth());

            setWidth(getWidth(financeUserProgressWidth),
                    getWidth(hobbiesUserProgressWidth),
                    getWidth(cultureUserProgressWidth),
                    getWidth(sexUserProgressWidth),
                    getWidth(generalUserProgressWidth));


            profilePageUserName.setText(userProfile.getUser());
            profilePageUserBio.setText(userProfile.getBio());
            profilePageUserLocation.setText(userProfile.getLocation());
            profilePageUserOccupation.setText(userProfile.getOccupation());

            USER_NAME = userProfile.getUser();
            CHOSEN_DATES_PICTURE = userProfile.getPicture();


            Picasso.get()
                    .load(userProfile.getPicture())
                    .into(profilePageUserPicture);

            financeUserProgressWidth = Integer.valueOf(userProfile.getFinanceWidth());
            hobbiesUserProgressWidth = Integer.valueOf(userProfile.getHobbiesWidth());
            cultureUserProgressWidth = Integer.valueOf(userProfile.getCultureWidth());
            sexUserProgressWidth = Integer.valueOf(userProfile.getSexWidth());
            generalUserProgressWidth = Integer.valueOf(userProfile.getGeneralWidth());

            setWidth(getWidth(financeUserProgressWidth),
                    getWidth(hobbiesUserProgressWidth),
                    getWidth(cultureUserProgressWidth),
                    getWidth(sexUserProgressWidth),
                    getWidth(generalUserProgressWidth));

        }


        shuffledProfileLetsShuffleButton.setOnClickListener(v ->

        {
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.putExtra(SHUFFLED_USER_KEY, userProfile);
            startActivity(intent);
        });

        shuffledProfileMessageMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

                final EditText sendMessageEdittext = new EditText(getContext());
                alert.setMessage("Enter Your Message: ");
                alert.setTitle("Sending message to " + userProfile.getUser());

                alert.setView(sendMessageEdittext);


                alert.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        Intent sendMessageIntent = new Intent(getContext(), ShuffleSelectedProfileFragment.class);

                        if (TextUtils.isEmpty(sendMessageEdittext.getText())) {
                            getActivity().setResult(RESULT_CANCELED, sendMessageIntent);
                            Toast.makeText(getContext(), "You cannot send an empty message.", Toast.LENGTH_LONG).show();
                        } else {


                            Toast.makeText(getActivity(), "Message sent!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {


                    }
                });

                alert.show();
            }

        });
    }

    private void setWidth(int financeWidth, int hobbiesWidth, int culturalWidth, int sexWidth, int generalWidth) {
        financeProgressBar.getLayoutParams().width = financeWidth;
        financeProgressBar.requestLayout();

        hobbiesProgressBar.getLayoutParams().width = hobbiesWidth;
        hobbiesProgressBar.requestLayout();

        cultureProgressBar.getLayoutParams().width = culturalWidth;
        cultureProgressBar.requestLayout();

        sexProgressBar.getLayoutParams().width = sexWidth;
        sexProgressBar.requestLayout();

        generalProgressBar.getLayoutParams().width = generalWidth;
        generalProgressBar.requestLayout();

    }

    public int getWidth(int width) {

        int max = 121;
        int min = 50;
        int midMax = 70;

        if (width <= 60) {
            width = 100;
        }
        if (width <=70){
            width =250;
        }
        if (width <= 90){
            width = 400;
        }
        if (width <= 125){
            width =700;
        }

        return width;
    }
}


