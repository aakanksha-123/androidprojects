package com.example.my2buttonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   Button b1,b2;
   ConstraintLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn_red);
        b2=findViewById(R.id.btn_blue);
        l1=findViewById(R.id.layout1);
        b1.setOnClickListener(this::onClick);
        b2.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_red:
                //set red colour
                l1.setBackgroundColor(Color.RED);
                break;

            case R.id.btn_blue:
                //set blue colour
                l1.setBackgroundColor(Color.BLUE);
        }

    }
}