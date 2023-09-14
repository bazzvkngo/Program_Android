package com.example.primeravance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText edadEditText, pesoEditText, alturaEditText;
    private RadioButton gymGirlRadioButton;
    private RadioButton gymBoyRadioButton;
    private CheckBox ganarResistenciaCheckBox, ganarMusculoCheckBox, perderPesoCheckBox;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edadEditText = findViewById(R.id.edadEditText);
        pesoEditText = findViewById(R.id.pesoEditText);
        alturaEditText = findViewById(R.id.alturaEditText);
        gymGirlRadioButton = findViewById(R.id.gymGirlRadioButton);
        gymBoyRadioButton = findViewById(R.id.gymBoyRadioButton);
        ganarResistenciaCheckBox = findViewById(R.id.ganarResistenciaCheckBox);
        ganarMusculoCheckBox = findViewById(R.id.ganarMusculoCheckBox);
        perderPesoCheckBox = findViewById(R.id.perderPesoCheckBox);
        Button button2 = findViewById(R.id.button2);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        progressBar = findViewById(R.id.progressBar);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            gymGirlRadioButton.setEnabled(!isChecked);
            gymBoyRadioButton.setEnabled(!isChecked);
        });

        button2.setOnClickListener(view -> {
            if (camposEstanCompletos() && objetivosSeleccionadosValidos()) {
                // Todos los campos están completos y se han seleccionado de 1 a 2 objetivos
                mostrarToast("Sus datos han sido registrados exitosamente");

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(() -> {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                    progressBar.setVisibility(View.INVISIBLE);
                }, 2000);
            } else {
                mostrarToast("Verifique que todos los campos estén completos.");
            }
        });
    }

    private boolean camposEstanCompletos() {
        String edad = edadEditText.getText().toString();
        String peso = pesoEditText.getText().toString();
        String altura = alturaEditText.getText().toString();

        return !edad.isEmpty() && !peso.isEmpty() && !altura.isEmpty();
    }

    private boolean objetivosSeleccionadosValidos() {
        int objetivosSeleccionados = 0;
        if (ganarResistenciaCheckBox.isChecked()) {
            objetivosSeleccionados++;
        }
        if (ganarMusculoCheckBox.isChecked()) {
            objetivosSeleccionados++;
        }
        if (perderPesoCheckBox.isChecked()) {
            objetivosSeleccionados++;
        }

        if (objetivosSeleccionados == 3) {
            mostrarToast("No puedo darte el cielo");
        }

        return objetivosSeleccionados >= 1 && objetivosSeleccionados <= 2;
    }

    private void mostrarToast(String mensaje) {
        Toast.makeText(MainActivity2.this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
