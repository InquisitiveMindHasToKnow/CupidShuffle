package com.example.cupidshuffle.rv;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.example.cupidshuffle.model.PrivateMessages;
import com.google.gson.Gson;

import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static android.content.Context.MODE_PRIVATE;

public class PrivateMessagesAdapter extends RecyclerView.Adapter<PrivateMessagesAdapter.PrivateMessagesViewHolder> {

    private static final String DM_SHARED_PREFS_KEY = "privateMessagesSharedPrefs";
    private SharedPreferences privateMessageSharedPrefs;
    private List<PrivateMessages> privateMessagesList;

    public PrivateMessagesAdapter(List<PrivateMessages> privateMessagesList) {
        this.privateMessagesList = privateMessagesList;
    }

    @NonNull
    @Override
    public PrivateMessagesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        privateMessageSharedPrefs = viewGroup.getContext().getSharedPreferences(DM_SHARED_PREFS_KEY, MODE_PRIVATE);
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.private_messages_itemview, viewGroup, false);
        return new PrivateMessagesViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull PrivateMessagesViewHolder privateMessagesViewHolder, int i) {

        PrivateMessages privateMessages = privateMessagesList.get(i);
        privateMessagesViewHolder.onBind(privateMessages);

    }

    @Override
    public int getItemCount() {
        return privateMessagesList.size();
    }

    public void deletePrivateMessage(int position) {
        privateMessagesList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, privateMessagesList.size());

        savePrivateMessages();


    }

    private void savePrivateMessages() {

        SharedPreferences.Editor editor = privateMessageSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(privateMessagesList);
        editor.putString("slideinthedms", json);
        editor.apply();
    }

    public class PrivateMessagesViewHolder extends RecyclerView.ViewHolder {

        private static final String dMSendersName = "dmSendersName";
        private static final String dMedMessage = "dMedMessage";

        private TextView privateMessageSenderTextView;
        private TextView privateMessageTextView;
        private Button dMRespondButton;
        private Button dMRejectButton;

        private Context context;


        public PrivateMessagesViewHolder(@NonNull View itemView) {
            super(itemView);

            privateMessageSenderTextView = itemView.findViewById(R.id.private_message_senders_name_textview);
            privateMessageTextView = itemView.findViewById(R.id.private_message_senders_message_textview);
            dMRespondButton = itemView.findViewById(R.id.private_message_accept_button);
            dMRejectButton = itemView.findViewById(R.id.private_message_reject_button);
        }


        public void onBind(final PrivateMessages privateMessages) {

            privateMessageSenderTextView.setText(privateMessages.getSender());
            privateMessageTextView.setText(privateMessages.getMessage());


            dMRespondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());

                    final EditText respondToDMEdittext = new EditText(v.getContext());

                    alertDialog.setTitle("Sending message to " + privateMessages.getSender());
                    alertDialog.setMessage("Enter your message: ");
                    alertDialog.setView(respondToDMEdittext);

                    alertDialog.setPositiveButton("Send",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent sendMessageIntent = new Intent(v.getContext(), ShuffleSelectedProfileFragment.class);

                                    if (TextUtils.isEmpty(respondToDMEdittext.getText())) {
                                        if (context instanceof Activity)
                                            ((Activity) context).setResult(RESULT_CANCELED, sendMessageIntent);

                                        Toast.makeText(v.getContext(), "You cannot send an empty message.", Toast.LENGTH_LONG).show();
                                    }else {

                                        deletePrivateMessage(getAdapterPosition());
                                        Toast.makeText(v.getContext(), "Message sent!", Toast.LENGTH_LONG).show();
                                    }

                                }
                            });
                    alertDialog.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    alertDialog.show();

                }
            });



            dMRejectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deletePrivateMessage(getAdapterPosition());
                }
            });

        }
    }
}