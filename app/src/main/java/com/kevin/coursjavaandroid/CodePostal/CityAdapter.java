package com.kevin.coursjavaandroid.CodePostal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.coursjavaandroid.R;
import com.kevin.coursjavaandroid.model.bean.CityBean;

import java.util.ArrayList;

public class CityAdapter
        extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private ArrayList<CityBean> list;

    public CityAdapter(ArrayList<CityBean> list) {

        this.list = list;
    }

    //Le View Holder correspond au XML row_student
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvcp, tvnom;

        public ViewHolder(View itemView) {
            super(itemView);
            tvcp = itemView.findViewById(R.id.tvcp);
            tvnom = itemView.findViewById(R.id.tvnom);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CityBean data = list.get(position);
        holder.tvcp.setText(data.getCp());
        holder.tvnom.setText(data.getVille());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}