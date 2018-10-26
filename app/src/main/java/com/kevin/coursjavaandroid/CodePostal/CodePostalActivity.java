package com.kevin.coursjavaandroid.CodePostal;

import android.app.Dialog;
import android.app.ProgressDialog;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import com.kevin.coursjavaandroid.R;
import com.kevin.coursjavaandroid.model.ws.WsUtils;
import com.kevin.coursjavaandroid.model.bean.CityBean;


import java.util.ArrayList;

public class CodePostalActivity extends AppCompatActivity implements View.OnClickListener {


    //Composants graphiques
    private Button mBt;
    private RecyclerView mRv;
    private EditText mEt;
    private Dialog dialog;

    //outils
    private CityAdapter cityAdapter;

    //Data
    private ArrayList<CityBean> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_postal);
        mBt = findViewById(R.id.btOk);
        mRv = findViewById(R.id.rv2);
        mEt = findViewById(R.id.etcp);

        mBt.setOnClickListener(this);

        cities = new ArrayList<>();
        cityAdapter = new CityAdapter(cities);

        mRv.setAdapter(cityAdapter);
        mRv.setLayoutManager(new GridLayoutManager(this, 1));
    }



       /* ---------------------------------
    //  Click
    // -------------------------------- */

    @Override
    public void onClick(View v) {
        if (v == mBt) {
            new MonAT().execute();
        }
    }

    public class MonAT extends AsyncTask {

        private ArrayList<CityBean> resultat;
        private Exception exception;

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                resultat = WsUtils.getCitiesFromCp(mEt.getText().toString());
            }
            catch (Exception e) {
                exception = e;
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(CodePostalActivity.this, "", "Chargement en cours");
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            //Si elle existe on la retire et on libère la référence
            if (dialog != null) {
                dialog.dismiss();
                dialog = null;
            }

            if (exception != null) {
                //J'indique l'erreur
                Toast.makeText(CodePostalActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
            }
            else {
                cities.clear();
                cities.addAll(resultat);
                cityAdapter.notifyDataSetChanged();
            }
        }
    }
}
