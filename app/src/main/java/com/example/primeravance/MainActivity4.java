package com.example.primeravance;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private RatingBar ratingBar;
    private ProgressBar progressBar;
    private ImageButton imageButton;

    private boolean calificacionRealizada = false; // Variable para verificar si se ha realizado la calificación

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ratingBar = findViewById(R.id.ratingBar2);
        progressBar = findViewById(R.id.progressBar);
        imageButton = findViewById(R.id.imageButton);

        // Inicialmente, configura el color de las estrellas como transparentes
        ratingBar.setRating(0);

        // Configurar un OnClickListener para el botón de imagen
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calificacionRealizada) {
                    // Mostrar un Toast con el mensaje
                    String mensaje = "Gracias por tu calificación, tu nota es : " + ratingBar.getRating();
                    mostrarToast(mensaje);
                } else {
                    // Mostrar el ProgressBar
                    progressBar.setVisibility(View.VISIBLE);

                    // Simular una operación de calificación (aquí se usa un temporizador de 2 segundos)
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Cambiar el color de las estrellas a amarillo
                            ratingBar.setRating(5); // Establece una calificación de ejemplo (ajusta según tus necesidades)

                            // Marcar la calificación como realizada
                            calificacionRealizada = true;

                            // Ocultar el ProgressBar después de la simulación
                            progressBar.setVisibility(View.INVISIBLE);

                            // Mostrar un Toast con la calificación
                            String mensaje = "Gracias por calificarnos, tu nota es: " + ratingBar.getRating();
                            mostrarToast(mensaje);
                        }
                    }, 2000);
                }
            }
        });
    }

    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
