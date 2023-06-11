package com.example.projectdit2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class OtpVerification extends AppCompatActivity {

    String name,phone,password,gender,division,district,upozila,bloodGroup;

    String codeBySystem,bldUpo;
    EditText otpField;
    Button verifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        otpField=findViewById(R.id.otpId);
        verifyBtn=findViewById(R.id.verifyButtonId);

        name=getIntent().getStringExtra("getName");
        phone=getIntent().getStringExtra("getPhone");
        password=getIntent().getStringExtra("getPassword");
        gender=getIntent().getStringExtra("getGender");
        division=getIntent().getStringExtra("getDivision");
        district=getIntent().getStringExtra("getDistrict");
        upozila=getIntent().getStringExtra("getUpozila");
        bloodGroup=getIntent().getStringExtra("getBlood");
        bldUpo=bloodGroup+","+upozila;


        sentVerificationCodeToUser(phone);
    }

    private void sentVerificationCodeToUser(String phone) {
        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phone)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem=s;
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    String code=phoneAuthCredential.getSmsCode();
                    if (code!=null){
                        otpField.setText(code);
                        verifyCode(code);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(OtpVerification.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            };

    private void verifyCode(String code) {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(codeBySystem,code);
        signInWithPhoneAuthCredential(credential);

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            storeUserData();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(OtpVerification.this,"Verification Failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }

    private void storeUserData() {
        FirebaseDatabase rootNode=FirebaseDatabase.getInstance();
        DatabaseReference reference=rootNode.getReference("BloodBank_users");

        UserHelper addNewUser = new UserHelper(name, phone, password, gender, division, district, upozila, bloodGroup, bldUpo);
        reference.child(phone).setValue(addNewUser);

        Toast.makeText(OtpVerification.this,"Registration Successful",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(OtpVerification.this,SignIn.class);
        startActivity(intent);
    }


    public void callNextScreen(View view) {
        String code=otpField.getText().toString();
        if(!code.isEmpty()){
            verifyCode(code);
        }
    }
}