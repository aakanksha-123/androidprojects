package com.example.sms_manager1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText e1,e2;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String number = e1.getText().toString();
        String mssg = e2.getText().toString();
        Intent it = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+ number));
        it.putExtra("sms_body",mssg);
        startActivity(it);
    }
}