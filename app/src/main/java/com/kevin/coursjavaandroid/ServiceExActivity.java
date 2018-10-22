package com.kevin.coursjavaandroid;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kevin.coursjavaandroid.services.MyService;
import com.squareup.otto.Subscribe;

public class ServiceExActivity extends AppCompatActivity {


    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_ex);

        tv = findViewById(R.id.tv);

        MyApplication.getBus().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //On arrete de lire le bus pour que l garbage collector puisse la détruire
        MyApplication.getBus().unregister(this);
    }

    /* ---------------------------------
    //  Click
    // -------------------------------- */

    public void onClick(View view) {
        if (view.getId() == R.id.btStart) {
            startService(new Intent(this, MyService.class));
        }
        else if (view.getId() == R.id.btStop) {
            stopService(new Intent(this, MyService.class));
        }
    }

    /* ---------------------------------
    // Otto
    // -------------------------------- */

    //La méthode peut prendre n'impoorte quel nom, c'est le parametre qui va indiquer ce qu'on lit dans le bus
    @Subscribe
    public void receptionBus(Location location) {
        tv.setText(location.toString());
    }
}
