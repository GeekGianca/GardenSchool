package com.geekprogrammer.schoolgarden;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.geekprogrammer.schoolgarden.utils.Utils;

public class DetailActivity extends AppCompatActivity {
    private String nameTitle;
    private int position;
    private TextView name;
    private TextView sciencename;
    private TextView characteristic;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent() != null){
            position = getIntent().getIntExtra("position", 0);
        }
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        name = findViewById(R.id.name);
        sciencename = findViewById(R.id.name_science);
        characteristic = findViewById(R.id.characters);
        image = findViewById(R.id.image);

        name.setText(Utils.list.get(position).getName());
        sciencename.setText(Utils.list.get(position).getScienceName());
        characteristic.setText(Utils.list.get(position).getUse());
        image.setImageResource(Utils.list.get(position).getResource());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }
}
