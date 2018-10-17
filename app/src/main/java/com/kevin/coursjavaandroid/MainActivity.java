package com.kevin.coursjavaandroid;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
            startActivity(new Intent(this, SecondActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,ALERT_DIALOG,0,"AlertDialog");
        menu.add(0,TIME_PICKER,0,"timePicker");
        menu.add(0,DATE_PIKER,0,"datePicker");

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
}

        return super.onOptionsItemSelected(item);
    }




}
