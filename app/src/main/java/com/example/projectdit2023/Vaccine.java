package com.example.projectdit2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Vaccine extends AppCompatActivity {

    CardView button1,button2,button3;
    ImageView homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);

        //button hooks
        homeButton=findViewById(R.id.homeback);
        button1=findViewById(R.id.womenButton);
        button2=findViewById(R.id.kidsButton);
        button3=findViewById(R.id.covidButton);



        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Vaccine.this,Home.class);
                startActivity(intent);

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Vaccine.this,WomenVaccine.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Vaccine.this,CovidVaccine.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Vaccine.this,KidsVaccine.class);
                startActivity(intent);

            }
        });


    }
}