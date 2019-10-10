package com.haura.idn.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailSpot extends AppCompatActivity {

    TextView tvDetailName,tvDetailDescription;
    ImageView imgDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_spot);


        tvDetailName = findViewById(R.id.detail_item_name);
        tvDetailDescription = findViewById(R.id.detail_item_description);
        imgDetail = findViewById(R.id.detail_item_photo);

        tvDetailName.setText(getIntent().getStringExtra("name_spot"));
        tvDetailDescription.setText(getIntent().getStringExtra("description_spot"));
        Glide.with(this).load(getIntent().getIntExtra("photo_spot",0)).into(imgDetail);
    }
}
