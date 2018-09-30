package com.cs2340.binarybros.buzztracker;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RelativeLayout;

public class PrettyLogin extends AppCompatActivity {

    RelativeLayout relay1;
    Handler handler = new Handler();
    private EditText userID;
    private EditText password;
    private TextView loginInfor;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relay1.setVisibility(View.VISIBLE);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prettylogin);

        relay1 = (RelativeLayout) findViewById(R.id.relay1);

        handler.postDelayed(runnable, 2000); //2000 is the timeout of the splash screen

        Button cancelBtn = (Button) findViewById(R.id.cancelButton);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrettyLogin.this, WelcomeActivity.class));
            }
        });
        EditText userID = (EditText) findViewById(R.id.Username);
        EditText password = (EditText) findViewById(R.id.Password);
        TextView loginInfor = (TextView) findViewById(R.id.logininfor);
        loginInfor.setText("please type username and password");
        Button loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklogin (userID.getText().toString(),password.getText().toString());
            }
        });
    }
    private void checklogin(String userid, String password) {
        if (userid.equals("smartguy")&& password.equals("123456") ){
            Intent intent = new Intent(PrettyLogin.this, LogOut.class);
        } else {
            loginInfor.setText("username or password incorrect");
        }
    }

}


