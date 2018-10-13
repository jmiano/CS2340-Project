package com.cs2340.binarybros.buzztracker.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.cs2340.binarybros.buzztracker.Models.Location;


public class EditLocation extends AppCompatActivity {\

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

    }
}
