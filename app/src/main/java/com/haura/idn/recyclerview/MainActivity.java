package com.haura.idn.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvSpot;
    String[] nameSpot;
    String[] descriptionSpot;

    int[] photoSpot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSpot = findViewById(R.id.rv_spot);

        nameSpot = getResources().getStringArray(R.array.spot_name);
        descriptionSpot = getResources().getStringArray(R.array.spot_description);

        photoSpot = new int[] {R.drawable.spot1, R.drawable.spot2,R.drawable.spot3,R.drawable.spot4,R.drawable.spot5,
                R.drawable.spot6, R.drawable.spot7};


        AdapterSpot adapterSpot = new AdapterSpot(MainActivity.this,nameSpot,descriptionSpot,photoSpot);

        rvSpot.setHasFixedSize(true);
        rvSpot.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvSpot.setAdapter(adapterSpot);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.grid_menu:
                grid();
                break;
        }

    }

    private void grid() {
        Intent intent = new Intent(getApplicationContext(),GridSpot.class);
        startActivity(intent);
    }

}
