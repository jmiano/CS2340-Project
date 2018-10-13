package com.cs2340.binarybros.buzztracker.Controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Location;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {
    private ArrayList<Location> locationList;


    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        this.locationList = Database.getInstance().getLocationList(); // Pulls the non-persistent ArrayList of locations
        // these three are only for test
        ListView listview = (ListView)view.findViewById(R.id.locationmenu);
        ArrayAdapter<Location> listviewadapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                locationList
        );
        listview.setAdapter(listviewadapter);
        // Inflate the layout for this fragment
        return view;
    }

}