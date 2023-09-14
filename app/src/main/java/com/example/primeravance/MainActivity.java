package com.example.primeravance;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Bienvenido GymRat!");
            builder.setMessage("¡Gracias por comenzar tu viaje de fitness!");
            builder.setPositiveButton("Aceptar", (dialogInterface, i) -> {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            });

            builder.create().show();
        });

    }
}
