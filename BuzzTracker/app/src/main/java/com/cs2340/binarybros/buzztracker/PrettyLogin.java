package com.cs2340.binarybros.buzztracker;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class PrettyLogin extends AppCompatActivity {

    RelativeLayout relay1;
    Handler handler = new Handler();
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
    }
}
