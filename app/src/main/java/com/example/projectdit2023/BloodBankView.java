package com.example.projectdit2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class BloodBankView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_view);

        SharedPreferences prefs = getSharedPreferences("name", MODE_PRIVATE);
        boolean isLoggedIn= prefs.getBoolean("isLoggedIn", false);

        if(isLoggedIn){
            Intent intent=new Intent(getApplicationContext(),BloodBankMain.class);
            startActivity(intent);
            finish();
            return;
        }
        else{
            startActivity(new Intent(getApplicationContext(),SignIn.class));
            finish();
            return;
        }

    }
}