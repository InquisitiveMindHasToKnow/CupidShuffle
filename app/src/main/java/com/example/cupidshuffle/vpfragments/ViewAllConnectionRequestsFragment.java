package com.example.cupidshuffle.vpfragments;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.network.RetrofitSingleton;
import com.example.cupidshuffle.model.ConnectorAPI;
import com.example.cupidshuffle.model.ConnectorModel;
import com.example.cupidshuffle.rv.ConnectorsRequestAdapter;
import com.example.cupidshuffle.services.ConnectionRequestService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class ViewAllConnectionRequestsFragment extends Fragment {



    private static final String TAG = "UserProfilesJSON.TAG";
    private RecyclerView connectionRequestRecyclerView;
    private static final String CONNECTION_REQUEST_SHARED_PREFS_KEY = "connectionRequestSharedPrefs";
    private List<ConnectorModel> connectorModelList;
    private View rootView;


    public ViewAllConnectionRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_view_all_connection_requests, container, false);

        BottomNavigationView navView = rootView.findViewById(R.id.nav_view);

        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);


        connectionRequestRecyclerView = rootView.findViewById(R.id.connector_request_recyclerview);
        loadConnectionRequests();

        return rootView;
    }

    private void getConnectionRequests() {

        Retrofit retrofit = RetrofitSingleton.getSinglenstance();
        ConnectionRequestService connectionRequestService = retrofit.create(ConnectionRequestService.class);
        connectionRequestService.getConnectRequest().enqueue(new Callback<ConnectorAPI>() {
            @Override
            public void onResponse(Call<ConnectorAPI> call, Response<ConnectorAPI> response) {
                Log.d(TAG, "This retrofit works, Omar! " + response.body().getConnectRequest());
                connectorModelList.addAll(response.body().getConnectRequest());
                ConnectorsRequestAdapter connectorsRequestAdapter = new ConnectorsRequestAdapter(connectorModelList);
                connectionRequestRecyclerView.setAdapter(connectorsRequestAdapter);
                connectionRequestRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                saveConnectionRequests();
            }

            @Override
            public void onFailure(Call<ConnectorAPI> call, Throwable t) {
                Log.d(TAG, "Retrofit call failed" + t.getMessage());


                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getContext())
                                .setIcon(R.drawable.nointernetconnection)
                                .setTitle("Uh-Oh!")
                                .setMessage("Slow or no internet connection. Please check your settings and refresh the page.")
                                .setPositiveButton("Refresh", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                builder.create().show();
            }
        });

    }

    private void saveConnectionRequests() {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(CONNECTION_REQUEST_SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(connectorModelList);
        editor.putString("weneedtoconnect", json);
        editor.apply();
    }

    private void loadConnectionRequests() {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(CONNECTION_REQUEST_SHARED_PREFS_KEY, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("weneedtoconnect", null);
        Type type = new TypeToken<ArrayList<ConnectorModel>>() {
        }.getType();
        connectorModelList = gson.fromJson(json, type);


        if (connectorModelList == null || connectorModelList.isEmpty()) {
            connectorModelList = new ArrayList<>();
            getConnectionRequests();

        }
        ConnectorsRequestAdapter connectorsRequestAdapter = new ConnectorsRequestAdapter(connectorModelList);
        connectionRequestRecyclerView.setAdapter(connectorsRequestAdapter);
        connectionRequestRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }



}
