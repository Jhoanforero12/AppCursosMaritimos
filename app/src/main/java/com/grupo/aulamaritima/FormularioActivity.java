package com.grupo.aulamaritima;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {

    private EditText campoNombre;
    private EditText campoCorreo;
    private EditText campoTelefono;
    private Spinner listaCurso;
    private RadioGroup grupoModalidad;
    private CheckBox checkTerminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_formulario);

        campoNombre = findViewById(R.id.campo_nombre);
        campoCorreo = findViewById(R.id.campo_correo);
        campoTelefono = findViewById(R.id.campo_telefono);
        listaCurso = findViewById(R.id.lista_curso);
        grupoModalidad = findViewById(R.id.grupo_modalidad);
        checkTerminos = findViewById(R.id.check_terminos);
        Button botonEnviar = findViewById(R.id.boton_enviar);
        Button botonSalir = findViewById(R.id.boton_salir);

        String[] cursos = {"PSSR", "PSSR avanzado", "Primeros auxilios", "Lucha contra incendios", "Supervivencia en el mar"};
        listaCurso.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cursos));

        botonEnviar.setOnClickListener(v -> enviarFormulario());

        botonSalir.setOnClickListener(v -> {
            finishAffinity();
            System.exit(0);
        });
    }

    private void enviarFormulario() {
        String nombre = campoNombre.getText().toString().trim();
        String correo = campoCorreo.getText().toString().trim();
        String telefono = campoTelefono.getText().toString().trim();
        String curso = listaCurso.getSelectedItem().toString();
        int modalidadSeleccionada = grupoModalidad.getCheckedRadioButtonId();

        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        if (modalidadSeleccionada == -1) {
            Toast.makeText(this, "Selecciona la modalidad", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!checkTerminos.isChecked()) {
            Toast.makeText(this, "Debes aceptar los términos", Toast.LENGTH_SHORT).show();
            return;
        }

        String modalidad = ((RadioButton) findViewById(modalidadSeleccionada)).getText().toString();

        Intent intent = new Intent(FormularioActivity.this, IngresoActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("correo", correo);
        intent.putExtra("telefono", telefono);
        intent.putExtra("curso", curso);
        intent.putExtra("modalidad", modalidad);
        startActivity(intent);
        finish();
    }
}
