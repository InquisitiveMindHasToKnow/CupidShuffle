package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.squareup.picasso.Picasso;

public class ShowReservationActivity extends AppCompatActivity {

    private static final String VENUE_NAME = "venuename";
    private static final String VENUE_ADDRESS = "venueaddress";
    private static final String RESERVATION_TIME = "reservationtime";
    private static final String RESERVATION_DATE = "reservationdate";

    private TextView reservationPageHeaderTextView;
    private TextView reservationPageVenueTextView;
    private TextView reservationPageDateAndTimeTextView;
    private TextView reservationPageWhosYourDateTextView;
    private ImageView reservationShareButtonImageView;
    private Intent showReservationIntent;

    private String venueName;
    private String address;
    private String dateOfReservation;
    private String timeOfReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reservation);

        showReservationIntent = getIntent();

        reservationPageHeaderTextView = findViewById(R.id.reservation_page_header_textview);
        reservationPageVenueTextView = findViewById(R.id.reservation_page_location_name_textview);
        reservationPageDateAndTimeTextView = findViewById(R.id.reservation_page_date_and_time_textview);
        reservationPageWhosYourDateTextView = findViewById(R.id.reservation_page_date_with_textview);
        reservationShareButtonImageView = findViewById(R.id.reservation_information_share_icon);

        venueName = showReservationIntent.getStringExtra(VENUE_NAME);
        address = showReservationIntent.getStringExtra(VENUE_ADDRESS);
        dateOfReservation = showReservationIntent.getStringExtra(RESERVATION_DATE);
        timeOfReservation = showReservationIntent.getStringExtra(RESERVATION_TIME);

        Log.e("STUFF FOR RESERVATION" , address);

        reservationPageVenueTextView.setText(venueName + "\n" + address);
        reservationPageWhosYourDateTextView.setText(ShuffleSelectedProfileFragment.USER_NAME);
        reservationPageDateAndTimeTextView.setText(dateOfReservation + " At " + timeOfReservation);

        Picasso.get()
                .load(R.drawable.reservationshareicon)
                .into(reservationShareButtonImageView);

        reservationShareButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Date Reservation Details");
                emailIntent.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Email Reservation Details"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ShowReservationActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
