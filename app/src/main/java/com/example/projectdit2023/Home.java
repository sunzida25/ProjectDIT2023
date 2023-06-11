package com.example.projectdit2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    CardView button1,button2,button3,button4,button5,button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //button hooks
        button1=findViewById(R.id.buttonId1);
        button2=findViewById(R.id.buttonId2);
        button3=findViewById(R.id.buttonId3);
        button4=findViewById(R.id.buttonId4);
        button5=findViewById(R.id.buttonId5);
        button6=findViewById(R.id.buttonId6);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Newsfeed.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,SignUp.class);
                startActivity(intent);

            }
        });


    }
}