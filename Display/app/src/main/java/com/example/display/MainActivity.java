package com.example.display;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  TextView t1,t2,t3;
  EditText e1,e2,e3;
  Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.id);
        e2=findViewById(R.id.name);
        e3=findViewById(R.id.email);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(this::onClick);
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView3);
        t3=findViewById(R.id.textView4);
    }

    @Override
    public void onClick(View v) {
        String s1,s2,s3;
        int i1;
        s1=e1.getText().toString();
        t1.setText(" ID : "+s1);
        s2=e2.getText().toString();
        t2.setText(" Name : "+s2);
        s3=e3.getText().toString();
        t3.setText(" Email : "+s3);

    }
}