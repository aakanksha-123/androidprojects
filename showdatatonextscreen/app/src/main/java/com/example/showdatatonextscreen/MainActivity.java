package com.example.showdatatonextscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  EditText e1,e2;
  Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String fname=e1.getText().toString();
        int age = Integer.parseInt(e2.getText().toString());
        Intent it = new Intent(this,MainActivity2.class);
        it.putExtra("firstname",fname);
        it.putExtra("myage",age);
        startActivity(it);
    }
}