package com.example.broadcast_receiver_withoutfilter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");
        String action = intent.getAction();
        switch (action){
            case "android.intent.action.AIRPLANE_MODE":
                Toast.makeText(context, "AIRPLANE_MODE", Toast.LENGTH_SHORT).show();
                break;
            case "android.intent.action.ACTION_POWER_CONNECTED":
                Toast.makeText(context, "POWER_CONNECTED", Toast.LENGTH_SHORT).show();
             break;
            case "android.intent.action.ACTION_POWER_DISCONNECTED":
                Toast.makeText(context, "POWER_DISCONNECTED", Toast.LENGTH_SHORT).show();
                break;
            case "android.intent.action.BOOT_COMPLETED":
                Toast.makeText(context, "BOOT_COMPLETED", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}