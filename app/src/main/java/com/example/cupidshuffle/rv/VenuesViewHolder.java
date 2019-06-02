package com.example.cupidshuffle.rv;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.DateChoiceConfirmationActivity;
import com.example.cupidshuffle.activities.MakeReservationActivity;
import com.example.cupidshuffle.fragments.FragmentNavigation;
import com.example.cupidshuffle.fragments.GoogleMapsFragment;
import com.example.cupidshuffle.model.Venue;

import java.util.Calendar;


public class VenuesViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = "PhotosCall";
    private FragmentNavigation fragmentNavigation;
    private static final String LOCATION_LAT = "lat";
    private static final String LOCATION_LON = "lon";
    private static final String VENUE_NAME = "venuename";
    private TextView venueNameTextView;
    private TextView venueCityTextView;
    private TextView venueCrossStreetTextView;
    private Button dateChoiceButton;

    private Context context;

    public VenuesViewHolder(@NonNull View itemView) {
        super(itemView);

        venueNameTextView = itemView.findViewById(R.id.venue_name_textView);
        venueCityTextView = itemView.findViewById(R.id.venue_city_textview);
        venueCrossStreetTextView = itemView.findViewById(R.id.venue_location_textview);
        dateChoiceButton = itemView.findViewById(R.id.date_choice_button);


    }


    public void onBind(final Venue venue) {
        String venueId = venue.getId();
        Log.d(TAG, venueId);

        final String venueLat = venue.getLocation().getLat();
        final String venueLong = venue.getLocation().getLng();
        final String venueName = venue.getName();
        final String venueCrossStreet = venue.getLocation().getCrossStreet();
        final String venueCity = venue.getLocation().getCity();

        venueNameTextView.setText(venueName);
        venueCityTextView.setText(venueCity);
        venueCrossStreetTextView.setText(venueCrossStreet);

        dateChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                Intent toDateChoiceConfirmationIntent = new Intent(itemView.getContext(), MakeReservationActivity.class);
                toDateChoiceConfirmationIntent.putExtra(VENUE_NAME, venueName);
                itemView.getContext().startActivity(toDateChoiceConfirmationIntent);


            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(itemView.getContext(), GoogleMapsFragment.class);
                Bundle mapBundle = new Bundle();

                mapBundle.putString(LOCATION_LON, venueLong);
                mapBundle.putString(LOCATION_LAT, venueLat);
                mapBundle.putString(VENUE_NAME, venueName);

                mapIntent.putExtras(mapBundle);
                Log.e("VENUE ON MAP: " , venueLong +" " + venueLat + " "+ venueName);

                fragmentNavigation = (FragmentNavigation) v.getContext();
                fragmentNavigation.goToLocationOnMap(venueLong, venueLat, venueName);

            }
        });

        }}

