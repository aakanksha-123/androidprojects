package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText e1;
    Button b1;
    TextView t1;
    ArrayList<String> hundred, tens, ones, tens1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.edit_text);
        b1 = findViewById(R.id.button);
        t1 = findViewById(R.id.textView);
        b1.setOnClickListener(this);


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
    public void onClick(View v) {
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

        t1.setTextColor(Color.RED);
        t1.setText(s1);
    }
}