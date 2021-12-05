package com.example.colorselector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

SeekBar sb1,sb2,sb3;
TextView tv;

ConstraintLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb1 = findViewById(R.id.seekBar);
        sb2 = findViewById(R.id.seekBar2);
        sb3 = findViewById(R.id.seekBar3);
        l1 = findViewById(R.id.layout1);

        sb1.setOnSeekBarChangeListener(this);
        sb2.setOnSeekBarChangeListener(this);
        sb3.setOnSeekBarChangeListener(this);

        sb1.setMin(0);
        sb1.setMax(255);
        sb2.setMin(0);
        sb2.setMax(255);
        sb3.setMin(0);
        sb3.setMax(255);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    // for seprate colouring
        /*switch (seekBar.getId()) {

            case R.id.seekBar:
                // red=i;
                l1.setBackgroundColor(Color.RED);
                break;
            case R.id.seekBar2:
                //green=i;
                += l1.setBackgroundColor(Color.GREEN);
                break;
            case R.id.seekBar3:
                // blue=i;
                l1.setBackgroundColor(Color.BLUE);
                break;
    } */

       /// Red+green+Blue Colouring
    l1.setBackgroundColor(
           Color.rgb(sb1.getProgress(),sb2.getProgress(),sb3.getProgress())
    );



    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}








