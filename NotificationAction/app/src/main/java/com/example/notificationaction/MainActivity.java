package com.example.notificationaction;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    NotificationChannel nc;
    NotificationManager nm;
    String CHANNEL_ID = "channel1";
    String CHANNEL_NAME = "mychannel";
    String GROUP_KEY = "key1";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
            b1.setOnClickListener(this);
            nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nc = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v) {

            createSingleNotification();
        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        void createSingleNotification() {
            //specity activity to open when we reply
            Intent it = new Intent(this, MainActivity2.class);
        PendingIntent pd = PendingIntent.getActivity(this, 123, it, 0);

            //Create Builder object
            Notification.Builder builder;
            builder = new Notification.Builder(this, CHANNEL_ID);

            builder.setSmallIcon(R.drawable.ic_launcher_foreground);
            builder.setContentTitle("This is title 1");
            builder.setContentText("This is message 1!!!");
            builder.setChannelId(CHANNEL_ID);
            builder.setContentIntent(pd);
            builder.setAutoCancel(true);
            builder.setGroup(GROUP_KEY);


            Notification.Action action1;
            action1=new Notification.Action(android.R.drawable.sym_action_chat,"Accept",pd);

            Intent it1 = new Intent(this, MainActivity3.class);
            PendingIntent pd1 = PendingIntent.getActivity(this, 456, it1, 0);

            Notification.Action action2;
            action2=new Notification.Action(android.R.drawable.ic_delete,"Cancel",pd1);
            builder.setActions(action1,action2);

            RemoteInput.Builder remoteBuider;
            remoteBuider=new RemoteInput.Builder("myKey");
            remoteBuider.setLabel("Type Something here....");

            RemoteInput remoteInput;
            remoteInput=remoteBuider.build();

            Intent it2 = new Intent(this, MainActivity4.class);
            PendingIntent pd2 = PendingIntent.getActivity(this, 789, it2, 0);

            Notification.Action.Builder builder1 =new Notification.Action.Builder(R.drawable.ic_launcher_foreground,"Reply",pd2);
            builder1.addRemoteInput(remoteInput);
            Notification.Action action3;
            action3=builder1.build();

            builder.setActions(action1,action2,action3);

            Notification n = builder.build();

            nm.createNotificationChannel(nc);

            nm.notify(1, n);

            finish();
        }
    }

