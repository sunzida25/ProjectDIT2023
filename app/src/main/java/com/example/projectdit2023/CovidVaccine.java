package com.example.projectdit2023;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CovidVaccine extends AppCompatActivity {

    Button covidButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_vaccine);

        covidButton=findViewById(R.id.covidButton);

        covidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String theurl = "https://surokkha.gov.bd/";
                Uri urlstr = Uri.parse(theurl);
                Intent urlintent = new Intent();
                urlintent.setData(urlstr);
                urlintent.setAction(Intent.ACTION_VIEW);
                startActivity(urlintent);
            }
        });

    }
}