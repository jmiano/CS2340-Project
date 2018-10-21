package com.cs2340.binarybros.buzztracker.Controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.cs2340.binarybros.buzztracker.Models.Admin;
import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.LocationEmployee;
import com.cs2340.binarybros.buzztracker.Models.Manager;
import com.cs2340.binarybros.buzztracker.Models.User;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        Button addDonationBtn = (Button) findViewById(R.id.addDonation);
        addDonationBtn.setOnClickListener((v) -> {
            startActivity(new Intent(HomeScreen.this, ));
        });

        Button viewInventoryBtn = (Button) findViewById(R.id.viewInentory);
        viewInventoryBtn.setOnClickListener((v) -> {
            startActivity(new Intent(HomeScreen.this));
        });

        Button viewReportsBtn = (Button) findViewById(R.id.viewReports);
        viewReportsBtn.setOnClickListener((v) -> {
            startActivity(new Intent(HomeScreen.this));
        });

        Button manageUsersBtn = (Button) findViewById(R.id.manageUsers);
        manageUsersBtn.setOnClickListener((v) -> {
            startActivity(new Intent(HomeScreen.this));
        });

        Button manageLocationsBtn = (Button) findViewById(R.id.manageLocations);
        manageLocationsBtn.setOnClickListener((v) -> {
            startActivity(new Intent(HomeScreen.this));
        });
    }
}
