package com.example.cupidshuffle.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.ConnectionRequest;
import android.util.Log;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.UserProfileRetrofitSingleton;
import com.example.cupidshuffle.model.ConnectorAPI;
import com.example.cupidshuffle.model.ConnectorModel;
import com.example.cupidshuffle.model.PrivateMessages;
import com.example.cupidshuffle.model.UserProfiles;
import com.example.cupidshuffle.model.UserProfilesAPI;
import com.example.cupidshuffle.rv.ConnectorsRequestAdapter;
import com.example.cupidshuffle.rv.PrivateMessagesAdapter;
import com.example.cupidshuffle.rv.UserProfilesAdapter;
import com.example.cupidshuffle.services.ConnectionRequestService;
import com.example.cupidshuffle.services.UserProfileService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewAllRequestsActivity extends AppCompatActivity {

    private static final String TAG = "UserProfilesJSON.TAG";
    private RecyclerView connectionRequestRecyclerView;
    private static final String CONNECTION_REQUEST_SHARED_PREFS_KEY = "connectionRequestSharedPrefs";
    private List<ConnectorModel> connectorModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_requests);

        connectionRequestRecyclerView = findViewById(R.id.connector_request_recyclerview);
        loadConnectionRequests();

    }

    private void getConnectionRequests(){

        Retrofit retrofit = UserProfileRetrofitSingleton.getRetrofitInstance();
        ConnectionRequestService connectionRequestService = retrofit.create(ConnectionRequestService.class);
        connectionRequestService.getConnectRequest().enqueue(new Callback<ConnectorAPI>() {
            @Override
            public void onResponse(Call<ConnectorAPI> call, Response<ConnectorAPI> response) {
                Log.d(TAG, "This retrofit works, Omar! " + response.body().getConnectRequest());
                connectorModelList.addAll(response.body().getConnectRequest());
                ConnectorsRequestAdapter connectorsRequestAdapter = new ConnectorsRequestAdapter(connectorModelList);
                connectionRequestRecyclerView.setAdapter(connectorsRequestAdapter);
                connectionRequestRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                saveConnectionRequests();
            }

            @Override
            public void onFailure(Call<ConnectorAPI> call, Throwable t) {
                Log.d(TAG, "Retrofit call failed" + t.getMessage());
            }
        });

    }

    private void  saveConnectionRequests(){

        SharedPreferences sharedPreferences = getSharedPreferences(CONNECTION_REQUEST_SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(connectorModelList);
        editor.putString("weneedtoconnect", json);
        editor.apply();
    }

    private void  loadConnectionRequests(){

        SharedPreferences sharedPreferences = getSharedPreferences(CONNECTION_REQUEST_SHARED_PREFS_KEY, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("weneedtoconnect", null);
        Type type = new TypeToken<ArrayList<ConnectorModel>>() {}.getType();
        connectorModelList = gson.fromJson(json, type);



        if (connectorModelList == null || connectorModelList.isEmpty()) {
            connectorModelList = new ArrayList<>();
            getConnectionRequests();

        }
        ConnectorsRequestAdapter connectorsRequestAdapter = new ConnectorsRequestAdapter(connectorModelList);
        connectionRequestRecyclerView.setAdapter(connectorsRequestAdapter);
        connectionRequestRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    }


