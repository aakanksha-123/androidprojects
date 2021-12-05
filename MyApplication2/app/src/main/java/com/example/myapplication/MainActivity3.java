package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

 TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv1=findViewById(R.id.textView2);
        Intent it2 = getIntent();
        Bundle ob =it2.getExtras();
        int b=ob.getInt("count");

        tv1.setText(" Your Final score is  "+ b);
    }
}