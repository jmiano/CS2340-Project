package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Donation;

import java.util.ArrayList;

public class AddDonation extends AppCompatActivity {
    private EditText TitleField;
    private EditText TimestampField;
    private EditText LocationField;
    private EditText CategoryField;
    private EditText PriceField;
    private EditText ShortdescriptionField;
    private EditText LongdescriptionField;
    private ArrayList<Donation> listdonation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);
        /**
         * Grab the dialog widgets so we can get info for later
         */
        TitleField = (EditText) findViewById(R.id.donation_title);
        TimestampField = (EditText) findViewById(R.id.timestamp);
        LocationField = (EditText) findViewById(R.id.location);
        CategoryField = (EditText) findViewById(R.id.category);
        PriceField = (EditText) findViewById(R.id.price);
        ShortdescriptionField = (EditText) findViewById(R.id.shortDescription);
        LongdescriptionField = (EditText) findViewById(R.id.longDescription);
        listdonation = Database.getInstance().getDonationList();
        Button submitBtn = (Button) findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createObject();
                //back to home page
            }
        });
    }
    /**
     * This method creates a donation object and puts it into database
     *
     */
    private void createObject() {
        String title = TitleField.getText().toString();
        String timestamp = TimestampField.getText().toString();
        String location = LocationField.getText().toString();
        String category = CategoryField.getText().toString();
        String price = PriceField.getText().toString();
        String shortdescription = ShortdescriptionField.getText().toString();
        String longdescription = LongdescriptionField.getText().toString();
        listdonation.add(new Donation(title, timestamp, location, category, price, shortdescription,
                longdescription));
    }
}
