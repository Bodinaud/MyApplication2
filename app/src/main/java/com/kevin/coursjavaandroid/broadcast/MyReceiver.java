package com.kevin.coursjavaandroid.broadcast;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.kevin.coursjavaandroid.services.MyBgService;


public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.w("TAG_", "MyReceiver.onReceive ");

        if (intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED)) {
            Log.w("TAG_", "Changement de langue");
            Toast.makeText(context, "Changement de langue", Toast.LENGTH_SHORT).show();
        }
        else if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            //lance mon application au démarrage
            //context.startActivity(new Intent(context, MainActivity.class));
            Log.w("TAG_", "MyReceiver.ACTION_BOOT_COMPLETED ");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(new Intent(context, MyBgService.class));
            }
            else {
                context.startService(new Intent(context, MyBgService.class));
            }
        }
    }
}