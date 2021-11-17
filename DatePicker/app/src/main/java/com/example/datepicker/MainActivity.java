package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.SearchManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , DatePickerDialog.OnDateSetListener {
Button b1;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button2);
        b1.setOnClickListener(this);
        tv=findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v) {
        Calendar c= Calendar.getInstance();
        int d,m,y;
        d=c.get(Calendar.DAY_OF_MONTH);
        m=c.get(Calendar.MONDAY);
        y=c.get(Calendar.YEAR);
        DatePickerDialog dp;
        dp=new DatePickerDialog(this,this,y,m,d);
        dp.show();
    }

    @Override
    public void onDateSet(DatePicker view, int i, int i1, int i2) {
      i1++;
      String s1=" ";
      s1=i+"/"+i1+"/"+i2;
      tv.setText(s1);
    }
}