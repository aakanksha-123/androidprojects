package com.example.notificationaction;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView tv;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tv =findViewById(R.id.textView);
        Intent it2= getIntent();
        Bundle remoteinput= RemoteInput.getResultsFromIntent(it2);
        if(remoteinput!=null){
            String s=(String) remoteinput.getString("myKey");
            tv.setText(s);
    }
} }