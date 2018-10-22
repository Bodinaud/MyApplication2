package com.kevin.coursjavaandroid.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.coursjavaandroid.R;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {//3
//Classe qui stocke les composants graphiques d'1 ligne
        protected static class ViewHolder extends RecyclerView.ViewHolder {//2
            TextView tv_nom, tv_prenom;
            ImageView iv;
            public ViewHolder(View itemView) {
                super(itemView);
                tv_nom = itemView.findViewById(R.id.tv_nom);
                tv_prenom = itemView.findViewById(R.id.tv_prenom);
                iv = itemView.findViewById(R.id.iv);
            }
        }

    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup vg, int viewType) {
        return null;
    }

    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {

    }

    public int getItemCount() {
        return 0;
    }
}

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
