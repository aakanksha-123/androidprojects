package com.example.notification2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            b1=findViewById(R.id.button);
            b1.setOnClickListener(this::onClick);
        }

        //@Override
        public void onClick(View v) {
            //obtain a NotificationManager class object
            //by using getSystemService
            NotificationManager manager;
            manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            //Create notification channel object
            NotificationChannel channel;
            channel=new NotificationChannel("CH1","message",NotificationManager.IMPORTANCE_DEFAULT);
        /* create Intent objec which specify Activity to display when user tap on notification
        Here we are using PendingIntent because we need to send message to android when uer tap on notification
         */

            // ceate intent objectwhich specify ctivity

            Intent it = new Intent(MainActivity.this,MainActivity2.class);
            PendingIntent pd;
            pd = PendingIntent.getActivity(MainActivity.this,123,it,0);


            //create builder object
            Notification.Builder builder;
            builder = new Notification.Builder(this);
            builder.setSmallIcon(R.drawable.ic_launcher_background);
            builder.setContentTitle("This is Title");
            builder.setContentText("This is content");
            builder.setChannelId("CH1");
//create  a builder object
            builder.setContentIntent(pd);
            builder.setAutoCancel(true);

            Notification notification;
            notification=builder.build();
            manager.createNotificationChannel(channel);
            manager.notify(123,notification);
            finish();

        }
    }
