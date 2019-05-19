package com.example.cupidshuffle.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.cupidshuffle.R;
import com.example.cupidshuffle.model.PrivateMessages;
import com.example.cupidshuffle.model.PrivateMessagesAPI;
import com.example.cupidshuffle.rv.PrivateMessagesAdapter;
import com.example.cupidshuffle.services.PrivateMessageService;
import com.example.cupidshuffle.services.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewPrivateMessagesActivity extends AppCompatActivity {

    private static final String TAG = "PrivateMessagesJSON.TAG";
    private RecyclerView privateMessagesRecyclerView;
    private List<PrivateMessages> privateMessagesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_private_messages);

        privateMessagesRecyclerView = findViewById(R.id.private_messages_recyclerview);

        Retrofit retrofit = RetrofitSingleton.getRetrofitInstance();
        PrivateMessageService privateMessageService = retrofit.create(PrivateMessageService.class);
        privateMessageService.getPrivateMessages().enqueue(new Callback<PrivateMessagesAPI>() {
            @Override
            public void onResponse(Call<PrivateMessagesAPI> call, Response<PrivateMessagesAPI> response) {
                Log.d(TAG, "This retrofit works, Omar! " + response.body().getPrivateMessages());

                privateMessagesList.addAll(response.body().getPrivateMessages());

                PrivateMessagesAdapter privateMessagesAdapter = new PrivateMessagesAdapter(privateMessagesList);
                privateMessagesRecyclerView.setAdapter(privateMessagesAdapter);
                privateMessagesRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


            }

            @Override
            public void onFailure(Call<PrivateMessagesAPI> call, Throwable t) {
                Log.d(TAG, "Retrofit call failed" + t.getMessage());
            }
        });

    }
}

