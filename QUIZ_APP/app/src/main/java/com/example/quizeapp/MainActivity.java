package com.example.quizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button b1,b2;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        tv=findViewById(R.id.textView);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b1:
                Intent it = new Intent(this,AdminLogin.class);
                startActivity(it);
                break;

            case R.id.b2:
                Intent it1 = new Intent(this,StudentLogin.class);
                startActivity(it1);
                break;

        }
}

public void onBackPressed(){
        startActivity(new Intent(String.valueOf((this))));
}

}