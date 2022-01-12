package com.example.broadcast_receiver_withoutfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
MyReceiver receiver = new MyReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter1,filter2,filter3,filter4;
        //WITHOUT INTENT FILTER......
        filter1= new IntentFilter("android.intent.action.AIRPLANE_MODE");
        filter2= new IntentFilter("android.intent.action.ACTION_POWER_CONNECTIVITY");
        filter3= new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTIVITY");
        filter4= new IntentFilter("android.intent.action.BOOT_COMPLETED");
        registerReceiver(receiver,filter1);
        registerReceiver(receiver,filter2);
        registerReceiver(receiver,filter3);
        registerReceiver(receiver,filter4);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}