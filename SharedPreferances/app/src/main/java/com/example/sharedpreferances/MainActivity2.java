package com.example.sharedpreferances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
Button b2;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(this);
        tv=findViewById(R.id.textView);

    }


    @Override
    public void onClick(View v) {
        SharedPreferences sp;
        sp = getSharedPreferences("mysp",MODE_PRIVATE);
        String a = sp.getString("username",null);
        String b = sp.getString("password",null);

        Intent it = new Intent(MainActivity2.this,MainActivity3.class);

        startActivity(it);

        tv.setText(a+" "+b);
    }
}