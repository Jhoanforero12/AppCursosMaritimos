package com.grupo.aulamaritima;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IngresoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_ingreso);

        TextView textoNombre = findViewById(R.id.texto_nombre);
        TextView textoCorreo = findViewById(R.id.texto_correo);
        TextView textoTelefono = findViewById(R.id.texto_telefono);
        TextView textoCurso = findViewById(R.id.texto_curso);
        TextView textoModalidad = findViewById(R.id.texto_modalidad);
        Button botonSalir = findViewById(R.id.boton_salir);

        Intent intent = getIntent();
        textoNombre.setText("Nombre: " + intent.getStringExtra("nombre"));
        textoCorreo.setText("Correo: " + intent.getStringExtra("correo"));
        textoTelefono.setText("Teléfono: " + intent.getStringExtra("telefono"));
        textoCurso.setText("Curso: " + intent.getStringExtra("curso"));
        textoModalidad.setText("Modalidad: " + intent.getStringExtra("modalidad"));

        botonSalir.setOnClickListener(v -> {
            finishAffinity();
            System.exit(0);
        });
    }
}
