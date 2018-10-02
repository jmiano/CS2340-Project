package com.cs2340.binarybros.buzztracker;

import android.content.Intent;
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

import com.cs2340.binarybros.buzztracker.R;

import java.util.ArrayList;
import java.util.Arrays;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameField;
    private EditText emailField;
    private EditText addressField;
    private EditText userNameField;
    private EditText passwordField;
    private Spinner monthSpinner;
    private Spinner daySpinner;
    private Spinner yearSpinner;
    private Spinner accountTypeSpinner;
    //the 4 arraylist to store different type
    private ArrayList<User> userlist;
    private ArrayList<Manager> managerlist;
    private ArrayList<Admin> adminlist;
    private ArrayList<LocationEmployee> locationemployeelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /**
         * Grab the dialog widgets so we can get info for later
         */
        nameField = (EditText) findViewById(R.id.name_field);
        emailField = (EditText) findViewById(R.id.email_field);
        addressField = (EditText) findViewById(R.id.address_field);
        userNameField = (EditText) findViewById(R.id.username_field);
        passwordField = (EditText) findViewById(R.id.password_field);
        monthSpinner = (Spinner) findViewById(R.id.month_spinner);
        daySpinner = (Spinner) findViewById(R.id.day_spinner);
        yearSpinner = (Spinner) findViewById(R.id.year_spinner);
        accountTypeSpinner = (Spinner) findViewById(R.id.account_spinner);


        /*
          Set up the adapter to display the allowable account types
         */
        ArrayAdapter<String> accountTypeAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,
                Arrays.asList("User", "Manager", "Location Employee", "Admin"));
        accountTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountTypeSpinner.setAdapter(accountTypeAdapter);


        /*
          Set up the adapter to display the allowable days
         */
        ArrayAdapter<Integer> dayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,
                Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31));
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

        /*
          Set up the adapter for allowable months
         */
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,
                Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        /*
          Set up the adapter for allowable years
         */
        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,
                Arrays.asList(2018,	2017,	2016,	2015,	2014,	2013,	2012,	2011,
                        2010,	2009,	2008,	2007,	2006,	2005,	2004,	2003,
                        2002,	2001,	2000,	1999,	1998,	1997,	1996,	1995,
                        1994,	1993,	1992,	1991,	1990,	1989,	1988,	1987,
                        1986,	1985,	1984,	1983,	1982,	1981,	1980,	1979,
                        1978,	1977,	1976,	1975,	1974,	1973,	1972,	1971,
                        1970,	1969,	1968,	1967,	1966,	1965,	1964,	1963,
                        1962,	1961,	1960,	1959,	1958,	1957,	1956,	1955,
                        1954,	1953,	1952,	1951,	1950,	1949,	1948,	1947,
                        1946,	1945,	1944,	1943,	1942,	1941,	1940,	1939,
                        1938,	1937,	1936,	1935,	1934,	1933,	1932,	1931,
                        1930,	1929,	1928,	1927,	1926,	1925,	1924,	1923,
                        1922,	1921,	1920,	1919,	1918,	1917,	1916,	1915,
                        1914,	1913,	1912,	1911,	1910,	1909,	1908,	1907,
                        1906,	1905,	1904,	1903,	1902,	1901,	1900,	1899));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        Button cancelBtn = (Button) findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, WelcomeActivity.class));
            }
        });
        //create the register Button
        Button registerBtn = (Button) findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createobject();
                Intent intent = new Intent(RegisterActivity.this, PrettyLogin.class);
                //pass all intent to the PrettyLogin activity
                intent.putExtra("user", userlist);
                intent.putExtra("manager", managerlist);
                intent.putExtra("locationemployee", locationemployeelist);
                intent.putExtra("admin", adminlist);
                startActivity(intent);
            }
        });
    }
    // this method is to create the corresponding user type and record data about each type
    private void createobject() {
        String type = accountTypeSpinner.getSelectedItem().toString();
        String username = userNameField.getText().toString();
        String password = passwordField.getText().toString();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        if (type.equals("User")) {
            User newuser = new User(name, username, password, email);
            userlist.add(newuser);
        } else if (type.equals("Manager")) {
            //ID will be replaced next time
            Manager newmanager = new Manager(name, username, password, email,0);
            managerlist.add(newmanager);
        } else if (type.equals("Location Employee")) {
            //ID and storenumber will be replaced next time
            LocationEmployee newlocationemployee =
                    new LocationEmployee(name, username, password, email,0,0);
            locationemployeelist.add(newlocationemployee);
        } else if (type.equals("Admin")) {
            //employeeID will be replaced next time
            Admin newadmin = new Admin(name, username, password, email,0);
            adminlist.add(newadmin);
        }

    }
}