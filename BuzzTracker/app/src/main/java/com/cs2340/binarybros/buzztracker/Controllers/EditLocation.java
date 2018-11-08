package com.cs2340.binarybros.buzztracker.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Location;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class EditLocation extends AppCompatActivity {
    private String stateList[] = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL",
            "GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS",
            "MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD",
            "TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
    private String types[] = {"Drop Off", "Store", "Warehouse"};

    /**
     * widgets we will need for binding and getting information
     */
    private EditText nameField;
    private Spinner type;
    private EditText streetAddress;
    private EditText city;
    private Spinner state;
    private EditText zipCode;
    private EditText latitude;
    private EditText longitude;

    /**
     * User object if location is being edited
     */
    private Location location;

    /**
     * flag for whether this is a new location or if we are editing a location
     */
    private boolean editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_location);

        location = (Location) getIntent().getSerializableExtra("location");

        nameField = (EditText) findViewById(R.id.location_name_field);
        type = (Spinner) findViewById(R.id.location_type_spinner);
        streetAddress = (EditText) findViewById(R.id.location_street_field);
        city = (EditText) findViewById(R.id.location_city_field);
        state = (Spinner) findViewById(R.id.location_state_spinner);
        zipCode = (EditText) findViewById(R.id.location_zipcode_field);
        latitude = (EditText) findViewById(R.id.location_latitude_field);
        longitude = (EditText) findViewById(R.id.location_longitude_field);

        /*
          Set up adapter to display the allowable types in spinner
         */
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, R.layout.spinner_item,
                types);
        typeAdapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item));
        type.setAdapter(typeAdapter);

        /*
          Set up the adapter to display the allowable states
         */
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(this, R.layout.spinner_item,
                stateList);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(stateAdapter);

        /*
          Select state spinner location
         */
        int stateLocation = 0;
        for (int i = 0; i < stateList.length; i++) {
            if (location.getState().equals(stateList[i])) {
                stateLocation = i;
            }
        }
        state.setSelection(stateLocation);

        /*
          Select type spinner location
         */
        int typeNumber = 0;
        for (int i = 0; i < types.length; i++) {
            if (location.getType().equals(types[i])) {
                typeNumber = i;
            }
        }
        type.setSelection(typeNumber);

        /*
          fill the rest of the form information
         */
        nameField.setText(location.getName(), TextView.BufferType.EDITABLE);
        streetAddress.setText(location.getStreetAddress(), TextView.BufferType.EDITABLE);
        city.setText(location.getCity(), TextView.BufferType.EDITABLE);
        zipCode.setText(location.getZip(), TextView.BufferType.EDITABLE);
        latitude.setText(location.getLatitude(), TextView.BufferType.EDITABLE);
        longitude.setText(location.getLongitude(), TextView.BufferType.EDITABLE);


    }
}
