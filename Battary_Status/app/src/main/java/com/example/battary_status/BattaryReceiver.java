package com.example.battary_status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.TextView;

public class BattaryReceiver extends BroadcastReceiver {
    TextView tv;
   BattaryReceiver(TextView tv){
    this.tv=tv;

}



    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
       if(level!=0)
       {
           tv.setText(level+"%");
       }
    }

}