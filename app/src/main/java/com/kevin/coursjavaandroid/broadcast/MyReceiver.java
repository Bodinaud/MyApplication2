package com.kevin.coursjavaandroid.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED)) {
            Log.w("TAG_", "Changement de langue");
            Toast.makeText(context, "Changement de langue", Toast.LENGTH_SHORT).show();
        }
    }
}
