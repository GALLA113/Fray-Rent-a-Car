package com.example.fray_rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AyudaYAsistencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda_yasistencia);

        getSupportActionBar().hide();
    }

    public void Regresar(View view) {
        finish();
    }

    public void CondicionesDeUso(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://ayudaleyprotecciondatos.es/wp-content/uploads/2018/07/terminos-condiciones-app.pdf"));
        startActivity(intent);
    }

    public void PoliticasDePrivacidad(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.wowemotions.com/Apps/Politicas_de_privacidad.pdf"));
        startActivity(intent);
    }

    public void TerminosDelServicio(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://studylib.es/doc/6415714/terminos-y-condiciones"));
        startActivity(intent);
    }

    public void AcercaDe(View view) {
        Intent intent = new Intent(AyudaYAsistencia.this, AcercaDe.class);
        startActivity(intent);
    }
}