package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cs2340.binarybros.buzztracker.Models.Database;

import java.io.File;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Database.getInstance(); //This instantiates our persistent database
        Database.getInstance().initialize(); //Initialize our data
        File file = new File(WelcomeActivity.this.getFilesDir(), Database.DEFAULT_BINARY_FILE_NAME);
        if (!(file.exists())) {
            Log.d("Welcome Activity", "File doesn't exist");
        } else {
            Database.getInstance().loadBinary(file);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, PrettyLogin.class));
            }
        });

        Button registerBtn = findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, RegisterActivity.class));
            }
        });
    }
}
