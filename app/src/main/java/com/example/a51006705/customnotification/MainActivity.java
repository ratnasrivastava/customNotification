package com.example.a51006705.customnotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import static com.example.a51006705.customnotification.App.CHANNEL_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    public void showNotification(View v){
        RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.collapsed_notification);
        RemoteViews expandedView = new RemoteViews(getPackageName(), R.layout.expanded_notification);

        //To make image clickable
        Intent clickIntent = new Intent(this, NotificationReceiver.class);
        //Pending intent allows another process to execute our code on our behalf
        PendingIntent clickPendingIntent = PendingIntent.getBroadcast(this, 0, clickIntent, 0);

        //if want to set from Java code
        collapsedView.setTextViewText(R.id.textView_collapsed_notification_info, "Hello World");
        expandedView.setImageViewResource(R.id.image_view_expanded_notification_info, R.drawable.ratna_srivastava_51006705);
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded_notification_info, clickPendingIntent);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.dog)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .build();

        notificationManagerCompat.notify(1, notification);
    }
}
