package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cupidshuffle.R;

public class RespondToDMActivity extends AppCompatActivity {

    private static final String dMSendersName = "dmSendersName";
    private static final String dMedMessage = "dMedMessage";

    private Intent getInfoToRespondToIntent;
    private TextView sendersNameTextView;
    private TextView sendersMessageTextView;
    private Button sendResponseButton;
    private Button cancelResponseButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respond_to_dm);

        getInfoToRespondToIntent = getIntent();

        sendersNameTextView = findViewById(R.id.respond_to_dm_requestors_name_textview);
        sendersMessageTextView = findViewById(R.id.dm_textview);
        sendResponseButton = findViewById(R.id.send_response_to_dm_button);
        cancelResponseButton = findViewById(R.id.cancel_response_to_dm_button);

        sendersNameTextView.setText("Responding to " + getInfoToRespondToIntent.getStringExtra(dMSendersName) + "'s Message:");
        sendersMessageTextView.setText(getInfoToRespondToIntent.getStringExtra(dMedMessage));

        sendResponseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSentMessageConfirmationIntent = new Intent(RespondToDMActivity.this, SentMessageConfirmationActivity.class);
                startActivity(toSentMessageConfirmationIntent);
            }
        });
    }
}
