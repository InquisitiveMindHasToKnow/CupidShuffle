package com.example.cupidshuffle.rv;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.MainActivity;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.example.cupidshuffle.model.UserProfile;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class UserProfilesViewHolder extends RecyclerView.ViewHolder{

    private TextView userNameTextView;
    private TextView userLocationTextView;
    private TextView userOccupationTextView;
    private CircularImageView profileCircularImageView;
    private String userName;
    private String userAge;

    private static final String USER = "username";
    private static final String USER_AGE = "userage";
    private static final String USER_OCCUPATION = "useroccupation";
    private static final String USER_PICTURE = "userpicture";
    private static final String USER_LOCATION = "userlocation";
    private static final String USER_BIO = "userbio";



    public UserProfilesViewHolder(@NonNull View itemView) {
        super(itemView);

        userNameTextView = itemView.findViewById(R.id.userprofile_name_textview);
        userLocationTextView = itemView.findViewById(R.id.userprofile_location_textview);
        userOccupationTextView = itemView.findViewById(R.id.userprofile_occupation_textview);
        profileCircularImageView = itemView.findViewById(R.id.userprofile_circular_imageview);
    }

    public void onBind(final UserProfile userProfile) {

        userName = userProfile.getUser() + ", ";
        userAge = userProfile.getAge();



        userNameTextView.setText(userName+userAge);
        userLocationTextView.setText(userProfile.getLocation());
        userOccupationTextView.setText(userProfile.getOccupation());

        Picasso.get()
                .load(userProfile.getPicture())
                .into(profileCircularImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ShuffleSelectedProfileFragment shuffleSelectedProfileFragment = ShuffleSelectedProfileFragment.newInstance(userProfile);
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, shuffleSelectedProfileFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });

    }
}
