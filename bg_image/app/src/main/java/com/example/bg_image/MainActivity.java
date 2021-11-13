package com.example.bg_image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button2);
        l1=findViewById(R.id.layout);
        b1.setOnClickListener(this::onClick);
        b2.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button3:
                l1.setBackgroundResource(R.drawable.img11);
                break;

            case R.id.button2:
                l1.setBackgroundResource(R.drawable.img2);
                break;
        }
    }
}