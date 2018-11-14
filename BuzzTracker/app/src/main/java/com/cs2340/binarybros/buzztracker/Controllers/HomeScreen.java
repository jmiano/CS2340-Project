package com.cs2340.binarybros.buzztracker.Controllers;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import com.cs2340.binarybros.buzztracker.Models.Database;

import java.io.File;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        Button addDonationBtn = findViewById(R.id.addDonation);
        addDonationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, AddDonation.class);
                startActivity(intent);
                //back to home page
            }
        });

        Button viewInventoryBtn = findViewById(R.id.viewInventory);
        viewInventoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, Inventory.class));

            }
        });

        Button viewMapBtn = findViewById(R.id.viewMap);
        viewMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, GoogleMapsActivity.class));

            }
        });


//        Button viewReportsBtn = (Button) findViewById(R.id.viewReports);
//        viewReportsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeScreen.this, ViewReports.class));
//
//            }
//        });

//        Button manageUsersBtn = (Button) findViewById(R.id.manageUsers);
//        manageUsersBtn.setOnClickListener((v) -> {
//            startActivity(new Intent(HomeScreen.this, ManageUsers.class));
//        });

        Button manageLocationsBtn = findViewById(R.id.manageLocations);
        manageLocationsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, LocationManageActivity.class));
            }
        });

        Button saveAllDataBtn = findViewById(R.id.saveDataBtn);
        saveAllDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(HomeScreen.this.getFilesDir(),
                        Database.DEFAULT_BINARY_FILE_NAME);
                Database.getInstance().saveBinary(file);
                Log.d("HomeScreen", "File has been created");

            }
        });
    }
}
