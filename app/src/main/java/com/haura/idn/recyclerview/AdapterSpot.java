package com.haura.idn.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class AdapterSpot extends RecyclerView.Adapter<AdapterSpot.ViewHolder>  {

    Context context;
    String[] nameSpot,descriptionSpot;
    int[] photoSpot;

    public AdapterSpot(Context context, String[] nameSpot, String[] descriptionSpot, int[] photoSpot) {
        this.context = context;
        this.nameSpot = nameSpot;
        this.descriptionSpot = descriptionSpot;
        this.photoSpot = photoSpot;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_spot,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvName.setText(nameSpot[i]);
        viewHolder.tvDescription.setText(descriptionSpot[i]);
        Glide.with(context).load(photoSpot[i]).into(viewHolder.imgSpot);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailSpot.class);
                intent.putExtra("name_spot", nameSpot[i]);
                intent.putExtra("description_spot",descriptionSpot[i]);
                intent.putExtra("photo_spot",photoSpot[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return photoSpot.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvDescription,tvPlace;
        ImageView imgSpot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            imgSpot = itemView.findViewById(R.id.img_item_photo);
        }
    }


}


