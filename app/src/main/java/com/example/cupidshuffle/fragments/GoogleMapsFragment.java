package com.example.cupidshuffle.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupidshuffle.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsFragment extends Fragment implements OnMapReadyCallback {

    private static final String LOCATION_LAT = "lat";
    private static final String LOCATION_LON = "lon";
    private static final String VENUE_NAME = "venuename";
    private String TAG_FOR_MAP_ICON = "";


    private GoogleMap cupidShuffleMap;
    private MapView cupidShuffleMapView;
    private View googleMapView;

    private ProgressDialog dialog;

    private String latitude;
    private String longitude;
    private String venue;

    private double lat;
    private double lon;


    public GoogleMapsFragment() {
        // Required empty public constructor
    }

    public static GoogleMapsFragment getInstance(String locationLongitude, String locationLatitude, String venueName) {
        GoogleMapsFragment googleMapFragment = new GoogleMapsFragment();

        Bundle args = new Bundle();
        args.putString(LOCATION_LON, locationLongitude);
        args.putString(LOCATION_LAT, locationLatitude);
        args.putString(VENUE_NAME, venueName);
        googleMapFragment.setArguments(args);
        return googleMapFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return googleMapView = inflater.inflate(R.layout.fragment_google_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cupidShuffleMapView = googleMapView.findViewById(R.id.googlemaps);

        if (cupidShuffleMapView != null) {
            cupidShuffleMapView.onCreate(null);
            cupidShuffleMapView.onResume();
            cupidShuffleMapView.getMapAsync(this);

            if (getArguments() != null) {
                longitude = getArguments().getString(LOCATION_LON);
                latitude = getArguments().getString(LOCATION_LAT);
                venue = getArguments().getString(VENUE_NAME);

                TAG_FOR_MAP_ICON = venue;

                lat = Double.parseDouble(latitude);
                lon = Double.parseDouble(longitude);

                setDialog();
            }
        }
    }

    public void setDialog() {
        dialog = new ProgressDialog(getContext(), R.style.DialogCustom);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


//
//    private static final LatLngBounds NEW_YORK_BOUNDS = new LatLngBounds(new LatLng(40.4772, 45.0153),
//            new LatLng(-79.7624, -71.7517));


    @Override
    public void onMapReady(GoogleMap googleMap) {

        cupidShuffleMap = googleMap;

     //   cupidShuffleMap.setLatLngBoundsForCameraTarget(NEW_YORK_BOUNDS);

        LatLng latLng = new LatLng(lat, lon);
        cupidShuffleMap.addMarker(new MarkerOptions().position(latLng).title(TAG_FOR_MAP_ICON).icon(BitmapDescriptorFactory.fromResource(R.mipmap.cupidmapmarker)));

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 16);
        cupidShuffleMap.animateCamera(cameraUpdate);
        UiSettings uiSettings = cupidShuffleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);

        Handler progressDialogHandler = new Handler();
        progressDialogHandler.postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
            }
        }, 2000);


    }
}
