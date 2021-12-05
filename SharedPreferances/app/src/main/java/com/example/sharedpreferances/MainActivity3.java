package com.example.sharedpreferances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
Button b3;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b3=findViewById(R.id.button3);
        b3.setOnClickListener(this);
        tv=findViewById(R.id.textView2);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sp;
        sp = getSharedPreferences("mysp",MODE_PRIVATE);
        String a = sp.getString("username",null);
        String b = sp.getString("password",null);



        tv.setText(a+" "+b);
    }
}