package com.example.fray_rentacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class NombreDeUsuario extends AppCompatActivity {

    TextInputLayout tilUsuario;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_de_usuario);

        getSupportActionBar().hide();

        tilUsuario = (TextInputLayout) findViewById(R.id.tilUsuario);
        preferences = getSharedPreferences("Cuenta",0);
        String usuarioRegistrado = preferences.getString("usuario", "");
        tilUsuario.getEditText().setText(usuarioRegistrado);
    }

    public void Regresar(View view) {
        finish();
    }

    public void Aplicar(View view) {
        String usuario = tilUsuario.getEditText().getText().toString();
        preferences = getSharedPreferences("Cuenta",0);
        String usuarioRegistrado = preferences.getString("usuario", "");

        if(usuario.isEmpty()){
            AlertDialog.Builder mensaje = new AlertDialog.Builder(NombreDeUsuario.this);
            mensaje.setMessage("Rellene el campo para aplicar el cambio")
                    .setTitle("Error")
                    .setPositiveButton("OK", null);
            mensaje.setCancelable(false);
            mensaje.create();
            mensaje.show();
        }else{
            if(!usuario.equals(usuarioRegistrado)){
                if(usuario.length() > 3){
                    AlertDialog.Builder confirmacion = new AlertDialog.Builder(NombreDeUsuario.this);
                    confirmacion.setMessage("Su nuevo nombre de usuario será: '" + usuario + "'  ¿Desea continuar?");
                    confirmacion.setCancelable(false);
                    confirmacion.setTitle("Nombre de usuario");
                    confirmacion.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            Toast.makeText(getApplicationContext(), "Nombre de usuario actualizado", Toast.LENGTH_SHORT).show();
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
                }
                else
                {
                    AlertDialog.Builder mensaje = new AlertDialog.Builder(NombreDeUsuario.this);
                    mensaje.setMessage("¡Algo salio mal! Acate los puntos mencionados")
                            .setTitle("Error")
                            .setPositiveButton("OK", null);
                    mensaje.setCancelable(false);
                    mensaje.create();
                    mensaje.show();
                }
            }
            else
            {
                AlertDialog.Builder mensaje = new AlertDialog.Builder(NombreDeUsuario.this);
                mensaje.setMessage("Agregue un nuevo usuario para aplicar el cambio")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            }
        }


    }
}