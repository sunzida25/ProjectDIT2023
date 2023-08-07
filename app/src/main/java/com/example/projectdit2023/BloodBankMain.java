package com.example.projectdit2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class BloodBankMain extends AppCompatActivity {

    RecyclerView recyclerView4;
    myAdapter4 adapter4;
    Spinner spinnerBlood,spinnerDivision,spinnerDistrict,spinnerUpozila;
    String selectedDivision,selectedDistrict,selectedUpozila,selectedBlood,compositeKey;
    String[] bloodGroup;
    ArrayAdapter<CharSequence> diviAdapter,disAdapter,upoAdapter;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_main);
        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();


        //For Blood Spinner
        spinnerBlood = (Spinner) findViewById(R.id.filterBloodSpinner);
        bloodGroup = getResources().getStringArray(R.array.blood_group);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.sample_view, R.id.spinner1_view, bloodGroup);
        spinnerBlood.setAdapter(adapter1);
        spinnerBlood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBlood=spinnerBlood.getSelectedItem().toString();
                int parentID=parent.getSelectedItemPosition();
                Query query = null;
                if (parentID == 0 ){
                    query = FirebaseDatabase.getInstance().getReference().child("BloodBank_users");
                }
                else {
                    query = FirebaseDatabase.getInstance().getReference().child("BloodBank_users").orderByChild("bloodGroup").equalTo(selectedBlood);
                }
                FirebaseRecyclerOptions<model4> newOptions = new FirebaseRecyclerOptions.Builder<model4>()
                        .setQuery(query, model4.class)
                        .build();
                adapter4.updateOptions(newOptions);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Close

        //For 3 Dependent Address Spinner
        spinnerDivision=findViewById(R.id.filterDivisionSpinner);
        diviAdapter=ArrayAdapter.createFromResource(this,R.array.all_division,R.layout.division_sample_view);
        diviAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDivision.setAdapter(diviAdapter);

        spinnerDivision.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerDistrict=findViewById(R.id.filterDistrictSpinner);

                selectedDivision=spinnerDivision.getSelectedItem().toString();
                int parentID=parent.getId();
                if (parentID==R.id.filterDivisionSpinner){
                    switch (selectedDivision){
                        case "Select Division":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.default_dis,R.layout.division_sample_view);
                            break;

                        case "Dhaka":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.dhaka_division,R.layout.division_sample_view);
                            break;

                        case "Chattogram":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.ctg_division,R.layout.division_sample_view);
                            break;

                        case "Sylhet":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.sylhet_division,R.layout.division_sample_view);
                            break;

                        case "Barishal":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.barishal_division,R.layout.division_sample_view);
                            break;

                        case "Khulna":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.khulna_division,R.layout.division_sample_view);
                            break;

                        case "Rajshahi":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.rajshahi_division,R.layout.division_sample_view);
                            break;

                        case "Rangpur":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.rangpur_division,R.layout.division_sample_view);
                            break;

                        case "Mymensingh":disAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.mymensingh_division,R.layout.division_sample_view);
                            break;


                        default:break;
                    }
                    disAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerDistrict.setAdapter(disAdapter);

                    spinnerDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            spinnerUpozila=findViewById(R.id.filterUpozilaSpinner);
                            selectedDistrict=spinnerDistrict.getSelectedItem().toString();
                            int parentID=parent.getId();
                            if (parentID==R.id.filterDistrictSpinner){
                                switch (selectedDistrict){
                                    case "Select Your Division First":upoAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.default_upo,R.layout.division_sample_view);
                                        break;

                                    case "Select District":upoAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.default_upo,R.layout.division_sample_view);
                                        break;

                                    case "Dhaka":upoAdapter=ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.dhaka_dis,R.layout.division_sample_view);
                                        break;
                                    default:break;
                                }
                                upoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                spinnerUpozila.setAdapter(upoAdapter);

                                spinnerUpozila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        selectedUpozila=spinnerUpozila.getSelectedItem().toString();

                                        compositeKey=selectedBlood+","+selectedUpozila;

                                        int parentID=parent.getSelectedItemPosition();

                                        Query query = null;
                                        if (parentID == 0 ){
                                            query = FirebaseDatabase.getInstance().getReference().child("BloodBank_users");
                                        }
                                        else {
                                            query = FirebaseDatabase.getInstance().getReference().child("BloodBank_users").orderByChild("bldUpo").equalTo(compositeKey);
                                        }
                                        FirebaseRecyclerOptions<model4> newOptions = new FirebaseRecyclerOptions.Builder<model4>()
                                                .setQuery(query, model4.class)
                                                .build();
                                        adapter4.updateOptions(newOptions);

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //For 3 Dependent Address Spinner close



        recyclerView4=findViewById(R.id.recylerView4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model4> options =
                new FirebaseRecyclerOptions.Builder<model4>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("BloodBank_users"), model4.class)
                        .build();

        adapter4=new myAdapter4(options,BloodBankMain.this);
        recyclerView4.setAdapter(adapter4);
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter4.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter4.stopListening();
    }
}