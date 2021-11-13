package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    EditText e1, e2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.num1);
       e2 = findViewById(R.id.num2);
       tv = findViewById(R.id.result);

    }


    public void btnsum(View view) {
        float n1 = Float.parseFloat(e1.getText().toString());
        float n2 = Float.parseFloat(e2.getText().toString());
        float sum = n1 + n2;
        tv.setText(String.valueOf(sum));

    }
    public void btnsub(View view) {
        float n1 = Float.parseFloat(e1.getText().toString());
        float n2 = Float.parseFloat(e2.getText().toString());
        float sub = n1 - n2;
        tv.setText(String.valueOf(sub));

    }
    public void btnmulti(View view) {
        float n1 = Float.parseFloat(e1.getText().toString());
        float n2 = Float.parseFloat(e2.getText().toString());
        float mul = n1 * n2;
        tv.setText(String.valueOf(mul));

    }
    public void btndiv(View view) {
        float n1 = Float.parseFloat(e1.getText().toString());
        float n2 = Float.parseFloat(e2.getText().toString());
        float div = n1 /n2;
        tv.setText(String.valueOf(div));

    }
}
