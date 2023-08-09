package com.example.projectdit2023;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class WomenVaccine extends AppCompatActivity {

    ImageView image;
    Button viewButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_vaccine);

        image=findViewById(R.id.image1);
        viewButton=findViewById(R.id.viewButton);






    }
}