package com.example.fray_rentacar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        getSupportActionBar().hide();

        //Inicializando y asignando variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Ajustes seleccionado
        bottomNavigationView.setSelectedItemId(R.id.navigation_config);

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
                        startActivity(new Intent(getApplicationContext(), Sucursales.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.navigation_config:
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

    public void Perfil(View view) {
        Intent intent = new Intent(Ajustes.this, Perfil.class);
        startActivity(intent);
    }

    public void AyudaYAsistencia(View view) {
        Intent intent = new Intent(Ajustes.this, AyudaYAsistencia.class);
        startActivity(intent);
    }

    public void CerrarSesion(View view) {
        TimerTask home = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Ajustes.this, IniciarSesion.class);
                startActivity(intent);
                finish();
            }
        };

        Toast.makeText(getApplicationContext(), "Cerrando sesión...", Toast.LENGTH_SHORT).show();

        Timer tiempo = new Timer();
        tiempo.schedule(home, 1700);
    }


}