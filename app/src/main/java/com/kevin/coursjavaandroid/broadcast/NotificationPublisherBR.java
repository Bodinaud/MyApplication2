package com.kevin.coursjavaandroid.broadcast;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;

public class NotificationPublisherBR extends BroadcastReceiver {

    @Override
    public void onReceive(Context c, Intent intent) {
        Notification notification = intent.getParcelableExtra("MaCle");


        //Envoyer la notification
        NotificationManagerCompat ncm = NotificationManagerCompat.from(c);

        //ENVOIE
        ncm.notify(28, notification);
    }
}