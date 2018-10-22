package com.kevin.coursjavaandroid.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.coursjavaandroid.R;
import com.kevin.coursjavaandroid.model.bean.EleveBean;

import java.util.ArrayList;

public class RVExActivity extends AppCompatActivity {

    //Composants graphiques
    private LinearLayout ll;

    //Data
    private ArrayList<EleveBean> maList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvex);
        ll = findViewById(R.id.ll);

        maList = new ArrayList<>();
    }

    public void onClick(View view) {

        if (view.getId() == R.id.bt) {
            maList.add(new EleveBean("Loup" + maList.size(), "Ben"));
            refreshScreen();
        }
        else if (view.getId() == R.id.btAddLot) {
            for (int i = 0; i < 100; i++) {
                maList.add(new EleveBean("Renard" + maList.size(), "Chris"));
            }
            refreshScreen();
        }
    }

    private void refreshScreen() {
        ll.removeAllViews();

        for (EleveBean eleveBean : maList) {
            //Composants graphiques
            View v = LayoutInflater.from(this).inflate(R.layout.row_eleve, null);
            ViewHolder viewHolder = new ViewHolder(v);
            ll.addView(v);

            //remplir
            viewHolder.tvNom.setText(eleveBean.getNom());
            viewHolder.tvPrenom.setText(eleveBean.getPrenom());
        }
    }

    public class ViewHolder {

        TextView tvNom;
        TextView tvPrenom;
        ImageView iv;

        public ViewHolder(View v) {
            tvNom = v.findViewById(R.id.tvNom);
            tvPrenom = v.findViewById(R.id.tvPrenom);
            iv = v.findViewById(R.id.iv);
        }
    }
}
