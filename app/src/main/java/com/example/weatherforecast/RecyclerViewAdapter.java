package com.example.weatherforecast;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.weatherforecast.model.RecyclerData;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<RecyclerData> listData;

    public void setListData(List<RecyclerData> listData){
        this.listData= listData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.tvTitle.setText((listData.get(position).getDt()));
        holder.temp_max.setText(listData.get(position).getMain().getTemp_max()+" F");
        holder.temp_min.setText(listData.get(position).getMain().getTemp_min()+" F");
    }

    @Override
    public int getItemCount() {
        if(listData== null){
            return 0;
        }
        else
        return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, temp_min, temp_max;

        public MyViewHolder(View view){
            super(view);

            tvTitle= view.findViewById(R.id.dt_txt);
            temp_max= view.findViewById(R.id.temp_max);
            temp_min= view.findViewById(R.id.temp_min);
        }
    }
}
