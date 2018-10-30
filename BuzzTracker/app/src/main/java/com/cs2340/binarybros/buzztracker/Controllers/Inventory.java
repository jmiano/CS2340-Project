package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Donation;
import com.cs2340.binarybros.buzztracker.Models.Location;
import com.cs2340.binarybros.buzztracker.Models.User;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Inventory extends AppCompatActivity {

    ArrayList<Donation> donationArrayList;
    ArrayList<String> categoryFilterList;
    ArrayList<Donation> finalDonationArrayList;
    private Donation donation;
    private int donationItemId;
    private Button categoryFilterBtn;
    private Button applyFilterBtn;
    private Button clearFiltersBtn;
    private Spinner locationSpinner;
    private EditText searchFilter;
    private ArrayList<Location> locationArrayList;
    private String[] locationListTitles;
    private User currentUser;
    private InventoryListAdapter inventoryAdapter;
    private ListView inventoryListView;



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
        locationSpinner = (Spinner) findViewById(R.id.select_location_spinner);
        searchFilter = (EditText) findViewById(R.id.searchFilter);


        /**
         * Setting up other variables
         */
        donationArrayList = Database.getInstance().getDonationList();
        currentUser = Database.getInstance().getCurrentUser();
        locationArrayList = Database.getInstance().getLocationList();

        /**
         * Set up Array with Location Titles
         */
        if (locationArrayList != null) {
            locationListTitles = new String[locationArrayList.size() + 1];
            int size = 0;
            for (int i = 0; i < locationArrayList.size(); i++) {
                locationListTitles[i] = locationArrayList.get(i).getName();
                size++;
            }
            locationListTitles[size] = "ALL LOCATIONS";
        } else {
            locationListTitles = new String[10];
            locationListTitles[0] = "ALL LOCATIONS";
        }


        /**
         * Set up ArrayAdapter for location Spinner
         */
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, locationListTitles);
        locationAdapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item));
        //If current User is a location employee, then don't allow them to change the Spinner
        if (currentUser.getType().equals("Location Employee")) {
            locationSpinner.setEnabled(false);
        }
        locationSpinner.setAdapter(locationAdapter);

        /**
         * Set location spinner default
         */
        int locationNumber = 0;
        for (int i = 0; i < locationListTitles.length; i++) {
            if (currentUser.getEmployeeLocation().equals(locationListTitles[i])) {
                locationNumber = i;
            }
        }
        locationSpinner.setSelection(locationNumber);


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
                        categoryFilterList = new ArrayList<>();

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
        inventoryListView = (ListView) findViewById(R.id.inventory_list);
        inventoryListView.setTextFilterEnabled(true);
        finalDonationArrayList = filterDonationListByLocation(donationArrayList);
        inventoryAdapter = new InventoryListAdapter(this, R.layout.inventory_list_adapterview, finalDonationArrayList);
        inventoryListView.setAdapter(inventoryAdapter);
        

        /**
         * Button action for applying filters the listview
         */
        applyFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalDonationArrayList = filterDonationListByCategory(donationArrayList, categoryFilterList);
                finalDonationArrayList = filterDonationListByLocation(finalDonationArrayList);
                finalDonationArrayList = filterDonationListBySearch(finalDonationArrayList);
                inventoryAdapter = new InventoryListAdapter(Inventory.this, R.layout.inventory_list_adapterview, finalDonationArrayList);
                inventoryListView.setAdapter(inventoryAdapter);
            }
        });

        /**
         * Button action for clearing all filters
         */
        clearFiltersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryFilterList = new ArrayList<>();
                finalDonationArrayList = filterDonationListByLocation(donationArrayList);
                inventoryAdapter = new InventoryListAdapter(Inventory.this, R.layout.inventory_list_adapterview, finalDonationArrayList);
                inventoryListView.setAdapter(inventoryAdapter);
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

        /**
         * Attempt at changing listview when a new location is selected
         */
        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                finalDonationArrayList = filterDonationListByLocation(donationArrayList);

                if (categoryFilterList != null && categoryFilterList.size() > 0) {
                    finalDonationArrayList = filterDonationListByCategory(finalDonationArrayList, categoryFilterList);
                }

                InventoryListAdapter newInventoryAdapter = new InventoryListAdapter(Inventory.this, R.layout.inventory_list_adapterview, finalDonationArrayList);
                inventoryListView.setAdapter(newInventoryAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    /**
     * This is a filtering method that filters by category
     * @param donationList blah
     * @param categoriesSelected blah
     * @return blah
     */
    private ArrayList<Donation> filterDonationListByCategory(ArrayList<Donation> donationList, ArrayList<String> categoriesSelected) {
        if (categoriesSelected == null || categoriesSelected.size() <= 0) {
            return donationList;
        } else if (donationList != null) {
            ArrayList<Donation> returnDonationList = new ArrayList<>();
            for (Donation donation: donationList) {
                if (categoriesSelected.contains(donation.getCategory())) {
                    returnDonationList.add(donation);
                }
            }
            return returnDonationList;
        } else {
            return donationList;
        }

    }

    /**
     * This is a filtering method that filters by location
     * @param donationList blah
     * @return blah
     */
    private ArrayList<Donation> filterDonationListByLocation(ArrayList<Donation> donationList) {
        if (locationSpinner.getSelectedItem().toString().equals("ALL LOCATIONS")) {
            return donationList;
        } else if (donationList != null && locationSpinner.getSelectedItem() != null && donationList.size() > 0){
            ArrayList<Donation> returnDonationList = new ArrayList<>();
            for (Donation donation: donationList) {
                if (locationSpinner.getSelectedItem().toString().equals(donation.getLocation())) {
                    returnDonationList.add(donation);
                }

            }
            return returnDonationList;
        } else {
            return donationList;
        }
    }

    /**
     * This is a filtering method that filters by search
     * @param donationList list to be filtered
     * @return filtered donation list
     */
    private ArrayList<Donation> filterDonationListBySearch(ArrayList<Donation> donationList) {
        String filterText = searchFilter.getText().toString();
        for (int i = 0; i < donationList.size(); i++) {
            if (!(donationList.get(i).getTitle().toUpperCase().contains(filterText.toUpperCase()))) {
                donationList.remove(i);
            }
        }
        return donationList;
    }

}
