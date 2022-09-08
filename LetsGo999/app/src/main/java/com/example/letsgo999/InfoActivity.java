package com.example.letsgo999;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    private EditText setup_full_name_et, setup_phone_et, setup_age_et, setup_gender_et;
    private EditText setup_income_et, setup_address_et, setup_city_et, setup_country_et;
    private Button register_btn;

    //private FirebaseAuth mAuth;
    private DatabaseReference UserRef;

    String currentUserID;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //mAuth = FirebaseAuth.getInstance();
        currentUserID = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        UserRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);

        setup_full_name_et = (EditText) findViewById(R.id.setupFullNameEt);
        setup_phone_et = (EditText) findViewById(R.id.setupPhoneEt);
        setup_age_et = (EditText) findViewById(R.id.setupAgeEt);
        setup_gender_et = (EditText) findViewById(R.id.setupGenderEt);
        setup_income_et = (EditText) findViewById(R.id.setupIncomeEt);
        setup_address_et = (EditText) findViewById(R.id.setupAddressEt);
        setup_city_et = (EditText) findViewById(R.id.setupCityEt);
        setup_country_et = (EditText) findViewById(R.id.setupCountryEt);

        register_btn = (Button) findViewById(R.id.setupRegisterBtn);
        progressDialog = new ProgressDialog(InfoActivity.this);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveAccountSetupinformation();
            }
        });
    }

    private void SaveAccountSetupinformation() {

        String setup_full_name = setup_full_name_et.getText().toString();
        String setup_phone = setup_phone_et.getText().toString();
        String setup_age = setup_age_et.getText().toString();
        String setup_gender = setup_gender_et.getText().toString();
        String setup_income = setup_income_et.getText().toString();
        String setup_address = setup_address_et.getText().toString();
        String setup_city = setup_city_et.getText().toString();
        String setup_country = setup_country_et.getText().toString();

        if(TextUtils.isEmpty(setup_full_name))
        {
            Toast.makeText(this,"Enter Full Name",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(setup_phone))
        {
            Toast.makeText(this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(setup_age))
        {
            Toast.makeText(this,"Enter Age",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(setup_gender))
        {
            Toast.makeText(this,"Enter Gender",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(setup_income))
        {
            Toast.makeText(this,"Enter Income",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(setup_address))
        {
            Toast.makeText(this,"Enter Address",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(setup_city))
        {
            Toast.makeText(this,"Enter City",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(setup_country))
        {
            Toast.makeText(this,"Enter Country",Toast.LENGTH_SHORT).show();
        }
        else {
            progressDialog.show();
            progressDialog.setMessage("Saving Information");
            //progressDialog.setContentView(R.layout.progress_dialog4);
            progressDialog.setCanceledOnTouchOutside(false);

            HashMap userMap = new HashMap();
            userMap.put("name", setup_full_name);
            userMap.put("phone", setup_phone);
            userMap.put("age", setup_age);
            userMap.put("gender", setup_gender);
            userMap.put("income", setup_income);
            userMap.put("address", setup_address);
            userMap.put("city", setup_city);
            userMap.put("country", setup_country);

            UserRef.updateChildren(userMap).addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        SendUserToProfileActivity();
                        //Toast.makeText(InfoActivity.this,"Account is created successfully",Toast.LENGTH_LONG).show();
                    }
                    else{
                        progressDialog.dismiss();
                        String message = task.getException().getMessage();
                        Toast.makeText(InfoActivity.this,""+message,Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(InfoActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void SendUserToProfileActivity() {
        Intent profileIntent = new Intent(InfoActivity.this, DashboardActivity.class);
        profileIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(profileIntent);
        finish();
    }
}