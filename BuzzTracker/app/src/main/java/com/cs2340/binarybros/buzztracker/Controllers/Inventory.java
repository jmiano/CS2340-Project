package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Donation;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Inventory extends AppCompatActivity {

    ArrayList<Donation> donationArrayList;
    private Donation donation;
    private int donationItemId;
    private TextView categoryFilterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        ListView inventoryListView = (ListView) findViewById(R.id.inventory_list);

        /**
         * Declaring UI Elements
         */
        categoryFilterBtn = (TextView) findViewById(R.id.category_filter);

        /**
         * Creating Objects for Testing
         */
//        Donation bike = new Donation("white bicycle", "10/10/2019", "this place",
//                "kitchen", "100.00", "this is a cool bike", "this is an even cooler bike");
//        Donation pan = new Donation("black pan", "10/10/2011", "my house", "kitchen", "100.00",
//                "nice pan", "");
//        Database.getInstance().getDonationList().add(bike);
//        Database.getInstance().getDonationList().add(pan);
        //End creating objects

        donationArrayList = Database.getInstance().getDonationList();

        InventoryListAdapter inventoryAdapter = new InventoryListAdapter(this, R.layout.inventory_list_adapterview, donationArrayList);
        inventoryListView.setAdapter(inventoryAdapter);

        /**
         * Button action for choosing filtering categories
         */
        categoryFilterBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Inventory.this);
                View mView = getLayoutInflater().inflate(R.layout.categoy_filter_diaglog_layout, null);
                CheckBox categoryClothing = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_clothing);
                CheckBox categoryHat = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_hat);
                CheckBox categoryKitchen = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_kitchen);
                CheckBox categoryElectronics = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_electronics);
                CheckBox categoryHousehold = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_household);
                CheckBox categoryOther = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_other);
                Button filterBtn = (Button) mView.findViewById(R.id.category_filter_acceptBtn);
                Button cancelBtn = (Button) mView.findViewById(R.id.category_filter_cancelBtn);



                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                return false;
            }
        });





        /**
         * Button action for tapping on an item in the inventory list
         */
        inventoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                donation = (Donation) parent.getAdapter().getItem(position);
                donationItemId = donation.getId();
//                Toast.makeText(Inventory.this, "" + donationItemId, Toast.LENGTH_SHORT).show();
                Intent passDataIntent = new Intent(Inventory.this, AddDonation.class);
                passDataIntent.putExtra("donationItemId", donationItemId);
                passDataIntent.putExtra("editing", true);
                startActivity(passDataIntent);
            }
        });

        /**
         * Button action for the floating button. Adding a Donation.
         */
        FloatingActionButton addDonationBtn = (FloatingActionButton) findViewById(R.id.add_donation_button);
        addDonationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddDonationActivity = new Intent(Inventory.this, AddDonation.class);
                startActivity(goToAddDonationActivity);
            }
        });
    }
}
