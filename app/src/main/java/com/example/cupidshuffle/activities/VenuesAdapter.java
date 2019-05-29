package com.example.cupidshuffle.activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.Venue;

import java.util.List;

public class VenuesAdapter extends RecyclerView.Adapter<VenuesViewHolder> {
    private List<Venue> venues;

    public VenuesAdapter(List<Venue> venues) {
        this.venues = venues;
    }

    @NonNull
    @Override
    public VenuesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.venues_itemview,viewGroup,false);
        return new VenuesViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull VenuesViewHolder venuesViewholder, int i) {
        Venue venue = venues.get(i);
        venuesViewholder.onBind(venue);


    }

    @Override
    public int getItemCount() {
        return venues.size();
    }
}
