package com.example.fray_rentacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Registrarse extends AppCompatActivity {

    TextInputLayout tilNombreCompleto, tilNombreDeUsuario, tilCorreoElectronico, tilTelefono, tilContraseña, tilConfirmarContraseña;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        getSupportActionBar().hide();

        tilNombreCompleto = (TextInputLayout) findViewById(R.id.tilNombreCompleto);
        tilNombreDeUsuario = (TextInputLayout) findViewById(R.id.tilNombreDeUsuario);
        tilCorreoElectronico = (TextInputLayout) findViewById(R.id.tilCorreoElectronico);
        tilTelefono = (TextInputLayout) findViewById(R.id.tilTelefono);
        tilContraseña = (TextInputLayout) findViewById(R.id.tilContraseña);
        tilConfirmarContraseña = (TextInputLayout) findViewById(R.id.tilConfirmarContraseña);

        preferences = getSharedPreferences("Cuenta",0);

    }

    public void RegistrarUsuario(View view) {
        String nombre = tilNombreCompleto.getEditText().getText().toString();
        String usuario = tilNombreDeUsuario.getEditText().getText().toString();
        String email = tilCorreoElectronico.getEditText().getText().toString();
        String tel = tilTelefono.getEditText().getText().toString();
        String contra = tilContraseña.getEditText().getText().toString();
        String confContra = tilConfirmarContraseña.getEditText().getText().toString();

        if (nombre.isEmpty() || usuario.isEmpty() || email.isEmpty() || tel.isEmpty() || contra.isEmpty() || confContra.isEmpty()) {
            AlertDialog.Builder mensaje = new AlertDialog.Builder(Registrarse.this);
            mensaje.setMessage("Rellene todos los campos para completar el registro")
                    .setTitle("Error")
                    .setPositiveButton("OK", null);
            mensaje.setCancelable(false);
            mensaje.create();
            mensaje.show();
        } else {
            if (nombre.length() < 3) {
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Registrarse.this);
                mensaje.setMessage("El nombre debe contener almenos 3 caracteres minimo")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            } else if (usuario.length() < 4) {
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Registrarse.this);
                mensaje.setMessage("El usuario debe contener almenos 4 caracteres minimo")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            } else if (!email.contains("@")) {
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Registrarse.this);
                mensaje.setMessage("Digite un email veridico")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            } else if (tel.length() < 8) {
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Registrarse.this);
                mensaje.setMessage("Digite un número de telefono veridico")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            } else if (contra.length() < 8 && confContra.length() < 8) {
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Registrarse.this);
                mensaje.setMessage("La contraseña debe ser de almenos 8 caracteres")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            } else if (!contra.equals(confContra)) {
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Registrarse.this);
                mensaje.setMessage("La contraseña debe ser similar para poder confirmarse")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            } else {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nombre", nombre);
                editor.putString("usuario", usuario);
                editor.putString("correo", email);
                editor.putString("telefono", tel);
                editor.putString("contraseña", contra);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Cuenta registrada", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}