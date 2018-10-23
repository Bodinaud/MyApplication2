package com.kevin.coursjavaandroid.list;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

import com.kevin.coursjavaandroid.R;
import com.kevin.coursjavaandroid.model.bean.EleveBean;

public class EleveAdapter extends RecyclerView.Adapter<EleveAdapter.ViewHolder> {

    private ArrayList<EleveBean> malist;
    private OnEleveAdapterListener onEleveAdapterListener;

    public EleveAdapter(ArrayList<EleveBean> malist) {
        this.malist = malist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNom;
        TextView tvPrenom;
        ImageView iv;
        View root;

        public ViewHolder(View v) {
            super(v);
            tvNom = v.findViewById(R.id.tvNom);
            tvPrenom = v.findViewById(R.id.tvPrenom);
            iv = v.findViewById(R.id.iv);
            root = v.findViewById(R.id.root);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_eleve, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final EleveBean eleveBean = malist.get(position);

        viewHolder.tvNom.setText(eleveBean.getNom());
        viewHolder.tvPrenom.setText(eleveBean.getPrenom());

        Glide.with(viewHolder.iv.getContext()).load("http://clamart-lafontaine-blog.e-monsite.com/medias/images/eleve.png").into(viewHolder.iv);

        viewHolder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onEleveAdapterListener != null) {
                    onEleveAdapterListener.onEleveClic(eleveBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return malist.size();
    }

    /* ---------------------------------
    // interface
    // -------------------------------- */

    public interface OnEleveAdapterListener {
        void onEleveClic(EleveBean eleveBean);

        void onEleveLongClick(EleveBean eleveBean);
    }

    /* ---------------------------------
    // GETTER / SETTER
    // -------------------------------- */

    public void setOnEleveAdapterListener(OnEleveAdapterListener onEleveAdapterListener) {
        this.onEleveAdapterListener = onEleveAdapterListener;
    }
}