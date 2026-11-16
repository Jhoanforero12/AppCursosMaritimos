package com.grupo.aulamaritima;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PresentacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_presentacion);

        Button botonComenzar = findViewById(R.id.boton_comenzar);

        botonComenzar.setOnClickListener(v ->
                startActivity(new Intent(PresentacionActivity.this, FormularioActivity.class)));
    }
}