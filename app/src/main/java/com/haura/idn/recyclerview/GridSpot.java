package com.haura.idn.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GridSpot extends AppCompatActivity {

    RecyclerView rvSpot;
    String[] nameSpot;
    String[] descriptionSpot;

    int[] photoSpot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_spot);

        rvSpot = findViewById(R.id.rv_grid_spot);

        nameSpot = getResources().getStringArray(R.array.spot_name);
        descriptionSpot = getResources().getStringArray(R.array.spot_description);

        photoSpot = new int[]{R.drawable.spot1, R.drawable.spot2, R.drawable.spot3, R.drawable.spot4, R.drawable.spot5,
                R.drawable.spot6, R.drawable.spot7};

        AdapterGridSpot gridSpot = new AdapterGridSpot(GridSpot.this, nameSpot, descriptionSpot, photoSpot);

        rvSpot.setHasFixedSize(true);
        rvSpot.setLayoutManager(new GridLayoutManager(GridSpot.this, 2));
        rvSpot.setAdapter(gridSpot);
    }

}
