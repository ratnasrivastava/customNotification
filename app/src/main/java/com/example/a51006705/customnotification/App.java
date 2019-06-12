package com.example.a51006705.customnotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/**
 * Created by 51006705 on 10-06-2019.
 */

public class App extends Application {
    public static final String CHANNEL_ID = "ChannelId";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "ChannelId",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationChannel.setDescription("This is Channel 1");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
