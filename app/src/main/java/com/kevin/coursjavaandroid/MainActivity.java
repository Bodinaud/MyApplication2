package com.kevin.coursjavaandroid;


import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.kevin.coursjavaandroid.CodePostal.CodePostalActivity;
import com.kevin.coursjavaandroid.list.RVExActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private Button btAnnuler;
    private RadioButton rbJaime;
    private Button btValider;
    private ImageView iv;
    private RadioButton rbJaimePas;
    private EditText et;
    private RadioGroup rg;
    private Button btNext;
    private final static int ALERT_DIALOG = 1;
    private final static int TIME_PICKER = 2;
    private final static int DATE_PIKER = 3;
    private static final int MENU_SERVICE_EX = 4;
    private static final int MENU_NOTIF_EX = 5;
    private static final int MENU_RV_EX = 6;
    private static final int MENU_WEB_SERVICE = 7;

    private static final int REQ_CODE_TO_SERV = 1;

    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAnnuler = findViewById(R.id.btAnnuler);
        rbJaime = findViewById(R.id.rbJaime);
        btValider = findViewById(R.id.btValider);
        iv = findViewById(R.id.iv);
        rbJaimePas = findViewById(R.id.rbJaimePas);

        et = findViewById(R.id.et);
        rg = findViewById(R.id.rg);
        btNext = findViewById(R.id.btNext);

        btNext.setOnClickListener(this);
        btValider.setOnClickListener(this);
        btAnnuler.setOnClickListener(this);



        //  Intent intent = new Intent(this, SecondActivity.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,ALERT_DIALOG,0,"AlertDialog");
        menu.add(0,TIME_PICKER,0,"timePicker");
        menu.add(0,DATE_PIKER,0,"datePicker");
        menu.add(0, MENU_SERVICE_EX, 0, "Service Ex");
        menu.add(0, MENU_NOTIF_EX, 0, "Notif Ex");
        menu.add(0, MENU_RV_EX, 0, "RecyclerView Ex");
        menu.add(0, MENU_WEB_SERVICE, 0, "Web Service");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case ALERT_DIALOG:
                //Préparation de la fenêtre
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//Message
                alertDialogBuilder.setMessage("Mon message");
//titre
                alertDialogBuilder.setTitle("Mon titre");
//bouton ok
                alertDialogBuilder.setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
//Affiche un toast apres le click sur le bouton ok
                                Toast.makeText(MainActivity.this, "Click sur ok",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
//Icone
                alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
//Afficher la fenêtre
                alertDialogBuilder.show();
                break;

            case TIME_PICKER:
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, 14, 33, true);
                timePickerDialog.show();
                break;

            case DATE_PIKER:
                //Gestion de la date
                Calendar calendar = Calendar.getInstance();
//Création de la fenêtre
//Pour le callback -> Alt+entree -> implémente méthode -> Génère la méthode onTimeSet
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, this,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
//Afficher la fenêtre
                datePickerDialog.show();
                break;

            case  MENU_SERVICE_EX:
                //Est ce que j'ai la permission
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //oui je vais sur l'écran
                    startActivity(new Intent(this, ServiceExActivity.class));
                }
                else {
                    //Demande la permission
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, REQ_CODE_TO_SERV );
                }
                break;

            case MENU_NOTIF_EX:
                //Est ce que j'ai la permission
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //oui je vais sur l'écran
                    startActivity(new Intent(this, NotifExActivity.class));
                }
                else {
                    //Demande la permission
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, REQ_CODE_TO_SERV );
                }
                break;

            case    MENU_RV_EX:
                startActivity(new Intent(this, RVExActivity.class));

                break;

            case MENU_WEB_SERVICE:
                startActivity(new Intent(this, CodePostalActivity.class));

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQ_CODE_TO_SERV) {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                //oui je vais sur l'écran
                Toast.makeText(this, " autoriser", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ServiceExActivity.class));
            }
            else {
                //Demande la permission
                Toast.makeText(this, " permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /* ---------------------------------
   //Onclick
   // -------------------------------- */

    @Override
    public void onClick(View v) {

        if (btValider == v) {
            if (rbJaime.isChecked()) {
                et.setText(rbJaime.getText());
            }
            else if (rbJaimePas.isChecked()) {
                et.setText(rbJaimePas.getText());
                Toast.makeText(this, "Cliquer", Toast.LENGTH_SHORT).show();
            }
            iv.setImageResource(R.mipmap.ic_done);
            iv.setColorFilter(getResources().getColor(R.color.colorAccent));
        }
        else if (btAnnuler == v) {
            rg.clearCheck();
            et.setText("");
            iv.setImageResource(R.mipmap.ic_delete_forever);
        }
        else if (btNext == v){
            startActivity(new Intent(this, MainActivity.class));
        }
    }




    /* ---------------------------------
   //   CallBack
   // -------------------------------- */

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, hourOfDay +":" + minute, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar calendar= Calendar.getInstance();
        calendar.set(year,month,dayOfMonth);
        String dateString  = format.format(calendar.getTime());

        Toast.makeText(this, dateString, Toast.LENGTH_SHORT).show();
    }


}
