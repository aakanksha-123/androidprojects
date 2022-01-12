package com.example.listeningincomingmssg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle ob = intent.getExtras();
        Object[] arr= (Object[]) ob.get("pdus");
        for(Object t1 : arr){
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) t1);
            String number = sms.getDisplayOriginatingAddress();
            String mssg =sms.getMessageBody();
            Toast.makeText(context, number+""+mssg, Toast.LENGTH_SHORT).show();

        }
    }
}