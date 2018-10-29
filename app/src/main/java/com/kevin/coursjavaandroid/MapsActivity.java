package com.kevin.coursjavaandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kevin.coursjavaandroid.model.bean.ToulouseBean;
import com.kevin.coursjavaandroid.model.bean.VeloBean;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //Data
    private ArrayList<VeloBean> station;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        ToulouseBean toulouse = new ToulouseBean("Toulouse", new LatLng(43.59999, 1.43333));
        MarkerOptions markerToulouse = new MarkerOptions();
        markerToulouse.position(toulouse.getPosition());
        markerToulouse.title(toulouse.getNom());

        markerToulouse.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mMap.addMarker(markerToulouse).setTag(toulouse);
//        //Centrer la carte sur un point (Sans animation)
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(toulouse.getPosition()));
//        //Centrer la carte sur un point (Avec une animation)
//        mMap.animateCamera(CameraUpdateFactory.newLatLng(toulouse.getPosition()));
        //Centrer la carte sur un point + zoom
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(toulouse.getPosition(),12));



        refreshScreen();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        refreshScreen();
    }

    public void refreshScreen(){



        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
        mMap.clear();

        for (list:) {

        }

    }


}
