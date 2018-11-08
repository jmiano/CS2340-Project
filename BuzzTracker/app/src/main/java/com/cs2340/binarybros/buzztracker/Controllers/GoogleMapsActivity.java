package com.cs2340.binarybros.buzztracker.Controllers;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //get location data
        List<Location> locList = Database.getInstance().getLocationList();
        mMap = googleMap;

        LatLng latLng; //declares arbitrary latLng for looping
        try {
            latLng = Location.mapLocation(locList.get(0), mMap); //map first location

            for (int i = 1; i < locList.size(); i++) { //map subsequent locations
                latLng = Location.mapLocation(locList.get(i), mMap);
            }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 9.0f)); //moves camera to last added loc
        Log.d("MAPS CHECK", "map should be visible and created");
        } catch (NullPointerException e) {
            Toast.makeText(GoogleMapsActivity.this,
                    "No locations to display, please load locations",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(GoogleMapsActivity.this,
                    "Unknown error, please reload locations and/or reload app",
                    Toast.LENGTH_LONG).show();
        }
    }
}
