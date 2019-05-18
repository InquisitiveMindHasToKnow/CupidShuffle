package com.example.cupidshuffle.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.PrivateMessages;

import java.util.List;

public class PrivateMessagesAdapter extends RecyclerView.Adapter<PrivateMessagesViewHolder> {

    private List<PrivateMessages> privateMessagesList;

    public PrivateMessagesAdapter(List<PrivateMessages> privateMessagesList) {
        this.privateMessagesList = privateMessagesList;
    }

    @NonNull
    @Override
    public PrivateMessagesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
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
}
