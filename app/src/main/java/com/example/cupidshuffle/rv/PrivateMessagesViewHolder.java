package com.example.cupidshuffle.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.PrivateMessages;

public class PrivateMessagesViewHolder extends RecyclerView.ViewHolder {

    private TextView privateMessageSenderTextView;
    private TextView privateMessageTextView;

    public PrivateMessagesViewHolder(@NonNull View itemView) {
        super(itemView);

        privateMessageSenderTextView = itemView.findViewById(R.id.private_message_senders_name_textview);
        privateMessageTextView = itemView.findViewById(R.id.private_message_senders_message_textview);
    }

    public void onBind(PrivateMessages privateMessages) {

        privateMessageSenderTextView.setText(privateMessages.getSender());
        privateMessageTextView.setText(privateMessages.getMessage());
    }
}
