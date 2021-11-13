package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener { ///RadioGroup.OnCheckedChangeListener using because, here is the radio button
    Button b1;
    TextView t1;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=findViewById(R.id.button2);
        t1=findViewById(R.id.textView);
       rg=findViewById(R.id.radiogroup1);  //here we are writing the radiogroup ,because inside radiogroup their is radiobutton
       rg.setOnCheckedChangeListener(this);
       b1.setOnClickListener(this);

    }
 //2 methods
    // for radio button 2 methods
    //1) clicking OK buttn and it display the text
    //2)  by directly tik the options and it display
    @Override
    public void onClick(View v) {   ///by using OK button
        check();
    }
    void check(){
        String s1=" ";
        switch(rg.getCheckedRadioButtonId()){
            case R.id.radioButton:
                   s1="Mechanical Engineering";
                   break;
           case R.id.radioButton2:
                   s1="Electrical Engineering";
                   break;
            case R.id.radioButton3:
                   s1="Computer science and engineering";
                   break;
            case R.id.radioButton4:
                   s1="Electronics and Telecommunication Engineeering";
                   break;
            case R.id.radioButton5:
                   s1="Chemical Engineering";
                   break;



        }
        t1.setText(s1);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {  //directly clicking the options
        check();
    }
}