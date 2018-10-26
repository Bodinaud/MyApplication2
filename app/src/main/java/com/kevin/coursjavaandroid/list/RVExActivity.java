package com.kevin.coursjavaandroid.list;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import com.kevin.coursjavaandroid.R;
import com.kevin.coursjavaandroid.model.ws.WsUtils;
import com.kevin.coursjavaandroid.model.bean.EleveBean;



public class RVExActivity extends AppCompatActivity implements EleveAdapter.OnEleveAdapterListener {

    //Composants graphiques
    private RecyclerView rv;
    private ProgressDialog pd;

    //Outils
    private EleveAdapter eleveAdapter;

    //Data
    private ArrayList<EleveBean> maList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvex);
        rv = findViewById(R.id.rv);
        maList = new ArrayList<>();
        eleveAdapter = new EleveAdapter(maList);
        eleveAdapter.setOnEleveAdapterListener(this);

        rv.setAdapter(eleveAdapter);
        rv.setLayoutManager(new GridLayoutManager(this, 1));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    public void onClick(View view) {

        if (view.getId() == R.id.btAdd) {
            maList.add(0, new EleveBean("toto" + maList.size(), "toto"));
            eleveAdapter.notifyItemInserted(0);

            //Remettre le scroll au début
            rv.scrollToPosition(0);
        }
        else if (view.getId() == R.id.btAddLot) {
            new MonAt().execute();
        }
    }

    @Override
    public void onEleveClic(EleveBean eleveBean) {

        int index = maList.indexOf(eleveBean);
        maList.remove(eleveBean);
        maList.add(0, eleveBean);
        eleveAdapter.notifyItemMoved(index, 0);
    }

    @Override
    public void onEleveLongClick(EleveBean eleveBean) {
        maList.remove(eleveBean);
    }

    public class MonAt extends AsyncTask {

        private EleveBean resultat;
        private Exception exception;

        @Override
        protected Object doInBackground(Object[] objects) {
            //Sur un 2eme thread -> pas de modif graphique
            try {
                resultat = WsUtils.getElevFromWen();
            }
            catch (Exception e) {
                e.printStackTrace();
                exception = e;
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(RVExActivity.this, "", "Chargement en cours...");
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            if (pd != null) {
                pd.dismiss();
                pd = null;
            }

            if (exception != null) {
                //J'ai une erreur je l'indique
                Toast.makeText(RVExActivity.this, "Une erreur est survenue : " + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
            else {
                //j'ai un resultat, je l'ajoute
                maList.add(0, resultat);
                //et je previens l'adapter que les données ont changé.
                eleveAdapter.notifyItemInserted(0);
            }
        }
    }
}