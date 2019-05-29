package com.example.cupidshuffle.activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.FourSquarePhotoResponse;
import com.example.cupidshuffle.model.PhotoItem;
import com.example.cupidshuffle.model.Venue;
import com.example.cupidshuffle.network.FourSquareClient;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenuesViewHolder extends RecyclerView.ViewHolder {
    private ImageView venueImage;
    private TextView venueName;
    public static final String TAG = "PhotosCall";


    public VenuesViewHolder(@NonNull View itemView) {
        super(itemView);

        venueImage = itemView.findViewById(R.id.venue_imageView);
        venueName = itemView.findViewById(R.id.venue_textView);

    }


    public void onBind(final Venue venue) {
        String venueId = venue.getId();
        Log.d(TAG,venueId);
        venueName.setText(venue.getName());
        Call<FourSquarePhotoResponse> photoResponseCall = FourSquareClient.getInstance().getPhotos(venueId);
        photoResponseCall.enqueue(new Callback<FourSquarePhotoResponse>() {
            @Override
            public void onResponse(Call<FourSquarePhotoResponse> call, Response<FourSquarePhotoResponse> response) {
                Log.d(TAG,response.body().toString());
                List<PhotoItem> photoItems;
                if (response.body() != null) {
                    photoItems = response.body().getResponse().getPhotos().getItems();
                    if (photoItems.size() ==0){
                        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png").into(venueImage);
                    }else {
                        String prefix = photoItems.get(0).getPrefix();
                        String suffix = photoItems.get(0).getSuffix();
                        String photoUrl = prefix +"612x612" +suffix;
                        Log.d(TAG,photoUrl);
                        Picasso.get().load(photoUrl).into(venueImage);
                    }
                }


            }

            @Override
            public void onFailure(Call<FourSquarePhotoResponse> call, Throwable t) {
                Log.d(TAG,t.getMessage());

            }
        });

    }

}
