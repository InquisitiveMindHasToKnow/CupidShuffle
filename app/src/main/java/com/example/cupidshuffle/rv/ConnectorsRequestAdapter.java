package com.example.cupidshuffle.rv;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.ConnectorModel;
import com.google.gson.Gson;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ConnectorsRequestAdapter extends RecyclerView.Adapter<ConnectorsRequestAdapter.ConnectorsRequestViewHolder> {

    private List<ConnectorModel> connectorModelList;
    private static final String CONNECTION_REQUEST_SHARED_PREFS_KEY = "connectionRequestSharedPrefs";
    private SharedPreferences connectionRequestSharedPrefs;

    public ConnectorsRequestAdapter(List<ConnectorModel> connectorModelList) {
        this.connectorModelList = connectorModelList;
    }

    @NonNull
    @Override
    public ConnectorsRequestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        connectionRequestSharedPrefs = viewGroup.getContext().getSharedPreferences(CONNECTION_REQUEST_SHARED_PREFS_KEY, MODE_PRIVATE);
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.connector_request_itemview, viewGroup, false);
        return new ConnectorsRequestViewHolder(childView);
    }


    @Override
    public void onBindViewHolder(@NonNull ConnectorsRequestViewHolder connectorsRequestViewHolder, int i) {

        ConnectorModel connectorModel = connectorModelList.get(i);
        connectorsRequestViewHolder.onBind(connectorModel);

    }

    @Override
    public int getItemCount() {
        return connectorModelList.size();
    }


    public void deleteConnectionRequest(int position) {
        connectorModelList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, connectorModelList.size());
        saveConnectionRequest();


    }

    private void saveConnectionRequest() {

        SharedPreferences.Editor editor = connectionRequestSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(connectorModelList);
        editor.putString("weneedtoconnect", json);
        editor.apply();
    }

    public class ConnectorsRequestViewHolder extends RecyclerView.ViewHolder {

        private TextView connectorRequestNameAndMessageTextView;
        private Button connectRequestRespondButton;
        private Button connectRequestRejectButton;
        private String userName;
        private String userMessage = " Would Like To Connect!";


        public ConnectorsRequestViewHolder(@NonNull View itemView) {
            super(itemView);

            connectorRequestNameAndMessageTextView = itemView.findViewById(R.id.connectors_name_textview);
            connectRequestRespondButton = itemView.findViewById(R.id.connection_request_accept_button);
            connectRequestRejectButton = itemView.findViewById(R.id.connection_request_reject_button);
        }

        public void onBind(ConnectorModel connectorModel) {

            userName = connectorModel.getConnect();

            connectorRequestNameAndMessageTextView.setText(userName + userMessage);

            connectRequestRespondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(itemView.getContext(), userName +"'s Request Acccepted They May Now View Your Profile.", Toast.LENGTH_LONG).show();
                    deleteConnectionRequest(getAdapterPosition());

                }

            });

            connectRequestRejectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    deleteConnectionRequest(getAdapterPosition());
                }
            });

        }
    }
}
