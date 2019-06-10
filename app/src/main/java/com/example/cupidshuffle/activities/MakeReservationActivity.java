package com.example.cupidshuffle.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.AllUserProfilesFragment;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.example.cupidshuffle.fragments.UserProfileFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.cupidshuffle.rv.VenuesViewHolder.DATES_NAME;
import static com.example.cupidshuffle.rv.VenuesViewHolder.VENUE_ADDRESS;
import static com.example.cupidshuffle.rv.VenuesViewHolder.VENUE_NAME;

public class MakeReservationActivity extends AppCompatActivity {
    private static final String ACCENT_TEXT_COLOR_BOLD_OPEN = "<font color = '#C4A29E'><b>";
    private static final String ACCENT_TEXT_COLOR_BOLD_CLOSE = "</b></font>";


    private static final String RESERVATION_TIME = "reservationtime";
    private static final String RESERVATION_DATE = "reservationdate";
    public static final int NOTIFICATION_ID = 0;
    public static final String PRIMARY_CHANNEL_ID = "PRIMARY_CHANNEL_ID";

    private TextView chooseDateAndTimeHeaderTextView;
    private TextView chooseADateTextView;
    private TextView chooseATimeTextView;
    private DatePickerDialog.OnDateSetListener chooseADateListener;
    private TimePickerDialog.OnTimeSetListener chooseATimeListener;
    private String timeOfDay;
    private Button reservationConfirmationButton;
    private Intent reservationDetailIntent;
    private ProgressBar progressBar;
    private NotificationManager notificationManager;
    private Intent dateIntent;


    private LinearLayout chooseDateLinearLayout;
    private LinearLayout chooseTimeLinearLayout;

