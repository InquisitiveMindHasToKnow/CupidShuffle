package com.example.cupidshuffle.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.rv.PrivateMessageAndRequestVPAdapter;
import com.example.cupidshuffle.vpfragments.ViewAllConnectionRequestsFragment;
import com.example.cupidshuffle.vpfragments.ViewAllPrivateMessagesFragment;

public class ViewPrivateMessagesAndConnectionRequest extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_private_messages_and_connection_request);

        viewPager = findViewById(R.id.view_private_messages_and_connection_request_viewPager);
        setUpViewPager(viewPager);


        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getSelectedTabPosition();
    }

    private void setUpViewPager(ViewPager viewPager) {

        PrivateMessageAndRequestVPAdapter privateMessageAndRequestVPAdapter = new PrivateMessageAndRequestVPAdapter(getSupportFragmentManager());
        privateMessageAndRequestVPAdapter.addFragments(new ViewAllConnectionRequestsFragment(), "Connection Requests \n   12");
        privateMessageAndRequestVPAdapter.addFragments(new ViewAllPrivateMessagesFragment(), "Private Messages \n   9");
        viewPager.setAdapter(privateMessageAndRequestVPAdapter);

    }
}


