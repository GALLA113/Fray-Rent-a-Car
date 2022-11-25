package com.example.fray_rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuscarAlquiler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_alquiler);

        getSupportActionBar().hide();


    }

    public void EstablecerFecha(View view) {
        Intent intent = new Intent(BuscarAlquiler.this, FechaDeReservacion.class);
        startActivity(intent);
    }

    public void Regresar(View view) {
        Intent intent = new Intent(BuscarAlquiler.this, Alquileres.class);
        startActivity(intent);
        finish();
    }
}