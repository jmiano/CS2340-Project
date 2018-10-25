package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.DialogInterface;
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
    ArrayList<String> categoryFilterList;
    ArrayList<Donation> finalDonationArrayList;
    private String currentLocation;
    private Donation donation;
    private int donationItemId;
    private Button categoryFilterBtn;
    private Button applyFilterBtn;
    private Button clearFiltersBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);


        /**
         * Declaring UI Elements
         */
        categoryFilterBtn = (Button) findViewById(R.id.categoriesbtn);
        applyFilterBtn = (Button) findViewById(R.id.applyfilterbtn);
        clearFiltersBtn = (Button) findViewById(R.id.clearfiltersbtn);

        /**
         * Creating Objects for Testing
         */
        Donation bike = new Donation("white bicycle", "", "",
                "Kitchen", "", "", "");
        Donation pan = new Donation("red pan", "", "", "Kitchen", "",
                "", "");
        Donation peanut = new Donation("brown peanut", "", "",
                "Kitchen", "", "", "");
        Donation person = new Donation("Fan", "", "", "Other", "",
                "", "");
        Database.getInstance().getDonationList().add(bike);
        Database.getInstance().getDonationList().add(pan);
        Database.getInstance().getDonationList().add(peanut);
        Database.getInstance().getDonationList().add(person);
        //End creating objects

        donationArrayList = Database.getInstance().getDonationList();



        /**
         * Button action for choosing filtering categories
         */
        categoryFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Inventory.this);
                View mView = getLayoutInflater().inflate(R.layout.categoy_filter_diaglog_layout, null);

                final CheckBox categoryClothing = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_clothing);
                final CheckBox categoryHat = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_hat);
                final CheckBox categoryKitchen = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_kitchen);
                final CheckBox categoryElectronics = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_electronics);
                final CheckBox categoryHousehold = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_household);
                final CheckBox categoryOther = (CheckBox) mView.findViewById(R.id.category_filter_checkbox_other);
                Button filterBtn = (Button) mView.findViewById(R.id.category_filter_acceptBtn);
                Button dismissBtn = (Button) mView.findViewById(R.id.category_filter_cancelBtn);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                filterBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        categoryFilterList = new ArrayList<String>();

                        if (categoryClothing.isChecked()) {
                            categoryFilterList.add("Clothing");
                        }

                        if (categoryHat.isChecked()) {
                            categoryFilterList.add("Hat");
                        }

                        if (categoryKitchen.isChecked()) {
                            categoryFilterList.add("Kitchen");
                        }

                        if (categoryElectronics.isChecked()) {
                            categoryFilterList.add("Electronics");
                        }

                        if (categoryHousehold.isChecked()) {
                            categoryFilterList.add("Household");
                        }

                        if (categoryOther.isChecked()) {
                            categoryFilterList.add("Other");
                        }

                        finalDonationArrayList = filterDonationList(donationArrayList, categoryFilterList);

                        dialog.dismiss();
                    }
                });

                dismissBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }});

        /**
         * Set the initial listview
         */
        final ListView inventoryListView = (ListView) findViewById(R.id.inventory_list);
        final InventoryListAdapter inventoryAdapter = new InventoryListAdapter(this, R.layout.inventory_list_adapterview, donationArrayList);
        inventoryListView.setAdapter(inventoryAdapter);

        /**
         * Button action for the refreshing the listview
         */
        applyFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalDonationArrayList = filterDonationList(donationArrayList, categoryFilterList);
                InventoryListAdapter newInventoryAdapter = new InventoryListAdapter(Inventory.this, R.layout.inventory_list_adapterview, finalDonationArrayList);
                inventoryListView.setAdapter(newInventoryAdapter);
            }
        });

        /**
         * Button action for clearing all filters
         */
        clearFiltersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InventoryListAdapter newInventoryAdapter = new InventoryListAdapter(Inventory.this, R.layout.inventory_list_adapterview, donationArrayList);
                inventoryListView.setAdapter(newInventoryAdapter);
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

    /**
     * This is a filtering method that filters by location & category
     * @param donationList blah
     * @param categoriesSelected blah
     * @return blah
     */
    private ArrayList<Donation> filterDonationList(ArrayList<Donation> donationList, ArrayList<String> categoriesSelected) {
        if (categoriesSelected == null || categoriesSelected.size() == 0) {
            return donationList;
        } else {
            ArrayList<Donation> returnDonationList = new ArrayList<>();
            for (Donation donation: donationList) {
                if (categoriesSelected.contains(donation.getCategory())) {
                    returnDonationList.add(donation);
                }
            }
            return returnDonationList;
        }

    }

}
