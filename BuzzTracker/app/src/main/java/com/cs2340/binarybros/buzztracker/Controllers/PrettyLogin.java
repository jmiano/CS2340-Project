package com.cs2340.binarybros.buzztracker.Controllers;

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

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.LocationEmployee;
import com.cs2340.binarybros.buzztracker.Models.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PrettyLogin extends AppCompatActivity {

    RelativeLayout relay1;
    private EditText username;
    private EditText password;
    private TextView attempts;
    private List<User> loginList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prettylogin);

        Button cancelBtn = findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrettyLogin.this, WelcomeActivity.class));
            }
        });


        loginList = Database.getInstance().getUserList(); // This gets our non-persistent list of registered users
        username = findViewById(R.id.username_field);
        password = findViewById(R.id.password_field);

        Button loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username.getText().toString(), password.getText().toString());

                //The line below is a shortcut to not have to log-in every time
                //startActivity(new Intent(PrettyLogin.this, LocationManageActivity.class));
            }
        });
    }


    private void login(String userId, String password) {
        boolean validLogin = false;
        int i = 0;

        while ((loginList != null) && !validLogin && (i < loginList.size())) {
            String passedInUserName = loginList.get(i).getUsername();
            String passedInPassword = loginList.get(i).getPassword();

            if (userId.equals(passedInUserName) && password.equals(passedInPassword)) {
                validLogin = true;
            }
            i++;
        }

       if (validLogin){//this is automatically bypassing the login screen for testing purposes - should have "validLogin" in the expression
            Database.getInstance().setCurrentUser(loginList.get(i - 1));
           startActivity(new Intent(PrettyLogin.this, HomeScreen.class));
        } else {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Please input a valid Username and Password");
            dlgAlert.setTitle("Incorrect Username and/or Password");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    }
            });
        }
    }
}


