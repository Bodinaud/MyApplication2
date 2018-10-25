package com.kevin.coursjavaandroid;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kevin.coursjavaandroid.transverse.NotificationUtils;

public class CodePostalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_postal);
    }


       /* ---------------------------------
    //  Click
    // -------------------------------- */

    public void onClick(View view) {
        if (view.getId() == R.id.btOk) {
            Log.w("TAG1","ok");
            Toast.makeText(this, "Haahahahahahahah putainn de bordel ca marche!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
