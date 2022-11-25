package com.example.fray_rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        getSupportActionBar().hide();
    }

    public void Regresar(View view) {
        finish();
    }

    public void Nombre(View view) {
        Intent intent = new Intent(Perfil.this, NombreCompleto.class);
        startActivity(intent);
    }

    public void Usuario(View view) {
        Intent intent = new Intent(Perfil.this, NombreDeUsuario.class);
        startActivity(intent);
    }

    public void Correo(View view) {
        Intent intent = new Intent(Perfil.this, Email.class);
        startActivity(intent);
    }

    public void Telefono(View view) {
        Intent intent = new Intent(Perfil.this, Telefono.class);
        startActivity(intent);
    }

    public void Contraseña(View view) {
        Intent intent = new Intent(Perfil.this, Password.class);
        startActivity(intent);
    }
}