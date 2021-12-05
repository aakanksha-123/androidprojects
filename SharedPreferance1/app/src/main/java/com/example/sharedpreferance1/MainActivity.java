package com.example.sharedpreferance1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

Button b1,b2;
ConstraintLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        l1=findViewById(R.id.layout1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);


        SharedPreferences sp;
        //get shared preferance object
        sp = getSharedPreferences("mysp",MODE_PRIVATE);
        l1.setBackgroundColor(sp.getInt("color",Color.WHITE));


    }

    @Override
    public void onClick(View v) {
        SharedPreferences sp;
        //get shared preferance object
        sp = getSharedPreferences("mysp",MODE_PRIVATE);
        //call edit() to get editor object
        SharedPreferences.Editor ed;
        ed=sp.edit();

        switch (v.getId()) {
            case R.id.button:
                ed.putInt("color",Color.RED);
              //  l1.setBackgroundColor(Color.RED);
                break;

            case R.id.button2:
                ed.putInt("color", Color.GREEN);
               // l1.setBackgroundColor(Color.GREEN);
                break;

                //to save changes
        }
                ed.commit();
        }
    }
