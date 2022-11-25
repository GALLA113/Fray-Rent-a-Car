package com.example.fray_rentacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Email extends AppCompatActivity {

    TextInputLayout tilCorreo;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        getSupportActionBar().hide();


        tilCorreo = (TextInputLayout) findViewById(R.id.tilCorreo);
        preferences = getSharedPreferences("Cuenta",0);
        String emailRegistrado = preferences.getString("correo", "");
        tilCorreo.getEditText().setText(emailRegistrado);
    }

    public void Regresar(View view) {
        finish();
    }

    public void Aplicar(View view) {
        String correo = tilCorreo.getEditText().getText().toString();
        preferences = getSharedPreferences("Cuenta",0);
        String emailRegistrado = preferences.getString("correo", "");

        if(correo.isEmpty()){
            AlertDialog.Builder mensaje = new AlertDialog.Builder(Email.this);
            mensaje.setMessage("Rellene el campo para aplicar el cambio")
                    .setTitle("Error")
                    .setPositiveButton("OK", null);
            mensaje.setCancelable(false);
            mensaje.create();
            mensaje.show();
        }else{
            if(!correo.equals(emailRegistrado)){
                if(correo.contains("@")){
                    AlertDialog.Builder confirmacion = new AlertDialog.Builder(Email.this);
                    confirmacion.setMessage("Su nuevo correo será: '" + correo + "'  ¿Desea continuar?");
                    confirmacion.setCancelable(false);
                    confirmacion.setTitle("Correo electronico");
                    confirmacion.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            Toast.makeText(getApplicationContext(), "Correo electronico actualizado", Toast.LENGTH_SHORT).show();
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
                    AlertDialog.Builder mensaje = new AlertDialog.Builder(Email.this);
                    mensaje.setMessage("¡Algo salio mal! Verifique que su correo sea valido")
                            .setTitle("Error")
                            .setPositiveButton("OK", null);
                    mensaje.setCancelable(false);
                    mensaje.create();
                    mensaje.show();
                }
            }
            else
            {
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Email.this);
                mensaje.setMessage("Agregue un nuevo correo para aplicar el cambio")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            }
        }
    }
}