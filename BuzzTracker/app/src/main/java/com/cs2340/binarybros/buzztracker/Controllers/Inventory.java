package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Donation;
import com.cs2340.binarybros.buzztracker.Models.Location;
import com.cs2340.binarybros.buzztracker.Models.User;


import java.util.ArrayList;
import java.util.List;

public class Inventory extends AppCompatActivity {

    private List<Donation> donationArrayList;
    private List<String> categoryFilterList;
    private List<Donation> finalDonationArrayList;
    private Donation donation;
    private int donationItemId;
    private Button categoryFilterBtn;
    private Button applyFilterBtn;
    private Button clearFiltersBtn;
    private Spinner locationSpinner;
    private EditText searchFilter;
    private List<Location> locationArrayList;
    private String[] locationListTitles;
    private User currentUser;
    private InventoryListAdapter inventoryAdapter;
    private ListView inventoryListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);


        /*
          Declaring UI Elements
         */
        categoryFilterBtn = findViewById(R.id.categoriesbtn);
        applyFilterBtn = findViewById(R.id.applyfilterbtn);
        clearFiltersBtn = findViewById(R.id.clearfiltersbtn);
        locationSpinner = findViewById(R.id.select_location_spinner);
        searchFilter = findViewById(R.id.searchFilter);


        /*
          Setting up other variables
         */
        donationArrayList = Database.getInstance().getDonationList();
        currentUser = Database.getInstance().getCurrentUser();
        locationArrayList = Database.getInstance().getLocationList();

        /*
          Set up Array with Location Titles
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


        /*
          Set up ArrayAdapter for location Spinner
         */
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this,
                R.layout.spinner_item, locationListTitles);
        locationAdapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item));
        //If current User is a location employee, then don't allow them to change the Spinner
        if ("Location Employee".equals(currentUser.getType())) {
            locationSpinner.setEnabled(false);
        }
        locationSpinner.setAdapter(locationAdapter);

        /*
          Set location spinner default
         */
        int locationNumber = 0;
        for (int i = 0; i < locationListTitles.length; i++) {
            if (currentUser.getEmployeeLocation().equals(locationListTitles[i])) {
                locationNumber = i;
            }
        }
        locationSpinner.setSelection(locationNumber);


        /*
          Button action for choosing filtering categories
         */
        categoryFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Inventory.this);
                View mView = getLayoutInflater().inflate(R.layout.categoy_filter_dialog_layout,
                        null);

                final CheckBox categoryClothing = mView.findViewById(
                        R.id.category_filter_checkbox_clothing);
                final CheckBox categoryHat = mView.findViewById(
                        R.id.category_filter_checkbox_hat);
                final CheckBox categoryKitchen = mView.findViewById(
                        R.id.category_filter_checkbox_kitchen);
                final CheckBox categoryElectronics = mView.findViewById(
                        R.id.category_filter_checkbox_electronics);
                final CheckBox categoryHousehold = mView.findViewById(
                        R.id.category_filter_checkbox_household);
                final CheckBox categoryOther = mView.findViewById(
                        R.id.category_filter_checkbox_other);
                Button filterBtn = mView.findViewById(R.id.category_filter_acceptBtn);
                Button dismissBtn = mView.findViewById(R.id.category_filter_cancelBtn);

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

        /*
          Set the initial listView
         */
        inventoryListView = findViewById(R.id.inventory_list);
        finalDonationArrayList = filterDonationListByLocation(donationArrayList);
        inventoryAdapter = new InventoryListAdapter(this,
                R.layout.inventory_list_adapterview, finalDonationArrayList);
        inventoryListView.setAdapter(inventoryAdapter);


        /*
          Button action for applying filters the listView
         */
        applyFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalDonationArrayList = filterDonationListByCategory(donationArrayList,
                        categoryFilterList);
                finalDonationArrayList = filterDonationListByLocation(finalDonationArrayList);
                finalDonationArrayList = filterDonationListBySearch(finalDonationArrayList);
                inventoryAdapter = new InventoryListAdapter(Inventory.this,
                        R.layout.inventory_list_adapterview, finalDonationArrayList);
                inventoryListView.setAdapter(inventoryAdapter);
                if (finalDonationArrayList.isEmpty()) {
                    Toast.makeText(Inventory.this, "No donations to display. " +
                            "Please clear filters and try again.", Toast.LENGTH_LONG).show();
                }
            }
        });

        /*
          Button action for clearing all filters
         */
        clearFiltersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryFilterList = new ArrayList<>();
                finalDonationArrayList = filterDonationListByLocation(donationArrayList);
                searchFilter.setText("");
                inventoryAdapter = new InventoryListAdapter(Inventory.this,
                        R.layout.inventory_list_adapterview, finalDonationArrayList);
                inventoryListView.setAdapter(inventoryAdapter);
            }
        });


        /*
          Button action for tapping on an item in the inventory list
         */
        inventoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                donation = (Donation) parent.getAdapter().getItem(position);
                donationItemId = donation.getId();
                Intent passDataIntent = new Intent(Inventory.this,
                        AddDonation.class);
                passDataIntent.putExtra("donationItemId", donationItemId);
                passDataIntent.putExtra("editing", true);
                startActivity(passDataIntent);
            }
        });

        /*
          Button action for the floating button. Adding a Donation.
         */
        FloatingActionButton addDonationBtn = findViewById(R.id.add_donation_button);
        addDonationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**These are used to troubleshooting
                donationArrayList.add(new Donation("red bicycle", "today",
                        "AFD Station 4", "Household", "5.00",
                        "short", "long"));
                donationArrayList.add(new Donation("white bicycle", "today",
                        "AFD Station 4", "Household", "5.00",
                        "short", "long"));
                donationArrayList.add(new Donation("blue bicycle", "today",
                        "AFD Station 4", "Kitchen", "5.00",
                        "short", "long"));
                donationArrayList.add(new Donation("yellow bicycle", "today",
                        "AFD Station 4", "Kitchen", "5.00",
                        "short", "long"));
                donationArrayList.add(new Donation("orange bicycle", "today",
                        "AFD Station 4", "Hat", "5.00",
                        "short", "long"));
                 */

                Intent goToAddDonationActivity = new Intent(Inventory.this,
                        AddDonation.class);
                startActivity(goToAddDonationActivity);

            }
        });

        /*
          Attempt at changing listView when a new location is selected
         */
        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                finalDonationArrayList = filterDonationListByLocation(donationArrayList);

                if ((categoryFilterList != null) && !categoryFilterList.isEmpty()) {
                    finalDonationArrayList = filterDonationListByCategory(finalDonationArrayList,
                            categoryFilterList);
                }

                InventoryListAdapter newInventoryAdapter = new InventoryListAdapter(
                        Inventory.this, R.layout.inventory_list_adapterview,
                        finalDonationArrayList);
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
    private List<Donation> filterDonationListByCategory(List<Donation> donationList,
                                                             List<String> categoriesSelected) {
        if ((categoriesSelected == null) || (categoriesSelected.size() <= 0)) {
            return donationList;
        } else if (donationList != null) {
            List<Donation> returnDonationList = new ArrayList<>();
            for (Donation donation: donationList) {
                if (categoriesSelected.contains(donation.getCategory())) {
                    returnDonationList.add(donation);
                }
            }
            return returnDonationList;
        } else {
            return null;
        }

    }

    /**
     * This is a filtering method that filters by location
     * @param donationList blah
     * @return blah
     */
    private List<Donation> filterDonationListByLocation(List<Donation> donationList) {
        if ("ALL LOCATIONS".equals(locationSpinner.getSelectedItem().toString())) {
            return donationList;
        } else if ((donationList != null) && (locationSpinner.getSelectedItem() != null) &&
                !donationList.isEmpty()){
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
    private List<Donation> filterDonationListBySearch(List<Donation> donationList) {
        String filterText = searchFilter.getText().toString();
        if (filterText.isEmpty()) {
            return donationList;
        } else {
            ArrayList<Donation> returnDonationList = new ArrayList<>();
            for (int i = 0; i < donationList.size(); i++) {
                if ((donationList.get(i).getTitle().toUpperCase().contains(
                        filterText.toUpperCase()))) {
                    returnDonationList.add(donationList.get(i));
                }
            }
            return returnDonationList;
        }

    }
}
