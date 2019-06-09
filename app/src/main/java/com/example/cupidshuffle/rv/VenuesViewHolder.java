package com.example.cupidshuffle.rv;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.MakeReservationActivity;
import com.example.cupidshuffle.fragments.FragmentNavigation;
import com.example.cupidshuffle.fragments.GoogleMapsFragment;

import com.example.cupidshuffle.fragments.MapToProfileNavigation;

import com.example.cupidshuffle.model.UserProfile;

import com.example.cupidshuffle.model.Venue;


public class VenuesViewHolder extends RecyclerView.ViewHolder  {

    public static final String TAG = "PhotosCall";
    public static final String DATES_NAME = "DATE NAME";
    private FragmentNavigation fragmentNavigation;
    private MapToProfileNavigation mapToProfileNavigation;
    private static final String LOCATION_LAT = "lat";
    private static final String LOCATION_LON = "lon";
    public static final String VENUE_NAME = "venuename";
    public static final String VENUE_ADDRESS = "venueaddress";
    private TextView venueNameTextView;
    private TextView venueCityTextView;
    private TextView venueAddressTextView;
    private Button dateChoiceButton;

    private Context context;

    public VenuesViewHolder(@NonNull View itemView) {
        super(itemView);

        venueNameTextView = itemView.findViewById(R.id.venue_name_textView);
        venueCityTextView = itemView.findViewById(R.id.venue_city_textview);
        venueAddressTextView = itemView.findViewById(R.id.venue_location_textview);
        dateChoiceButton = itemView.findViewById(R.id.date_choice_button);


    }


    public void onBind(final Venue venue, UserProfile userProfile) {
        String venueId = venue.getId();
        Log.d(TAG, venueId);

        final String venueLat = venue.getLocation().getLat();
        final String venueLong = venue.getLocation().getLng();
        final String venueName = venue.getName();
        final String venueCity = venue.getLocation().getCity();
        final String venueAddress = venue.getLocation().getAddress();

        venueNameTextView.setText(venueName);
        venueCityTextView.setText(venueCity);
        venueAddressTextView.setText(venueAddress);

        dateChoiceButton.setOnClickListener(v -> {



            Intent toDateChoiceConfirmationIntent = new Intent(itemView.getContext(), MakeReservationActivity.class);
            toDateChoiceConfirmationIntent.putExtra(VENUE_NAME, venueName);
            toDateChoiceConfirmationIntent.putExtra(VENUE_ADDRESS, venueAddress);
            toDateChoiceConfirmationIntent.putExtra(DATES_NAME, userProfile.getUser());
            itemView.getContext().startActivity(toDateChoiceConfirmationIntent);

                itemView.getContext().startActivity(toDateChoiceConfirmationIntent);


                mapToProfileNavigation = (MapToProfileNavigation) v.getContext();
                mapToProfileNavigation.closeMainActivity();


        });



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(itemView.getContext(), GoogleMapsFragment.class);
                Bundle mapBundle = new Bundle();

                mapBundle.putString(LOCATION_LON, venueLong);
                mapBundle.putString(LOCATION_LAT, venueLat);
                mapBundle.putString(VENUE_NAME, venueName);
                mapBundle.putString(VENUE_ADDRESS, venueAddress);

                mapIntent.putExtras(mapBundle);
                Log.e("VENUE ON MAP: " , venueLong +" " + venueLat + " "+ venueName);

                fragmentNavigation = (FragmentNavigation) v.getContext();
                fragmentNavigation.goToLocationOnMap(venueLong, venueLat, venueName);

            }
        });

        }
}

