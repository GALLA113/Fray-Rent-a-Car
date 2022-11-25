package com.example.fray_rentacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Timer;
import java.util.TimerTask;

public class IniciarSesion extends AppCompatActivity {

    TextInputLayout til_is_usuario, til_is_contra;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        getSupportActionBar().hide();

        til_is_usuario = (TextInputLayout) findViewById(R.id.til_IS_Usuario);
        til_is_contra = (TextInputLayout) findViewById(R.id.til_IS_Contra);

        preferences = getSharedPreferences("Cuenta",0);

    }

    public void Registrarse(View view) {
        Intent intent = new Intent(IniciarSesion.this, Registrarse.class);
        startActivity(intent);
    }

    @SuppressLint("NotConstructor")
    public void IniciarSesion(View view) {
        String usuario = til_is_usuario.getEditText().getText().toString();
        String contra = til_is_contra.getEditText().getText().toString();

        String usuarioRegistrado = preferences.getString("usuario", "");
        String contraRegistrada = preferences.getString("contraseña", "");

        if(usuario.isEmpty() || contra.isEmpty()){
            AlertDialog.Builder mensaje = new AlertDialog.Builder(IniciarSesion.this);
            mensaje.setMessage("Rellene todos los campos para iniciar sesión")
                    .setTitle("Error")
                    .setPositiveButton("OK", null);
            mensaje.setCancelable(false);
            mensaje.create();
            mensaje.show();
        }
        else{
            if(usuario.length() < 4){
                AlertDialog.Builder mensaje = new AlertDialog.Builder(IniciarSesion.this);
                mensaje.setMessage("Nombre de usuario no valido")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            }
            else if(contra.length() < 8){
                AlertDialog.Builder mensaje = new AlertDialog.Builder(IniciarSesion.this);
                mensaje.setMessage("Contraseña no valida")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            }
            else{
                if(usuario.equals(usuarioRegistrado) && contra.equals(contraRegistrada)){
                    TimerTask home = new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(IniciarSesion.this, Home.class);
                            startActivity(intent);
                            finish();
                        }
                    };

                    Toast.makeText(getApplicationContext(), "Iniciando Sesión", Toast.LENGTH_SHORT).show();

                    Timer tiempo = new Timer();
                    tiempo.schedule(home, 1700);
                }
                else{
                    AlertDialog.Builder mensaje = new AlertDialog.Builder(IniciarSesion.this);
                    mensaje.setMessage("Datos no validos. Por favor verifique de nuevo")
                            .setTitle("Error")
                            .setPositiveButton("OK", null);
                    mensaje.setCancelable(false);
                    mensaje.create();
                    mensaje.show();
                }
            }
        }

    }

    public void ContraOlvidada(View view) {
        Intent intent = new Intent(IniciarSesion.this, ContraOlvidada.class);
        startActivity(intent);
    }
}