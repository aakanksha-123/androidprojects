package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {  // CompoundButton.OnCheckedChangeListener we are using because
                                                                      //CompundButton is based class of RadioGroup
    Button b1;
    TextView t1;
    CheckBox c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=findViewById(R.id.button);
        t1=findViewById(R.id.textView);
        c1=findViewById(R.id.checkBox1);
        c2=findViewById(R.id.checkBox2);
        c3=findViewById(R.id.checkBox3);

        b1.setOnClickListener(this);
       c1.setOnCheckedChangeListener(this);
       c2.setOnCheckedChangeListener(this);
       c3.setOnCheckedChangeListener(this);

    }
  // 2 methods for the checkbox
    //1) by simply clicking the Ok button it display

    @Override
    public void onClick(View v) {  //1st method tik checkbox and then click the button then we dsplay the text
        String s1=" ";
        if(c1.isChecked()){
            s1="C";
        }
        if(c2.isChecked()){
            s1+="CPP";
        }
        if(c3.isChecked()){
            s1+="JAVA";

        }
       t1.setText(s1);
    }



   @Override
    public void onCheckedChanged(CompoundButton cb, boolean b) {     //2nd method in the only after tiking the checkbox text is display no neet to press the buton
        String s2= cb.getText().toString();
        if(b == true){
            t1.setText(s2+"Selected");

        }
        else{
            t1.setText(s2+"Deselected");
        }
    }
}