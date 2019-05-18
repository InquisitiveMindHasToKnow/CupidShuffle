//package com.example.cupidshuffle.rv;
//
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.example.cupidshuffle.R;
//import com.example.cupidshuffle.activities.RespondToDMActivity;
//import com.example.cupidshuffle.model.PrivateMessages;
//
//
//public class PrivateMessagesViewHolder extends RecyclerView.ViewHolder {
//
//    private static final String dMSendersName = "dmSendersName";
//    private static final String dMedMessage = "dMedMessage";
//
//    private TextView privateMessageSenderTextView;
//    private TextView privateMessageTextView;
//    private Button dMRespondButton;
//    private Button dMRejectButton;
//
//
//    public PrivateMessagesViewHolder(@NonNull View itemView) {
//        super(itemView);
//
//        privateMessageSenderTextView = itemView.findViewById(R.id.private_message_senders_name_textview);
//        privateMessageTextView = itemView.findViewById(R.id.private_message_senders_message_textview);
//        dMRespondButton = itemView.findViewById(R.id.private_message_accept_button);
//        dMRejectButton = itemView.findViewById(R.id.private_message_reject_button);
//    }
//
//
//    public void onBind(final PrivateMessages privateMessages) {
//
//        privateMessageSenderTextView.setText(privateMessages.getSender());
//        privateMessageTextView.setText(privateMessages.getMessage());
//
//
//        dMRespondButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent toRespondToDMActivityIntent = new Intent(itemView.getContext(), RespondToDMActivity.class);
//
//                toRespondToDMActivityIntent.putExtra(dMSendersName, privateMessages.getSender());
//                toRespondToDMActivityIntent.putExtra(dMedMessage, privateMessages.getMessage());
//                itemView.getContext().startActivity(toRespondToDMActivityIntent);
//            }
//        });
//
//        dMRejectButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                privateMessagesAdapter.deletePrivateMessage(getAdapterPosition());
//            }
//        });
//
//    }
//}
