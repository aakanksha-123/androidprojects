package com.example.callingsubactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
  TextView tv;
  int x,y,z;
  Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2=findViewById(R.id.button2);
        Intent it2=getIntent();
        Bundle ob = it2.getExtras();
        x=ob.getInt("num1");
        y=ob.getInt("num2");
        z=x+y;
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();

}

    @Override
    public void finish() {
        Intent it=new Intent(this,MainActivity.class);
        try{
            z=x/y;
            it.putExtra("result",z);
            setResult(RESULT_OK,it);
        }
        catch (Exception e){
            it.putExtra("result",0);
            setResult(RESULT_CANCELED,it);

        }
        super.finish();
    }

    }
