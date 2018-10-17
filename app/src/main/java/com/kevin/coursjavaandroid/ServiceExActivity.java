package com.kevin.coursjavaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kevin.coursjavaandroid.services.MyService;

public class ServiceExActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_service_ex);


        }



        public void onClick(View view) {
            if(view.getId() == R.id.btStart) {
                startService(new Intent(this, MyService.class));
            }
            else if(view.getId() == R.id.btStop){
                stopService(new Intent(this, MyService.class));
            }
        }
    }

