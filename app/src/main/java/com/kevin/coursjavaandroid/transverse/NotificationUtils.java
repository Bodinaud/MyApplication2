package com.kevin.coursjavaandroid.transverse;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.kevin.coursjavaandroid.MainActivity;
import com.kevin.coursjavaandroid.R;
import com.kevin.coursjavaandroid.broadcast.NotificationPublisherBR;

public class NotificationUtils {


    private static final String CHANNEL_ID = "MonSuperChannel";
    private static final CharSequence CHANNEL_NAME = "Commandes";

    /**
     * Création du channel
     */
    private static void initChannel(Context c) {
        // Uniquement à partir d’Oreo
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager nm = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
        // Réglage du channel
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription("Commandes"); // Description
        channel.enableLights(true); // Lumière
        channel.enableVibration(true); // Vibration
        channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

        // Création du channel
        nm.createNotificationChannel(channel);
    }

    //Envoyer une notification immediate
    public static void createInstantNotification(Context c, String message) {
        //Initialisation du chanel
        initChannel(c);
        //Ce qui se passera quand on cliquera sur la notif
        Intent intent = new Intent(c, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(c, 28, intent, PendingIntent.FLAG_ONE_SHOT);

        //La notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(c, CHANNEL_ID);
        notificationBuilder.setSmallIcon(R.mipmap.ic_done)
                .setContentTitle("Le titre")
                .setContentText(message)
                .setContentIntent(pi)//le clic dessus
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_ALL);//Son + afficher la notification
        Notification notification = notificationBuilder.build();

        //Envoyer la notification
        NotificationManagerCompat ncm = NotificationManagerCompat.from(c);

        //ENVOIE
        ncm.notify(29, notification);
    }

    public static void scheduleNotification(Context c, String message, long delay) {
        //Initialisation du chanel
        initChannel(c);

        //La notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(c, CHANNEL_ID);
        builder.setContentTitle("Scheduled Notification");
        builder.setContentText(message);
        builder.setSmallIcon(R.mipmap.ic_done);

        //Redirection vers le broadcast
        Intent notificationIntent = new Intent(c, NotificationPublisherBR.class);
        notificationIntent.putExtra("MaCle", builder.build());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(c, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //La dans le futur
        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)
                c.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    public static Notification getNotif(Context c, String message) {
        initChannel(c);

        //Ce qui se passera quand on cliquera sur la notif
        Intent intent = new Intent(c, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(c, 28, intent, PendingIntent.FLAG_ONE_SHOT);

        //La notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(c, CHANNEL_ID);
        notificationBuilder.setSmallIcon(R.mipmap.ic_done)
                .setContentTitle("Le titre")
                .setContentText(message)
                .setContentIntent(pi)//le clic dessus
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_ALL);//Son + afficher la notification
        return notificationBuilder.build();
    }
}