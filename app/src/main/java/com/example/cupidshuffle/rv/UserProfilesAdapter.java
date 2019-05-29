package com.example.cupidshuffle.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.UserProfile;

import java.util.List;

public class UserProfilesAdapter  extends RecyclerView.Adapter<UserProfilesViewHolder> {

    private List<UserProfile> userProfileList;

    public UserProfilesAdapter(List<UserProfile> userProfileList) {
        this.userProfileList = userProfileList;
    }

    @NonNull
    @Override
    public UserProfilesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_profiles_itemview, viewGroup, false);
        return new UserProfilesViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserProfilesViewHolder userProfilesViewHolder, int i) {

        UserProfile userProfile = userProfileList.get(i);
        userProfilesViewHolder.onBind(userProfile);

    }

    @Override
    public int getItemCount() {
        return userProfileList.size();
    }
}
