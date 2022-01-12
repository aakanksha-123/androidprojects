package com.example.sms_manager2bycode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onClick(View v) {
       try{ String number = e1.getText().toString();
        String mssg = e2.getText().toString();
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number,null,mssg,null,null);
        Toast.makeText(this, "Sms send", Toast.LENGTH_SHORT).show();

    }catch (Exception e){
           Toast.makeText(this, " "+e, Toast.LENGTH_SHORT).show();
       }
} }