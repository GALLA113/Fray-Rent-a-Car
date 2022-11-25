package com.example.fray_rentacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ContraOlvidada extends AppCompatActivity {

    TextInputLayout til_CO_Correo;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contra_olvidada);

        getSupportActionBar().hide();

        til_CO_Correo = (TextInputLayout) findViewById(R.id.til_CO_Correo);
        preferences = getSharedPreferences("Cuenta",0);
    }

    public void Cancelar(View view) {
        finish();
    }

    public void RecuperarContra(View view) {
        String correo = til_CO_Correo.getEditText().getText().toString();

        String correoRegistrado = preferences.getString("correo", "");

        if(correo.isEmpty()){
            AlertDialog.Builder mensaje = new AlertDialog.Builder(ContraOlvidada.this);
            mensaje.setMessage("Llene el campo para realizar la recuperación")
                    .setTitle("Error")
                    .setPositiveButton("OK", null);
            mensaje.setCancelable(false);
            mensaje.create();
            mensaje.show();
        }
        else{
            if(!correo.contains("@")){
                AlertDialog.Builder mensaje = new AlertDialog.Builder(ContraOlvidada.this);
                mensaje.setMessage("Digite un correo valido")
                        .setTitle("Error")
                        .setPositiveButton("OK", null);
                mensaje.setCancelable(false);
                mensaje.create();
                mensaje.show();
            }
            else{
                if(!correo.equals(correoRegistrado)){
                    AlertDialog.Builder mensaje = new AlertDialog.Builder(ContraOlvidada.this);
                    mensaje.setMessage("El correo parece no ser valido. Intente de nuevo")
                            .setTitle("Error")
                            .setPositiveButton("OK", null);
                    mensaje.setCancelable(false);
                    mensaje.create();
                    mensaje.show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Correo enviado. Verifique su buzon", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}