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

    }
}
