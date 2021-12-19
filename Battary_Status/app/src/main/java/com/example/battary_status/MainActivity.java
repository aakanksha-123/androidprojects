package com.example.battary_status;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv;
BattaryReceiver br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       tv= findViewById(R.id.textView);
        br = new BattaryReceiver(tv);
        registerReceiver(br,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}