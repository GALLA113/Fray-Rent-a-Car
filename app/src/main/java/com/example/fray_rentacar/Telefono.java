package com.example.fray_rentacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Telefono extends AppCompatActivity {

    TextInputLayout tilTelefono;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);

        getSupportActionBar().hide();

        tilTelefono = (TextInputLayout) findViewById(R.id.tilTelefono);
        preferences = getSharedPreferences("Cuenta",0);
        String telefonoRegistrado = preferences.getString("telefono", "");
        tilTelefono.getEditText().setText(telefonoRegistrado);
    }

    public void Regresar(View view) {
        finish();
    }

    public void Aplicar(View view) {
        String telefono = tilTelefono.getEditText().getText().toString();
        preferences = getSharedPreferences("Cuenta",0);
        String telefonoRegistrado = preferences.getString("telefono", "");

        if(telefono.isEmpty()){
            AlertDialog.Builder mensaje = new AlertDialog.Builder(Telefono.this);
            mensaje.setMessage("Rellene el campo para aplicar el cambio")
                    .setTitle("Error")
                    .setPositiveButton("OK", null);
            mensaje.setCancelable(false);
            mensaje.create();
            mensaje.show();
        }else{
            if(!telefono.equals(telefonoRegistrado)){
                if(telefono.length() == 8){
                    AlertDialog.Builder confirmacion = new AlertDialog.Builder(Telefono.this);
                    confirmacion.setMessage("Su nuevo número será: '" + telefono + "'  ¿Desea continuar?");
                    confirmacion.setCancelable(false);
                    confirmacion.setTitle("Confirmación");
                    confirmacion.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            Toast.makeText(getApplicationContext(), "Número actualizado", Toast.LENGTH_SHORT).show();
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
                    AlertDialog.Builder mensaje = new AlertDialog.Builder(Telefono.this);
                    mensaje.setMessage("Digite un número de teléfono veridico")
                            .setTitle("Error")
                            .setPositiveButton("OK", null);
                    mensaje.setCancelable(false);
                    mensaje.create();
                    mensaje.show();
                }
            }
            else{
                AlertDialog.Builder mensaje = new AlertDialog.Builder(Telefono.this);
                mensaje.setMessage("Agregue un nuevo número para aplicar el cambio")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            }
        }
    }
}