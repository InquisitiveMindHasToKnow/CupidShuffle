package com.example.cupidshuffle.vpfragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.RetrofitSingleton;
import com.example.cupidshuffle.model.PrivateMessages;
import com.example.cupidshuffle.model.PrivateMessagesAPI;
import com.example.cupidshuffle.rv.PrivateMessagesAdapter;
import com.example.cupidshuffle.services.PrivateMessageService;
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


public class ViewAllPrivateMessagesFragment extends Fragment {


        private static final String TAG = "PrivateMessagesJSON.TAG";
        private static final String DM_SHARED_PREFS_KEY = "privateMessagesSharedPrefs";
        private RecyclerView privateMessagesRecyclerView;
        private List<PrivateMessages> privateMessagesList;
        private View rootView;


        public ViewAllPrivateMessagesFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.fragment_view_all_private_messages, container, false);

            privateMessagesRecyclerView = rootView.findViewById(R.id.private_messages_recyclerview);
            loadPrivateMessages();

            return rootView;
        }

        private void getPrivateMessages(){

            Retrofit retrofit = RetrofitSingleton.getSinglenstance();
            PrivateMessageService privateMessageService = retrofit.create(PrivateMessageService.class);
            privateMessageService.getPrivateMessages().enqueue(new Callback<PrivateMessagesAPI>() {


                @Override
                public void onResponse(Call<PrivateMessagesAPI> call, Response<PrivateMessagesAPI> response) {
                    Log.d(TAG, "This retrofit works, Omar! " + response.body().getPrivateMessages());

                    privateMessagesList.addAll(response.body().getPrivateMessages());
                    PrivateMessagesAdapter privateMessagesAdapter = new PrivateMessagesAdapter(privateMessagesList);
                    privateMessagesRecyclerView.setAdapter(privateMessagesAdapter);
                    privateMessagesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    savePrivateMessages();

                }

                @Override
                public void onFailure(Call<PrivateMessagesAPI> call, Throwable t) {
                    Log.d(TAG, "Retrofit call failed" + t.getMessage());
                }
            });
        }

        private void savePrivateMessages() {
            SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(DM_SHARED_PREFS_KEY, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(privateMessagesList);
            editor.putString("slideinthedms", json);
            editor.apply();
        }

        private void loadPrivateMessages() {
            SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(DM_SHARED_PREFS_KEY, MODE_PRIVATE);
            Gson gson = new Gson();
            String json = sharedPreferences.getString("slideinthedms", null);
            Type type = new TypeToken<ArrayList<PrivateMessages>>() {}.getType();
            privateMessagesList = gson.fromJson(json, type);



            if (privateMessagesList == null || privateMessagesList.isEmpty()) {
                privateMessagesList = new ArrayList<>();
                getPrivateMessages();

            }
            PrivateMessagesAdapter privateMessagesAdapter = new PrivateMessagesAdapter(privateMessagesList);
            privateMessagesRecyclerView.setAdapter(privateMessagesAdapter);
            privateMessagesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

    }
