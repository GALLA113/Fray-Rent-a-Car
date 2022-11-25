package com.example.fray_rentacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Password extends AppCompatActivity {

    TextInputLayout tilContraseña, tilCContraseña;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        getSupportActionBar().hide();

        tilContraseña = (TextInputLayout) findViewById(R.id.tilContraseña);
        tilCContraseña = (TextInputLayout) findViewById(R.id.tilCContraseña);
        preferences = getSharedPreferences("Cuenta",0);
        String contraRegistrada = preferences.getString("contraseña", "");
        tilContraseña.getEditText().setText(contraRegistrada);
    }

    public void Regresar(View view) {
        finish();
    }

    public void Aplicar(View view) {
        String contraseña = tilContraseña.getEditText().getText().toString();
        String Ccontraseña = tilCContraseña.getEditText().getText().toString();
        preferences = getSharedPreferences("Cuenta",0);
        String contraRegistrada = preferences.getString("contraseña", "");

        if(contraseña.isEmpty() || Ccontraseña.isEmpty())
        {
            AlertDialog.Builder mensaje = new AlertDialog.Builder(Password.this);
            mensaje.setMessage("Ingrese su nueva contraseña en los campos indicados")
                    .setTitle("Error")
                    .setPositiveButton("OK", null);
            mensaje.setCancelable(false);
            mensaje.create();
            mensaje.show();
        }
        else {
            if(!contraseña.equals(contraRegistrada) && !Ccontraseña.equals(contraRegistrada)){
                if (contraseña.length() >= 8 && Ccontraseña.length() >= 8) {
                    if (contraseña.equals(Ccontraseña)) {
                        AlertDialog.Builder confirmacion = new AlertDialog.Builder(Password.this);
                        confirmacion.setMessage("Esta a punto de modificar su contraseña. ¿Desea continuar?");
                        confirmacion.setCancelable(false);
                        confirmacion.setTitle("Contraseña");
                        confirmacion.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                Toast.makeText(getApplicationContext(), "Contraseña modificada", Toast.LENGTH_SHORT).show();
                            }
                        });
                        confirmacion.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        confirmacion.create();
                        confirmacion.show();
                    } else {
                        AlertDialog.Builder mensaje = new AlertDialog.Builder(Password.this);
                        mensaje.setMessage("La contraseña debe ser similar en ambos campos")
                                .setTitle("Error")
                                .setPositiveButton("OK", null);
                        mensaje.setCancelable(false);
                        mensaje.create();
                        mensaje.show();
                    }
                } else {
                    AlertDialog.Builder mensaje = new AlertDialog.Builder(Password.this);
                    mensaje.setMessage("¡Algo salio mal! Acate los puntos mencionados")
                            .setTitle("Error")
                            .setPositiveButton("OK", null);
                    mensaje.setCancelable(false);
                    mensaje.create();
                    mensaje.show();
                }
            }
            else{
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Password.this);
                mensaje.setMessage("Agregue una nueva contraseña para aplicar el cambio")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            }
        }
    }
}