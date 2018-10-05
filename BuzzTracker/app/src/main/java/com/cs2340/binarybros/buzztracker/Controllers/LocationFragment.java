package com.cs2340.binarybros.buzztracker.Controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {


    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        ArrayList<String> locationlist = new ArrayList<>();
        // these three are only for test
        locationlist.add("Location1");
        locationlist.add("Location2");
        locationlist.add("Location3");
        ListView listview = (ListView)view.findViewById(R.id.locationmenu);
        ArrayAdapter<String> listviewadapter = new ArrayAdapter<>(
               getActivity(),
               android.R.layout.simple_list_item_1,
               locationlist
        );
        listview.setAdapter(listviewadapter);
        // Inflate the layout for this fragment
        return view;
    }

}
