package com.kevin.coursjavaandroid;


        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;

        import com.kevin.coursjavaandroid.transverse.NotificationUtils;

public class NotifExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_ex);
    }



     /* ---------------------------------
    //  Click
    // -------------------------------- */

    public void onClick(View view) {
        if (view.getId() == R.id.btNow) {
            NotificationUtils.createInstantNotification(this, "Un message", 29);
        }
        else if (view.getId() == R.id.bt30s) {
            NotificationUtils.scheduleNotification(this, "Un message à  retardement", 5000);
        }
    }

}
