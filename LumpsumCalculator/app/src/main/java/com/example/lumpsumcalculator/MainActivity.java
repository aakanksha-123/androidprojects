package com.example.lumpsumcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener{
  EditText e1,e2,e3,e4;
  Button b1;
  TextView t2,t3;
  Spinner sp;
  RadioGroup rg;
  ArrayList<String> hundred,tens,ones,tens1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        e3=findViewById(R.id.edit3);
        e4=findViewById(R.id.edit4);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView10);
        b1=findViewById(R.id.button3);
        rg=findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(this);


        sp=findViewById(R.id.spinner);
        String[] arr = {"Yearly","Monthly"};
        ArrayAdapter<String> ad;
        ad = new ArrayAdapter<> (MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arr);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(this);
        b1.setOnClickListener(this);
        e1.addTextChangedListener(this);
        e2.addTextChangedListener(this);
        e3.addTextChangedListener(this);
        e4.addTextChangedListener(this);

        hundred = new ArrayList<>();
        hundred.add(" ");
        hundred.add("One hundred");
        hundred.add("Two hundred");
        hundred.add("Three hundred");
        hundred.add("Four hundred");
        hundred.add("Five hundred");
        hundred.add("Six hundred");
        hundred.add("Seven hundred");
        hundred.add("Eight hundred");
        hundred.add("Nine hundred");

        tens1 = new ArrayList<>();
        tens1.add(" ");
        tens1.add("Ten");
        tens1.add("Twenty");
        tens1.add("Thirty");
        tens1.add("Fourty");
        tens1.add("Fifty");
        tens1.add("Sixty");
        tens1.add("Seventy");
        tens1.add("Eighty");
        tens1.add("Ninty");

        ones = new ArrayList<>();
        ones.add(" ");
        ones.add("One");
        ones.add("Two");
        ones.add("Three");
        ones.add("Four");
        ones.add("Five");
        ones.add("Six");
        ones.add("Seven");
        ones.add("Eight");
        ones.add("Nine");

        tens = new ArrayList<>();
        tens.add(" ");
        tens.add("Eleven");
        tens.add("Twelve");
        tens.add("Thirteen");
        tens.add("Fourteen");
        tens.add("Fifteen");
        tens.add("Sixteen");
        tens.add("Seventeen");
        tens.add("Eighteen");
        tens.add("Ninteen");

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
           try {
               String num;
               num = e1.getText().toString();
               int x;
               x = Integer.parseInt(num);
               int a, b, c, d, e;
               a = x;
               b = a / 100;
               c = a % 100;
               d = c / 10;
               e = c % 10;

               //hundred
               StringBuffer s1 = new StringBuffer();
               s1.append(hundred.get(b));
               if (c >= 11 && c <= 19) {
                   s1.append(" " + tens.get(e));
               } else {
                   s1.append(" " + tens1.get(d));
                   s1.append(" " + ones.get(e));

               }

               t2.setTextColor(Color.RED);
               t2.setText(s1);
           }catch (Exception e){

           }
        }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {

        String a,b,c,d;
        double num1,num2,num3,num4;

        int res;
        a = e1.getText().toString();
        num1 = Integer.parseInt(a);
        b = e2.getText().toString();
        num2 = Integer.parseInt(b);
        c = e3.getText().toString();
        num3 = Integer.parseInt(c);
        d = e4.getText().toString();
        num4 = Integer.parseInt(d);
        double A = num1 * Math.pow(1+ (num2/num3),num3*num4) ;
        double CI = A - num1;
        t3.setText(String.valueOf(CI));
       // int A = num1 * num2 * num3 * num4 ;
        //t3.setText(A);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s1;
        s1 = sp.getSelectedItem().toString();
        int i=sp.getSelectedItemPosition();
        //tv.setText(s1+" "+i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
           /* String s1=" ";
            switch(rg.getCheckedRadioButtonId()){
                case R.id.radioButton:
                    s1="Yearly";
                    break;
                case R.id.radioButton2:
                    s1="Monthly";
                    break;

    }}*/
    }}


