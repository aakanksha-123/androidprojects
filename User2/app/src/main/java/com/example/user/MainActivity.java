package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   Button b1;
   EditText e1,e2;
   TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.txt_user);
        e2=findViewById(R.id.txt_pass);
        b1=findViewById(R.id.button4);
        b1.setOnClickListener(this);
        tv=findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        String uname;
        int pass;
        uname = e1.getText().toString();
        String p = e2.getText().toString();
        pass = Integer.parseInt(p);

        if(uname.equals("abc") && pass == 123){
            Toast.makeText(this, "Valid username", Toast.LENGTH_SHORT).show();
        }
        else
        {
           // Toast.makeText(this, "Invalid user", Toast.LENGTH_SHORT).show();
            //OR
            tv.setTextColor(Color.RED);
            tv.setText("Invalid username or password");
        }
    }
}