package com.cs2340.binarybros.buzztracker.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Donation;

import java.util.ArrayList;

public class Inventory extends AppCompatActivity {

    ArrayList<Donation> donationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        ListView inventoryListView = (ListView) findViewById(R.id.inventory_list);

        //create donation objects
        Donation bike = new Donation("white bicycle", "10/10/2019", "this place",
                "kitchen", "100.00", "this is a cool bike", "this is an even cooler bike");
        Donation pan = new Donation("black pan", "10/10/2011", "my house", "kitchen", "100.00",
                "nice pan", "");
        Database.getInstance().getDonationList().add(bike);
        Database.getInstance().getDonationList().add(pan);
        //End creating objects

        donationArrayList = Database.getInstance().getDonationList();

        InventoryListAdapter inventoryAdapter = new InventoryListAdapter(this, R.layout.inventory_list_adapterview, donationArrayList);
        inventoryListView.setAdapter(inventoryAdapter);
    }
}
