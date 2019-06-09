package com.example.cupidshuffle.activities;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.FragmentNavigation;
import com.example.cupidshuffle.fragments.GoogleMapsFragment;
import com.example.cupidshuffle.fragments.UserProfileFragment;
import com.example.cupidshuffle.fragments.AllUserProfilesFragment;
import com.example.cupidshuffle.fragments.UserViewPagerFragment;
import com.example.cupidshuffle.fragments.ViewAllConnectionRequestsFragment;
import com.example.cupidshuffle.fragments.ViewAllPrivateMessagesFragment;

public class FragmentHolderActivity extends AppCompatActivity implements FragmentNavigation {
    private BottomNavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_after_login);

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.getMenu().getItem(2).setChecked(true);


        startBeginningFragment();

    }

    private void startBeginningFragment() {
        UserViewPagerFragment userViewPagerFragment = UserViewPagerFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment_container, userViewPagerFragment);
        fragmentTransaction.commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        Fragment clickedNavTabFragment;

        int mMenuId = item.getItemId();


        switch (mMenuId) {
            case R.id.navigation_home:
                clickedNavTabFragment = new UserProfileFragment();
                inflateFragment(clickedNavTabFragment);
                break;

            case R.id.navigation_discover:

                clickedNavTabFragment = new AllUserProfilesFragment();
                inflateFragment(clickedNavTabFragment);
                break;

            case R.id.navigation_notifications:

                clickedNavTabFragment = new ViewAllPrivateMessagesFragment();
                inflateFragment(clickedNavTabFragment);
                break;

            case R.id.navigation_shuffle:

                clickedNavTabFragment = new UserViewPagerFragment();
                inflateFragment(clickedNavTabFragment);
                break;

            case R.id.navigation_connection_requests:
                clickedNavTabFragment = new ViewAllConnectionRequestsFragment();
                inflateFragment(clickedNavTabFragment);
                break;
        }

        return true;
    };

    private void inflateFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void goToLocationOnMap(String lon, String lat, String name) {
        GoogleMapsFragment googleMapsFragment = GoogleMapsFragment.getInstance(lon, lat, name);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, googleMapsFragment)
                .addToBackStack(null)
                .commit();
    }
}
