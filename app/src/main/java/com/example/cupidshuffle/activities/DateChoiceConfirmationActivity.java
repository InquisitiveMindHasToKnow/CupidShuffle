package com.example.cupidshuffle.activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.squareup.picasso.Picasso;

public class DateChoiceConfirmationActivity extends AppCompatActivity {

    private static final String RESERVATION_TIME = "reservationtime";
    private static final String RESERVATION_DATE = "reservationdate";
    private static final String VENUE_NAME = "venuename";
    private static final String VENUE_ADDRESS = "venueaddress";

    private Intent dateIntent;
    private TextView dateMessageTextView;
    private ImageView dateImageView;

    public static final int NOTIFICATION_ID =0 ;
    public static final String PRIMARY_CHANNEL_ID = "PRIMARY_CHANNEL_ID" ;
    private NotificationManager notificationManager;

    private String venue;
    private String venueAddress;
    private String date;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_choice_confirmation);

        dateMessageTextView = findViewById(R.id.date_selection_message_textview);
        dateImageView = findViewById(R.id.date_selection_imageview);

        dateIntent = getIntent();

        venue = dateIntent.getStringExtra(VENUE_NAME);
        venueAddress = dateIntent.getStringExtra(VENUE_ADDRESS);
        date = dateIntent.getStringExtra(RESERVATION_DATE);
        time = dateIntent.getStringExtra(RESERVATION_TIME);


        dateMessageTextView.setText("You Chose To Go On A Date To " +  venue + " with " + ShuffleSelectedProfileFragment.USER_NAME);

        Picasso.get()
                .load(R.drawable.greencheckmark)
                .into(dateImageView);



        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                createNotificationChannel();

                sendNotification();

            }
        }, 10000);



    }

    public void sendNotification(){
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        notificationManager.notify(NOTIFICATION_ID, notifyBuilder.build());

    }

    public void createNotificationChannel(){
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "CupidShuffle Notification",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification For New Location Sent");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder(){
        Intent notificationIntent = new Intent(this,ShowReservationActivity.class);
        notificationIntent.putExtra(VENUE_NAME, venue);
        notificationIntent.putExtra(VENUE_ADDRESS, venueAddress);
        notificationIntent.putExtra(RESERVATION_DATE, date);
        notificationIntent.putExtra(RESERVATION_TIME, time);

        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID)
                .setContentTitle("Great News!!!")
                .setContentText(ShuffleSelectedProfileFragment.USER_NAME + " Has Agreed To Meet Up At " + venue + ". Click To Confirm A Date And Time")
                .setSmallIcon(R.drawable.notificationcupid)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
    }

}
