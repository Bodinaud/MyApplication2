package com.kevin.coursjavaandroid.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.kevin.coursjavaandroid.transverse.NotificationUtils;

public class MyBgService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("TAG_", "MyBgService.onCreate ");
        startForeground(5, NotificationUtils.getNotif(this, "Service en bg"));
        Toast.makeText(this, "Service OnCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service OnDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}