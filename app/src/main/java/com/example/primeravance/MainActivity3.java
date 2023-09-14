package com.example.primeravance;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button finalizarRegistroButton = findViewById(R.id.button4);
        finalizarRegistroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoRegistroCompleto();
            }
        });

        Button regresarButton = findViewById(R.id.button6);
        regresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresarAMainActivity2();
            }
        });

        Button calificarButton = findViewById(R.id.button3);
        calificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAMainActivity4();
            }
        });
    }

    private void mostrarDialogoRegistroCompleto() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Registro Completado")
                .setMessage("¡Felicidades, has completado tu registro! ¡A ponernos mamados!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    private void regresarAMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    private void irAMainActivity4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
}
