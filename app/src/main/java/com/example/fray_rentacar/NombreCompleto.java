package com.example.fray_rentacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NombreCompleto extends AppCompatActivity {

    TextInputLayout tilNombre;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_completo);

        getSupportActionBar().hide();

        tilNombre = (TextInputLayout) findViewById(R.id.tilNombre);
        preferences = getSharedPreferences("Cuenta",0);
        String nombreRegistrado = preferences.getString("nombre", "");
        tilNombre.getEditText().setText(nombreRegistrado);
    }

    public void Regresar(View view) {
        finish();
    }

    public void Aplicar(View view) {
        String nombre = tilNombre.getEditText().getText().toString();
        preferences = getSharedPreferences("Cuenta",0);
        String nombreRegistrado = preferences.getString("nombre", "");

        if(nombre.isEmpty()){
            AlertDialog.Builder mensaje = new AlertDialog.Builder(NombreCompleto.this);
            mensaje.setMessage("Rellene el campo para aplicar el cambio")
                    .setTitle("Error")
                    .setPositiveButton("OK", null);
            mensaje.setCancelable(false);
            mensaje.create();
            mensaje.show();
        }
        else{
            if(!nombre.equals(nombreRegistrado)){
                if(nombre.length() > 3){
                    AlertDialog.Builder confirmacion = new AlertDialog.Builder(NombreCompleto.this);
                    confirmacion.setMessage("Su nuevo nombre será: '" + nombre + "'  ¿Desea continuar?");
                    confirmacion.setCancelable(false);
                    confirmacion.setTitle("Nombre completo");
                    confirmacion.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            Toast.makeText(getApplicationContext(), "Nombre actualizado", Toast.LENGTH_SHORT).show();
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
                    AlertDialog.Builder mensaje = new AlertDialog.Builder(NombreCompleto.this);
                    mensaje.setMessage("¡Algo salio mal! Acate los puntos mencionados")
                            .setTitle("Error")
                            .setPositiveButton("OK", null);
                    mensaje.setCancelable(false);
                    mensaje.create();
                    mensaje.show();
                }
            }
            else{
                AlertDialog.Builder mensaje = new AlertDialog.Builder(NombreCompleto.this);
                mensaje.setMessage("Agregue un nuevo nombre para aplicar el cambio")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            }
        }
    }
}