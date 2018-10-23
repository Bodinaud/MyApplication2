package com.kevin.coursjavaandroid.list;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import com.kevin.coursjavaandroid.R;
import com.kevin.coursjavaandroid.model.bean.EleveBean;


public class RVExActivity extends AppCompatActivity implements EleveAdapter.OnEleveAdapterListener {

    //Composants graphiques
    private RecyclerView rv;

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

    public void onClick(View view) {

        if (view.getId() == R.id.btAdd) {
            maList.add(0, new EleveBean("toto" + maList.size(), "toto"));
            eleveAdapter.notifyItemInserted(0);

            //Remettre le scroll au début
            rv.scrollToPosition(0);
        }
        else if (view.getId() == R.id.btAddLot) {
            for (int i = 0; i < 100; i++) {
                maList.add(new EleveBean("toto" + maList.size(), "toto"));
            }
            eleveAdapter.notifyDataSetChanged();
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

    }
}