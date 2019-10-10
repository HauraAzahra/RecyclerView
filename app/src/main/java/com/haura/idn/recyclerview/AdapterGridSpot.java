package com.haura.idn.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class AdapterGridSpot extends RecyclerView.Adapter<AdapterGridSpot.ViewHolder>  {

    Context context;
    String[] nameSpot,descriptionSpot;
    int[] photoSpot;

    public AdapterGridSpot(Context context, String[] nameSpot, String[] descriptionSpot, int[] photoSpot) {
        this.context = context;
        this.nameSpot = nameSpot;
        this.descriptionSpot = descriptionSpot;
        this.photoSpot = photoSpot;
    }

    @NonNull
    @Override
    public AdapterGridSpot.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_spot,viewGroup,false);
        return new AdapterGridSpot.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGridSpot.ViewHolder viewHolder, final int i) {
        viewHolder.tvName.setText(nameSpot[i]);
        viewHolder.tvDescription.setText(descriptionSpot[i]);
        Glide.with(context).load(photoSpot[i]).into(viewHolder.imgSpot);

    }

    @Override
    public int getItemCount() {
        return photoSpot.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvDescription;
        ImageView imgSpot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_grid_name);
            tvDescription = itemView.findViewById(R.id.tv_item_grid_description);
            imgSpot = itemView.findViewById(R.id.img_item_grid_photo);
        }
    }
}
