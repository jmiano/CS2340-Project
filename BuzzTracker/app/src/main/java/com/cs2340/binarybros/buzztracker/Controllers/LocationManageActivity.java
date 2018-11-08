package com.cs2340.binarybros.buzztracker.Controllers;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Location;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LocationManageActivity extends AppCompatActivity {
    private List<Location> locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_manage);

        /* Grab the location list from facade to be populated */
        this.locationList = Database.getInstance().getLocationList(); // Pulls the non-persistent ArrayList of locations

        LocationFragment locationFragment = new LocationFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, locationFragment).commit();

        FloatingActionButton addBtn = (FloatingActionButton) findViewById(R.id.add_btn);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.locationdata);
                CSVFile csvFile = new CSVFile(inputStream);
                Collection<Location> fileContents = (ArrayList) csvFile.read();
                locationList.addAll(fileContents);
                LocationFragment locationFragment = new LocationFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.container, locationFragment).commit();
            }
        });

    }

}
