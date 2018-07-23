package com.example.administrator.test8;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void gotoSecond(View view){
        Intent intent=new Intent(this,SecondActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification=new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is Title").setContentText("This is Text")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Playa.oog")))
                .setVibrate(new long[]{0L,1000L,1000L,1000L})
                .setStyle(new NotificationCompat.BigTextStyle().bigText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.aa)))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build();
        notificationManager.notify(1,notification);

    }
}
