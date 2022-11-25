package com.example.fray_rentacar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Sucursales extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucursales);

        getSupportActionBar().hide();

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        supportMapFragment.getMapAsync(this);

        //Inicializando y asignando variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Sucursales seleccionado
        bottomNavigationView.setSelectedItemId(R.id.navigation_branches);

        //Colocando el listener para los botones del navegador inferior
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_rents:
                        startActivity(new Intent(getApplicationContext(), Alquileres.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.navigation_branches:
                        return true;
                    case R.id.navigation_config:
                        startActivity(new Intent(getApplicationContext(), Ajustes.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);  // "Hide" your current Activity
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}