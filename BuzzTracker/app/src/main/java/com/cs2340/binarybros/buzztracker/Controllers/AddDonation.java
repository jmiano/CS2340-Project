package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Donation;

import java.util.ArrayList;
import java.util.List;

public class AddDonation extends AppCompatActivity {
    private EditText TitleField;
    private EditText TimestampField;
    private EditText LocationField;
    private EditText CategoryField;
    private EditText PriceField;
    private EditText ShortdescriptionField;
    private EditText LongdescriptionField;
    private List<Donation> donationList;

    private Donation donation;
    private int donationItemId;
    private boolean editing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);
        /*
          Grab the dialog widgets so we can get info for later
         */
        TitleField = (EditText) findViewById(R.id.donation_title);
        TimestampField = (EditText) findViewById(R.id.timestamp);
        LocationField = (EditText) findViewById(R.id.location);
        CategoryField = (EditText) findViewById(R.id.category);
        PriceField = (EditText) findViewById(R.id.price);
        ShortdescriptionField = (EditText) findViewById(R.id.shortDescription);
        LongdescriptionField = (EditText) findViewById(R.id.longDescription);

        /*
          Get other data
         */
        donationList = Database.getInstance().getDonationList();

        //Check to see if the "editing" boolean was passed to this activity
        if (getIntent().getSerializableExtra("editing") != null) {
            editing = (boolean) getIntent().getSerializableExtra("editing");
        }

        //If editing, then get donationItemId and find correct donation item in Database
        if (editing) {
            donationItemId = (int) getIntent().getSerializableExtra("donationItemId");
            donation = getDonationObjectFromId(donationList, donationItemId);
        }



        /*
          If we are editing a donation, then fill the fields with the passed in donation object
         */
        if (editing) {
            TitleField.setText(donation.getTitle(), TextView.BufferType.EDITABLE);
            TimestampField.setText(donation.getTimestamp(), TextView.BufferType.EDITABLE);
            LocationField.setText(donation.getLocation(), TextView.BufferType.EDITABLE);
            CategoryField.setText(donation.getCategory(), TextView.BufferType.EDITABLE);
            PriceField.setText(donation.getPrice(), TextView.BufferType.EDITABLE);
            ShortdescriptionField.setText(donation.getShortdescription(), TextView.BufferType.EDITABLE);
            LongdescriptionField.setText(donation.getLongdescription(), TextView.BufferType.EDITABLE);
        }

        /*
          Set submit button action. It's action will depend on whether or not we are editing
         */
        Button submitBtn = (Button) findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editing) {
                    createObject();
                } else {
                    editObject();
                }

                Intent intent = new Intent(AddDonation.this, Inventory.class);
                startActivity(intent);
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
        donationList.add(new Donation(title, timestamp, location, category, price, shortdescription,
                longdescription));
    }

    /**
     * This method takes whatever changes were made in the EditText fields and updates the donation
     * object
     */
    private void editObject() {
        donation.setTitle(TitleField.getText().toString());
        donation.setTimestamp(TimestampField.getText().toString());
        donation.setLocation(LocationField.getText().toString());
        donation.setCategory(CategoryField.getText().toString());
        donation.setPrice(PriceField.getText().toString());
        donation.setShortdescription(ShortdescriptionField.getText().toString());
        donation.setLongdescription(LongdescriptionField.getText().toString());
    }

    /**
     * This method is used to find the correct Donation object from our Database
     * @param donationList list of donations from Database
     * @param donationItemId unique id of the Donation we want to find.
     * @return Correct reference to donation object
     */
    private Donation getDonationObjectFromId(List<Donation> donationList, int donationItemId) {
        boolean found = false;
        int count = 0;
        Donation returnDonation = null;

        while (!found && count < donationList.size()) {
            if (donationList.get(count).getId() == donationItemId) {
                found = true;
                returnDonation = donationList.get(count);
            } else {
                count++;
            }
        }
        return returnDonation;
    }
}
