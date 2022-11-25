package com.example.fray_rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FechaDeReservacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_de_reservacion);

        getSupportActionBar().hide();
    }

    public void Cancelar(View view) {
        finish();
    }

    public void Confirmar(View view) {
        finish();
    }
}