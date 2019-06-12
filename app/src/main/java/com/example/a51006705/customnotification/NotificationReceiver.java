package com.example.a51006705.customnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

/**
 * Created by 51006705 on 11-06-2019.
 */

public class NotificationReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Image is clicked", Toast.LENGTH_SHORT).show();

        //To remove notification after clicking

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.cancel(1);

    }
}
