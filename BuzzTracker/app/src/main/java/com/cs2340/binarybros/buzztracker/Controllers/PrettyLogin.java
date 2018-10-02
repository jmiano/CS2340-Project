package com.cs2340.binarybros.buzztracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrettyLogin extends AppCompatActivity {

    RelativeLayout relay1;
    private EditText username=null;
    private EditText password=null;
    private TextView attempts;
    private ArrayList<User> userList;
    private ArrayList<Manager> managerList;
    private ArrayList<Admin> adminList;
    private ArrayList<LocationEmployee> locationEmployeeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prettylogin);

        Button cancelBtn = (Button) findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrettyLogin.this, WelcomeActivity.class));
            }
        });

        // get lists of valid login credentials
        Intent i = getIntent();
        userList = (ArrayList<User>) i.getSerializableExtra("user");
        managerList = (ArrayList<Manager>) i.getSerializableExtra("manager");
        adminList = (ArrayList<Admin>) i.getSerializableExtra("admin");
        locationEmployeeList = (ArrayList<LocationEmployee>) i.getSerializableExtra("locationemployee");


        username = (EditText)findViewById(R.id.username_field);
        password = (EditText)findViewById(R.id.password_field);

        Button loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username.getText().toString(), password.getText().toString());
            }
        });
    }



    private void login(String userId, String password) {
        boolean validLogin = false;
        int i = 0;

        while (validLogin == false) {



        }




       if (userId.equals("smartguy")&& password.equals("123456") ){
           startActivity(new Intent(PrettyLogin.this, LogOut.class));
        } else {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Please input a valid Username and Password");
            dlgAlert.setTitle("Incorrect Username and/or Password");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    }
            });
        }
    }
}


