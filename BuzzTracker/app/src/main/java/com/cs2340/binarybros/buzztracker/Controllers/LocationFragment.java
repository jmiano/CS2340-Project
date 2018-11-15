package com.cs2340.binarybros.buzztracker.Controllers;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Location;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {
    private ArrayList<Location> locationList;
    private Location location;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        // Pulls the non-persistent ArrayList of locations
        this.locationList = Database.getInstance().getLocationList();
        // these three are only for test
        ListView listView = view.findViewById(R.id.locationmenu);
        ArrayAdapter<Location> listViewAdapter = new ArrayAdapter<>(
                Objects.requireNonNull(getActivity()),
                android.R.layout.simple_list_item_1,
                locationList
        );
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id){
                location = (Location) parent.getAdapter().getItem(position);
                Intent passDataIntent = new Intent(LocationFragment.this.getActivity(),
                        EditLocation.class);
                passDataIntent.putExtra("location", location);
                startActivity(passDataIntent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}