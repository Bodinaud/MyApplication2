package com.kevin.coursjavaandroid;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.TextView;

public class NotificationExActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_ex);

        tv = findViewById(R.id.tv);

        MyApplication.getBus().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //On arrete de lire le bus pour que l garbage collector puisse la détruire
        MyApplication.getBus().unregister(this);
    }


}
