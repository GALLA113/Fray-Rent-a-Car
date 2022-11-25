package com.example.fray_rentacar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Alquileres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alquileres);

        getSupportActionBar().hide();

        //Inicializando y asignando variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Alquileres seleccionado
        bottomNavigationView.setSelectedItemId(R.id.navigation_rents);

        //Colocando el listener para los botones del navegador inferior
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_rents:
                        return true;
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.navigation_branches:
                        startActivity(new Intent(getApplicationContext(), Sucursales.class));
                        overridePendingTransition(0,0);
                        finish();
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

    public void Añadir(View view) {
        Intent intent = new Intent(Alquileres.this, BuscarAlquiler.class);
        startActivity(intent);
    }
}