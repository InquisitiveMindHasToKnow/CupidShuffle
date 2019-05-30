package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.FragmentNavigation;
import com.example.cupidshuffle.fragments.GoogleMapsFragment;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.example.cupidshuffle.model.Venue;


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
            public void onClick(View v) {

//                Intent toDateChoiceConfirmationIntent = new Intent(itemView.getContext(), DateChoiceConfirmationActivity.class);
//                itemView.getContext().startActivity(toDateChoiceConfirmationIntent);
 //definitely fix this later lol

         //       Toast.makeText(itemView.getContext(), "You chose to go on a date to " + venueName + "with " + ShuffleSelectedProfileFragment.USER_NAME , Toast.LENGTH_SHORT).show();

                Intent toDateChoiceConfirmationIntent = new Intent(itemView.getContext(), DateChoiceConfirmationActivity.class);
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

    }
}







//        Call<FourSquarePhotoResponse> photoResponseCall = FourSquareClient.getInstance().getPhotos(venueId);
//        photoResponseCall.enqueue(new Callback<FourSquarePhotoResponse>() {
//            @Override
//            public void onResponse(Call<FourSquarePhotoResponse> call, Response<FourSquarePhotoResponse> response) {
//                Log.d(TAG,response.body().toString());
//                List<PhotoItem> photoItems;
//                if (response.body() != null) {
//
//                    Toast.makeText(itemView.getContext(), "Please Enter A Message!", Toast.LENGTH_LONG).show();
//
//                    photoItems = response.body().getResponse().getPhotos().getItems();
//                    if (photoItems.size() ==0) {
//
//                        //  Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png").into(venueImage);
//
//                        Toast.makeText(itemView.getContext(), "Please Enter A Message!", Toast.LENGTH_LONG).show();
//

//                    }else {
//                        String prefix = photoItems.get(0).getPrefix();
//                        String suffix = photoItems.get(0).getSuffix();
//                        String photoUrl = prefix +"612x612" +suffix;
//                        Log.d(TAG,photoUrl);
//                        Picasso.get().load(photoUrl).into(venueImage);
//                    }
//                }

//                    }
                //              }
//            }
//
//            @Override
//            public void onFailure(Call<FourSquarePhotoResponse> call, Throwable t) {
//                Log.d(TAG,t.getMessage());
//
//            }
//        });
//
//    }
//
//}
