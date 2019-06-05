package com.example.cupidshuffle.rv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.activities.IndividualProfilePage;
import com.example.cupidshuffle.activities.PrivateProfileActivity;
import com.example.cupidshuffle.model.ConnectorModel;
import com.google.gson.Gson;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

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

        private static final String REQUESTORS_USER_NAME = "requestorsusername";
        private static final String REQUESTOR_USER_PICTURE = "requestorspicutre";

        private TextView connectorRequestNameAndMessageTextView;
        private CircularImageView requestConnectorsCircularImageView;
        private Button connectRequestRespondButton;
        private Button connectRequestRejectButton;
        private String userName;
        private String userMessage = " Would Like To Connect!";


        public ConnectorsRequestViewHolder(@NonNull View itemView) {
            super(itemView);

            connectorRequestNameAndMessageTextView = itemView.findViewById(R.id.connectors_name_textview);
            connectRequestRespondButton = itemView.findViewById(R.id.connection_request_accept_button);
            connectRequestRejectButton = itemView.findViewById(R.id.connection_request_reject_button);
            requestConnectorsCircularImageView = itemView.findViewById(R.id.request_connectors_circular_imageview);
        }

        public void onBind(final ConnectorModel connectorModel) {

            Picasso.get()
                    .load(connectorModel.getPicture())
                    .into(requestConnectorsCircularImageView);

            requestConnectorsCircularImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent toPrivateProfileIntent = new Intent(itemView.getContext(), PrivateProfileActivity.class);

                    toPrivateProfileIntent.putExtra(REQUESTORS_USER_NAME, connectorModel.getConnect());
                    toPrivateProfileIntent.putExtra(REQUESTOR_USER_PICTURE, connectorModel.getPicture());
                    v.getContext().startActivity(toPrivateProfileIntent);
                }
            });

            userName = connectorModel.getConnect();

            connectorRequestNameAndMessageTextView.setText(userName + userMessage);

            connectRequestRespondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(itemView.getContext(), userName +"'s Request Accepted. They May Now View Your Profile.", Toast.LENGTH_LONG).show();
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
