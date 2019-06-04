package com.example.cupidshuffle.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.cupidshuffle.R;

import java.util.Calendar;

public class MakeReservationActivity extends AppCompatActivity {


    private static final String VENUE_NAME = "venuename";
    private static final String RESERVATION_TIME = "reservationtime";
    private static final String RESERVATION_DATE = "reservationdate";
    private static final String VENUE_ADDRESS = "venueaddress";

    private TextView chooseDateAndTimeHeaderTextView;
    private TextView chooseADateTextView;
    private TextView chooseATimeTextView;
    private DatePickerDialog.OnDateSetListener chooseADateListener;
    private TimePickerDialog.OnTimeSetListener chooseATimeListener;
    private String timeOfDay;
    private Button reservationConfirmationButton;
    private Intent reservationDetailIntent;

    private LinearLayout chooseDateLinearLayout;
    private LinearLayout chooseTimeLinearLayout;

    private String venue;
    private String address;
    private String date;
    private String time;


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

        reservationDetailIntent = getIntent();

        venue = reservationDetailIntent.getStringExtra(VENUE_NAME);
        address = reservationDetailIntent.getStringExtra(VENUE_ADDRESS);


        Calendar c = Calendar.getInstance();
        final int hourChosen = c.get(Calendar.HOUR_OF_DAY);
        final int minuteChosen = c.get(Calendar.MINUTE);

        reservationConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toReservationConfirmationIntent = new Intent(MakeReservationActivity.this, DateChoiceConfirmationActivity.class);
                toReservationConfirmationIntent.putExtra(VENUE_NAME, venue);
                toReservationConfirmationIntent.putExtra(VENUE_ADDRESS, address);
                toReservationConfirmationIntent.putExtra(RESERVATION_DATE, date);
                toReservationConfirmationIntent.putExtra(RESERVATION_TIME, time);
                startActivity(toReservationConfirmationIntent);
            }
        });

        chooseDateLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MakeReservationActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        chooseADateListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }

        });


        chooseADateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                date = month + "/" + day + "/" + year;
                chooseADateTextView.setText(date);
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
                            timeOfDay = "AM";
                        } else if (hourOfDay == 12) {

                            timeOfDay = "PM";

                        } else if (hourOfDay > 12) {

                            hourOfDay -= 12;
                            timeOfDay = "PM";

                        } else {
                            timeOfDay = "AM";
                        }

                        time = hourOfDay + ":" + minute + timeOfDay;
                        chooseATimeTextView.setText(time);


                    }
                }, hourChosen, minuteChosen, false);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }



        });


        chooseATimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String time = hourOfDay + " : " + minute;
                chooseATimeTextView.setText(time);

            }
        };

    }

}
