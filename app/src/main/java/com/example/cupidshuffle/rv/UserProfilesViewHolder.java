package com.example.cupidshuffle.rv;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cupidshuffle.R;
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


    public UserProfilesViewHolder(@NonNull View itemView) {
        super(itemView);

        userNameTextView = itemView.findViewById(R.id.userprofile_name_textview);
        userLocationTextView = itemView.findViewById(R.id.userprofile_location_textview);
        userOccupationTextView = itemView.findViewById(R.id.userprofile_occupation_textview);
        profileCircularImageView = itemView.findViewById(R.id.userprofile_circular_imageview);
    }

    public void onBind(UserProfiles userProfiles) {

        userName = userProfiles.getUser() + ", ";
        userAge = userProfiles.getAge();


        userNameTextView.setText(userName+userAge);
        userLocationTextView.setText(userProfiles.getLocation());
        userOccupationTextView.setText(userProfiles.getOccupation());

        Picasso.get()
                .load(userProfiles.getPicture())
                .into(profileCircularImageView);

    }
}
