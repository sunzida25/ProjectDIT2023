package com.example.projectdit2023;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {

    private Spinner spinnerBlood,spinnerDivision,spinnerDistrict,spinnerUpozila;
    private String selectedDivision,selectedDistrict,selectedUpozila,selectedBlood;
    private TextView tvDivi,tvDis,tvUpo,tvBlood;
    private ArrayAdapter<CharSequence> diviAdapter,disAdapter,upoAdapter;
    private TextInputEditText signUpName, signUpNumber, signUpPassword;
    String[] bloodGroup;
    private RadioGroup radioGroup;
    private RadioButton selectedGender;
    Button register, callbackToSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //For Blood Spinner
        spinnerBlood = (Spinner) findViewById(R.id.spinner1);
        bloodGroup = getResources().getStringArray(R.array.blood_group);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.sample_view, R.id.spinner1_view, bloodGroup);
        spinnerBlood.setAdapter(adapter1);
        spinnerBlood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBlood=spinnerBlood.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Close

        //For 3 Dependent Address Spinner
        spinnerDivision=findViewById(R.id.spinner2);
        diviAdapter=ArrayAdapter.createFromResource(this,R.array.all_division,R.layout.division_sample_view);
        diviAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDivision.setAdapter(diviAdapter);

        spinnerDivision.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerDistrict=findViewById(R.id.spinner3);

                selectedDivision=spinnerDivision.getSelectedItem().toString();
                int parentID=parent.getId();
                if (parentID==R.id.spinner2){
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
                            spinnerUpozila=findViewById(R.id.spinner4);
                            selectedDistrict=spinnerDistrict.getSelectedItem().toString();
                            int parentID=parent.getId();
                            if (parentID==R.id.spinner3){
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

        signUpName=findViewById(R.id.UpNameId);
        signUpNumber=findViewById(R.id.UpNumID);
        signUpPassword=findViewById(R.id.UpPassID);
        radioGroup=findViewById(R.id.radioGroupId);
        register=findViewById(R.id.registerBtn);
        callbackToSignIn=findViewById(R.id.signUp2);
        tvDivi=findViewById(R.id.divisionTvId);
        tvDis=findViewById(R.id.districtTvId);
        tvUpo=findViewById(R.id.upozilaTvId);
        tvBlood=findViewById(R.id.bloodTvId);


        //Radio button select
        final String[] genderId = new String[1];
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedGender=radioGroup.findViewById(checkedId);

                switch (checkedId){
                    case R.id.radio1Id:
                    case R.id.radio2Id:
                        genderId[0] =selectedGender.getText().toString();
                        break;
                    default:

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = signUpName.getText().toString();
                String phone = signUpNumber.getText().toString().trim();
                String password = signUpPassword.getText().toString().trim();
                String genderId=selectedGender.getText().toString();
                String bloodSpinner= spinnerBlood.getSelectedItem().toString();
                String divisionSpinner=spinnerDivision.getSelectedItem().toString();
                String districtSpinner=spinnerDistrict.getSelectedItem().toString();
                String upozilaSpinner=spinnerUpozila.getSelectedItem().toString();


                //checking the validity of the Name
                if (name.isEmpty()) {
                    signUpName.setError("Enter Your Name Please");
                    signUpName.requestFocus();
                    return;
                }
                //checking the validity of the phoneNo
                if (phone.isEmpty()) {
                    signUpNumber.setError("Enter Your Phone Number");
                    signUpNumber.requestFocus();
                    return;
                }

                if (!Patterns.PHONE.matcher(phone).matches()) {
                    signUpNumber.setError("Enter a valid Phone Number");
                    signUpNumber.requestFocus();
                    return;
                }
                if (phone.length()<11) {
                    signUpNumber.setError("Phone Number should be 11 Digit");
                    signUpNumber.requestFocus();
                    return;
                }
                if (phone.length()>11) {
                    signUpNumber.setError("Phone Number should be 11 Digit");
                    signUpNumber.requestFocus();
                    return;

                }
                //checking the validity of the password
                if (password.isEmpty()) {
                    signUpPassword.setError("Enter a password");
                    signUpPassword.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    signUpPassword.setError("Password should be at least 6 digit");
                    signUpPassword.requestFocus();
                    return;

                }

                if (radioGroup.getCheckedRadioButtonId()==-1) {
                    Toast.makeText(SignUp.this,"Please Select Gender", Toast.LENGTH_LONG).show();
                    return;
                }

                if (selectedBlood.equals("Select Blood Group")){
                    Toast.makeText(SignUp.this,"Please Select Your Blood Group",Toast.LENGTH_LONG).show();
                    tvBlood.setError("Select Blood Group");
                    tvBlood.requestFocus();
                    return;

                }

                if (selectedDivision.equals("Select Division")){
                    Toast.makeText(SignUp.this,"Please Select Your Division",Toast.LENGTH_LONG).show();
                    tvDivi.setError("Select Division From the List");
                    tvDivi.requestFocus();
                    return;

                }
                if (selectedDistrict.equals("Select Your Division First")){
                    Toast.makeText(SignUp.this,"Please Select Your District",Toast.LENGTH_LONG).show();
                    tvDis.setError("Select District From the List");
                    tvDis.requestFocus();
                    return;

                }

                if (selectedDistrict.equals("Select District")){
                    Toast.makeText(SignUp.this,"Please Select Your District",Toast.LENGTH_LONG).show();
                    tvDis.setError("Select District From the List");
                    tvDis.requestFocus();
                    return;

                }

                if (selectedUpozila.equals("Select Your District First")){
                    Toast.makeText(SignUp.this,"Please Select Your Upozila",Toast.LENGTH_LONG).show();
                    tvUpo.setError("Select Upozila From the List");
                    tvUpo.requestFocus();
                    return;

                }

                if (selectedUpozila.equals("Select District")){
                    Toast.makeText(SignUp.this,"Please Select Your Upozila",Toast.LENGTH_LONG).show();
                    tvUpo.setError("Select Upozila From the List");
                    tvUpo.requestFocus();
                    return;

                }

                Intent intent=new Intent(SignUp.this,OtpVerification.class);
                intent.putExtra("getName",name);
                intent.putExtra("getPhone","+88"+phone);
                intent.putExtra("getPassword",password);
                intent.putExtra("getGender",genderId);
                intent.putExtra("getBlood",bloodSpinner);
                intent.putExtra("getDivision",divisionSpinner);
                intent.putExtra("getDistrict",districtSpinner);
                intent.putExtra("getUpozila",upozilaSpinner);
                startActivity(intent);





            }
        });










    }
}