    private String venue;
    private String address;
    private String date;
    private String time;
    private String dateName;


    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reservation);

        chooseDateLinearLayout = findViewById(R.id.select_date_linear);
        chooseTimeLinearLayout = findViewById(R.id.select_time_linear);


        chooseDateAndTimeHeaderTextView = findViewById(R.id.chooseDateAndTimeForDatePromptTextView);
        chooseADateTextView = findViewById(R.id.date_selected);
        chooseATimeTextView = findViewById(R.id.time_selected);
        reservationConfirmationButton = findViewById(R.id.confirm_preferred_date_and_time);

        progressBar = findViewById(R.id.progress_circular);
        progressBar.setVisibility(View.GONE);

        reservationDetailIntent = getIntent();

        venue = reservationDetailIntent.getStringExtra(VENUE_NAME);
        address = reservationDetailIntent.getStringExtra(VENUE_ADDRESS);

        dateIntent = getIntent();

        venue = dateIntent.getStringExtra(VENUE_NAME);
        address = dateIntent.getStringExtra(VENUE_ADDRESS);
        date = dateIntent.getStringExtra(RESERVATION_DATE);
        time = dateIntent.getStringExtra(RESERVATION_TIME);
        dateName = dateIntent.getStringExtra(DATES_NAME);


        Calendar c = Calendar.getInstance();
        final int hourChosen = c.get(Calendar.HOUR_OF_DAY);
        final int minuteChosen = c.get(Calendar.MINUTE);


        chooseDateLinearLayout.setOnClickListener(v -> {

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    MakeReservationActivity.this, R.style.DatePickerDialogTheme, chooseADateListener, year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            dialog.show();
        });


        chooseADateListener = (datePicker, year, month, day) -> {
            month = month + 1;


            date = month + "/" + day + "/" + year;

            try {
                if (new SimpleDateFormat("MM/dd/yyyy").parse(date).equals(new Date()) || new SimpleDateFormat("MM/dd/yyyy").parse(date).after(new Date())) {

                    chooseADateTextView.setText(date);
                }

                if (new SimpleDateFormat("MM/dd/yyyy").parse(date).before(new Date())) {

                    Toast.makeText(MakeReservationActivity.this, "Date Or Time Cannot Be In The Past.", Toast.LENGTH_LONG).show();

                }


            } catch (ParseException e) {
                e.printStackTrace();

            }
        };



        chooseTimeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog dialog = new TimePickerDialog(MakeReservationActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay == 0) {

                            hourOfDay += 12;
                            timeOfDay = " AM";
                        } else if (hourOfDay == 12) {

                            timeOfDay = " PM";

                        } else if (hourOfDay > 12) {

                            hourOfDay -= 12;
                            timeOfDay = " PM";

                        } else {
                            timeOfDay = " AM";
                        }

                        if (minute < 10) {
                            time = hourOfDay + ":0" + minute + timeOfDay;
                        } else
                            time = hourOfDay + ":" + minute + timeOfDay;
                        chooseATimeTextView.setText(time);

                    }
                }, hourChosen, minuteChosen, false);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        chooseATimeListener = (view, hourOfDay, minute) -> {


            String time = hourOfDay + " : " + minute;
            chooseATimeTextView.setText(time);

        };



        reservationConfirmationButton.setOnClickListener(v -> {
            if (TextUtils.isEmpty(chooseADateTextView.getText()) || TextUtils.isEmpty(chooseATimeTextView.getText())) {
                Toast.makeText(MakeReservationActivity.this, "Date Or Time Cannot Be Left Blank.", Toast.LENGTH_LONG).show();
            } else {

                StringBuffer dateRequestSent_string = new StringBuffer();
                dateRequestSent_string
                        .append("You've sent a request to go on a date to  ")
                        .append(ACCENT_TEXT_COLOR_BOLD_OPEN)
                        .append(venue)
                        .append(ACCENT_TEXT_COLOR_BOLD_CLOSE)
                        .append(" with ")
                        .append(ACCENT_TEXT_COLOR_BOLD_OPEN)
                        .append(dateName)
                        .append(ACCENT_TEXT_COLOR_BOLD_CLOSE)
                        .append(" on ")
                        .append(ACCENT_TEXT_COLOR_BOLD_OPEN)
                        .append(date)
                        .append(ACCENT_TEXT_COLOR_BOLD_CLOSE)
                        .append(" at ")
                        .append(ACCENT_TEXT_COLOR_BOLD_OPEN)
                        .append(time)
                        .append(ACCENT_TEXT_COLOR_BOLD_CLOSE)
                        .trimToSize();

                progressBar.setVisibility(View.VISIBLE);

                new Handler().postDelayed(() -> {
                    progressBar.setVisibility(View.GONE);

                    AlertDialog.Builder dateRequestBuilder =
                            new AlertDialog.Builder(MakeReservationActivity.this)
                                    .setIcon(R.drawable.date_request_tag)
                                    .setTitle("Request Successful!")
                                    .setMessage(Html.fromHtml(dateRequestSent_string.toString()))
                                    .setPositiveButton("Continue", (dateRequestDialog, which) -> {
                                        finish();
                                    });
                    dateRequestBuilder.create().show();

                    new Handler().postDelayed(() -> {
                        createNotificationChannel();

                        sendNotification();

                    }, 10000);
                }, 1500);


            }
        });


    }

    public void sendNotification() {
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        notificationManager.notify(NOTIFICATION_ID, notifyBuilder.build());

    }

    public void createNotificationChannel() {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "CupidShuffle Notification", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification For New Location Sent");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        Intent notificationIntent = new Intent(this, ShowReservationActivity.class);
        notificationIntent.putExtra(VENUE_NAME, venue);
        notificationIntent.putExtra(VENUE_ADDRESS, address);
        notificationIntent.putExtra(DATES_NAME, dateName);
        notificationIntent.putExtra(RESERVATION_DATE, date);
        notificationIntent.putExtra(RESERVATION_TIME, time);

        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("Great News!!!")
                .setContentText(dateName + " Has Agreed To Meet Up At " + venue + ". Click To Confirm A Date And Time")
                .setSmallIcon(R.drawable.notificationcupid)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
    }
}