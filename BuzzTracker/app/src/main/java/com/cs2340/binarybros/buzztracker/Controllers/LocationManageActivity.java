package com.cs2340.binarybros.buzztracker.Controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;

public class LocationManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_manage);

        LocationFragment locationlist = new LocationFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, locationlist).commit();

    }

}
