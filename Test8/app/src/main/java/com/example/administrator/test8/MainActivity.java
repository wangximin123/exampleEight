package com.example.administrator.test8;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification=new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is Title").setContentInfo("This is information")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background))
                .setWhen(System.currentTimeMillis())
                .build();
        notificationManager.notify(1,notification);
    }
}
