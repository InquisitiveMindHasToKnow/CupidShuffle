package com.example.cupidshuffle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;

public class RespondToDMActivity extends AppCompatActivity {

    private static final String dMSendersName = "dmSendersName";
    private static final String dMedMessage = "dMedMessage";

    private Intent getInfoToRespondToIntent;
    private TextView sendersNameTextView;
    private TextView sendersMessageTextView;
    private TextView sendersNameInCardTextView;
    private Button sendResponseButton;
    private Button cancelResponseButton;
    private EditText respondToDMEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respond_to_dm);

        getInfoToRespondToIntent = getIntent();

        sendersNameTextView = findViewById(R.id.respond_to_dm_requestors_name_textview);
        sendersMessageTextView = findViewById(R.id.dm_textview);
        sendersNameInCardTextView = findViewById(R.id.dm_requestors_name_on_card);
        respondToDMEditText = findViewById(R.id.respond_to_dm_edittext);
        sendResponseButton = findViewById(R.id.send_response_to_dm_button);
        cancelResponseButton = findViewById(R.id.cancel_response_to_dm_button);

        sendersNameInCardTextView.setText(getInfoToRespondToIntent.getStringExtra(dMSendersName)+ ":");
        sendersNameTextView.setText("Responding to " + getInfoToRespondToIntent.getStringExtra(dMSendersName) + "'s Message:");
        sendersMessageTextView.setText(getInfoToRespondToIntent.getStringExtra(dMedMessage));

        sendResponseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSentMessageConfirmationIntent = new Intent(RespondToDMActivity.this, SentMessageConfirmationActivity.class);
                if (TextUtils.isEmpty(respondToDMEditText.getText())) {
                    setResult(RESULT_CANCELED, toSentMessageConfirmationIntent);
                    Toast.makeText(RespondToDMActivity.this, "Please Enter A Message!", Toast.LENGTH_LONG).show();
                }else{
                    startActivity(toSentMessageConfirmationIntent);
                }
            }
        });

        cancelResponseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toViewPrivateMessagesIntent = new Intent(RespondToDMActivity.this, ViewPrivateMessagesAndConnectionRequest.class);
                startActivity(toViewPrivateMessagesIntent);
            }
        });
    }
}
