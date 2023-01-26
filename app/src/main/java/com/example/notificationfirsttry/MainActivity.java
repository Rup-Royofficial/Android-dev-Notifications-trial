package com.example.notificationfirsttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private static final String CHANNEL_ID = "NOTIFY_CHANNEL";
private static final int NOTIFICATION_ID = 010;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.robot_hdpi,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notify;

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    notify = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.robot_mdpi)
                    .setContentText("New Message")
                    .setSubText("You have a message from Lauwda")
                    .setChannelId(CHANNEL_ID)
                    .build();
                    nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"MSG Channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else{
                    notify = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.robot_mdpi)
                    .setContentText("New Message")
                    .setSubText("You have a message from Lauwda")
//                    .setChannelId(CHANNEL_ID)
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notify);
    }
}