package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {
Button b1;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);

        tv=findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        Calendar c = Calendar.getInstance();
        int hour, minute;
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog tp;
        tp=new TimePickerDialog(this,this,hour,minute,true);
        tp.show();
    }


    @Override
    public void onTimeSet(TimePicker view, int i, int i1) {
        String s1=" ";
        s1=i+":"+i1;
        tv.setText(s1);

    }
}