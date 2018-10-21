package com.geekprogrammer.schoolgarden;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView initial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initial = findViewById(R.id.home);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/OpenSansExtraBoldItalic.ttf");
        initial.setTypeface(face);
        Thread myT = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1500);
                    Intent intent = new Intent(HomeActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myT.start();
    }
}
