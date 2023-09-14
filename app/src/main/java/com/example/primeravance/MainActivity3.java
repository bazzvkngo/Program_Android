package com.example.primeravance;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    public void calificarClick(View view) {

        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
}
