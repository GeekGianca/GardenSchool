package com.geekprogrammer.schoolgarden;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

class PropertiesAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView name;
    public TextView scienceName;
    public ImageView image;
    private ItemClickListener itemClickListener;

    public PropertiesAdapter(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        scienceName = itemView.findViewById(R.id.nameScience);
        image = itemView.findViewById(R.id.img);
        itemView.setOnClickListener(this);
    }

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}

public class AdapterViewHolder extends RecyclerView.Adapter<PropertiesAdapter> {

    private List<Plant> plantList = new ArrayList<>();
    private Context context;

    public AdapterViewHolder(List<Plant> plantList, Context context) {
        this.plantList = plantList;
        this.context = context;
    }

    @NonNull
    @Override
    public PropertiesAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(context);
        View itemView = inflate.inflate(R.layout.item_properties, parent, false);
        return new PropertiesAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertiesAdapter holder, int position) {
        holder.name.setText(plantList.get(position).getName());
        holder.scienceName.setText(plantList.get(position).getScienceName());
        holder.image.setImageResource(plantList.get(position).getResource());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }
}
