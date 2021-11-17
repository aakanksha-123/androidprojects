package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   ToggleButton tb;
   TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.toggleButton);
        tv=findViewById(R.id.textView);
        tb.setOnClickListener(this);
        tb.setTextOff("OFF");
        tb.setTextOn("ON");

    }

    @Override
    public void onClick(View v) {
        if(tb.isChecked()){
            tv.setText("Switch is ON");
        }else{
            tv.setText("Switch is OFF");
        }
    }
}