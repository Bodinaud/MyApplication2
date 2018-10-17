package com.kevin.coursjavaandroid.services;


import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service implements LocationListener {

    private LocationManager locationMgr;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("TAG_", "onCreate");

        //Si on a pas la permission on ne s’abonne pas (onCreate)
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            stopSelf();
            return;
        }

        //Minimum (et non égale, c’est Android qui gère) 5 secondes et 200m de difference.(onCreate)
        //Le this ici représente l’interface « LocationListener » à implémenter MANUELLEMENT
        locationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationMgr.getAllProviders().contains(LocationManager.NETWORK_PROVIDER)) {
            locationMgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 0, this);
        }
        if (locationMgr.getAllProviders().contains(LocationManager.GPS_PROVIDER)) {
            locationMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("TAG_", "onDestroy");
        locationMgr.removeUpdates(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    /* ---------------------------------
    // CallBack LocationListener
    // -------------------------------- */

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, location.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}