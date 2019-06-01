package com.example.cupidshuffle.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.cupidshuffle.R;

import java.util.Calendar;

public class MakeReservationActivity extends AppCompatActivity {

    private TextView chooseDateAndTimeHeaderTextView;
    private TextView chooseADateTextView;
    private TextView chooseATimeTextView;
    private DatePickerDialog.OnDateSetListener chooseADateListener;
    private TimePickerDialog.OnTimeSetListener chooseATimeListener;
    private String timeOfDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reservation);
        chooseDateAndTimeHeaderTextView = findViewById(R.id.chooseDateAndTimeForDatePromptTextView);
        chooseADateTextView = findViewById(R.id.date_selected);
        chooseATimeTextView = findViewById(R.id.time_selected);

        Calendar c = Calendar.getInstance();
        final int hourChosen = c.get(Calendar.HOUR_OF_DAY);
        final int minuteChosen = c.get(Calendar.MINUTE);

        chooseADateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                String date = month + "/" + day + "/" + year;
                chooseADateTextView.setText(date);
            }
        };

        chooseATimeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog dialog = new TimePickerDialog(MakeReservationActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay == 0) {

                            hourOfDay += 12;
                            timeOfDay = "AM";
                        }
                        else if (hourOfDay == 12) {

                            timeOfDay = "PM";

                        }
                        else if (hourOfDay > 12) {

                            hourOfDay -= 12;
                            timeOfDay = "PM";

                        }
                        else {
                            timeOfDay = "AM";
                        }

                        chooseATimeTextView.setText(hourOfDay + ":" + minute + timeOfDay);


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