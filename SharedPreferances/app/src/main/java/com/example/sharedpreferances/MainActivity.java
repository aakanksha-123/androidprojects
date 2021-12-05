package com.example.sharedpreferances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
        String un = e1.getText().toString();
        String p = e2.getText().toString();
        SharedPreferences sp;
        //get shared preferance object
        sp=getSharedPreferences("mysp",MODE_PRIVATE); //private because we can used it privatly for this app only
        //call edit() to get Editor object
        SharedPreferences.Editor ed;
        ed=sp.edit();
        //put values in sp by using put
        ed.putString("username",un);
        ed.putString("password",p);
        //to save changes
        ed.commit();
        Intent it = new Intent(MainActivity.this,MainActivity2.class);

        startActivity(it);

    }
}