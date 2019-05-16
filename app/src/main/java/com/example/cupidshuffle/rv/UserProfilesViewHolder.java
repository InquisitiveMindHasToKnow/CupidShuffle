package com.example.cupidshuffle.rv;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.IndividualProfilePage;
import com.example.cupidshuffle.model.UserProfiles;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class UserProfilesViewHolder extends RecyclerView.ViewHolder{

    private TextView userNameTextView;
    private TextView userLocationTextView;
    private TextView userOccupationTextView;
    private CircularImageView profileCircularImageView;
    private String userName;
    private String userAge;

    private static final String USER_NAME = "username";
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

    public void onBind(final UserProfiles userProfiles) {

        userName = userProfiles.getUser() + ", ";
        userAge = userProfiles.getAge();


        userNameTextView.setText(userName+userAge);
        userLocationTextView.setText(userProfiles.getLocation());
        userOccupationTextView.setText(userProfiles.getOccupation());

        Picasso.get()
                .load(userProfiles.getPicture())
                .into(profileCircularImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent profileIntent = new Intent(itemView.getContext(), IndividualProfilePage.class);

                profileIntent.putExtra(USER_NAME, userProfiles.getUser());
                profileIntent.putExtra(USER_AGE, userProfiles.getAge());
                profileIntent.putExtra(USER_LOCATION, userProfiles.getLocation());
                profileIntent.putExtra(USER_OCCUPATION, userProfiles.getOccupation());
                profileIntent.putExtra(USER_PICTURE, userProfiles.getPicture());
                profileIntent.putExtra(USER_BIO, userProfiles.getBio());

                v.getContext().startActivity(profileIntent);

            }
        });

    }
}