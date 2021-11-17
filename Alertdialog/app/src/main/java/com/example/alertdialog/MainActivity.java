package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener, View.OnClickListener {
  Button b1;
  TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
        tv=findViewById(R.id.textView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        show();
    }

    @Override
    public void onClick(DialogInterface dialog, int i) {
        String s1=" ";
        switch (i){
            case AlertDialog.BUTTON_POSITIVE:
                 // s1="Yes";
                //Or
                finish();
                  break;
            case AlertDialog.BUTTON_NEGATIVE:
                s1="No";
                break;
            case AlertDialog.BUTTON_NEUTRAL:
                s1="Cancel";
                break;
        }
        tv.setText(s1);
    }

    void show(){
     AlertDialog ad;
     ad=new AlertDialog.Builder(this).create();
     ad.setMessage("Do you want to exit?");

     ad.setButton(AlertDialog.BUTTON_POSITIVE,"Yes",this);
     ad.setButton(AlertDialog.BUTTON_NEGATIVE,"No",this);
     ad.setButton(AlertDialog.BUTTON_NEUTRAL,"Cancel",this);
     ad.show();
 }

    @Override
    public void onClick(View v) {
        show();
    }


}