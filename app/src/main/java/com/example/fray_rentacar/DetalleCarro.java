package com.example.fray_rentacar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetalleCarro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_carro);

        getSupportActionBar().hide();

        //Inicializando y asignando variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Home seleccionado
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

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

    public void Buscar(View view) {
        Intent intent = new Intent(DetalleCarro.this, BuscarAlquiler.class);
        startActivity(intent);
    }

}