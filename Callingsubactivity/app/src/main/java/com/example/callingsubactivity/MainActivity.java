package com.example.callingsubactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  Button b1;
  EditText e1,e2;
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==123 && resultCode==RESULT_OK){
            Bundle ob= data.getExtras();
            int r = ob.getInt("result");
            Toast.makeText(this, " "+r, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Exception occured!!", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onClick(View v) {
        int a=Integer.parseInt(e1.getText().toString());
        int b=Integer.parseInt(e2.getText().toString());
        Intent it = new Intent(this,MainActivity2.class);
        it.putExtra("num1",a);
        it.putExtra("num2",b);
        startActivityForResult(it,123);

    }
}