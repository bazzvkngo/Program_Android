package com.example.primeravance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private RatingBar ratingBar;
    private ProgressBar progressBar;
    private ImageButton imageButton;
    private Button regresarButton;

    private boolean calificacionRealizada = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        itemAdapter = new ItemAdapter(this);
        itemAdapter.setDate(getData());
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        ratingBar = findViewById(R.id.ratingBar2);
        progressBar = findViewById(R.id.progressBar);
        imageButton = findViewById(R.id.imageButton);
        regresarButton = findViewById(R.id.button5);

        ratingBar.setRating(0);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calificacionRealizada) {

                    String mensaje = "Gracias por tu calificación, tu nota es : " + ratingBar.getRating();
                    mostrarToast(mensaje);
                } else {

                    progressBar.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ratingBar.setRating(5);

                            calificacionRealizada = true;

                            progressBar.setVisibility(View.INVISIBLE);

                            String mensaje = "Gracias por calificarnos, tu nota es: " + ratingBar.getRating();
                            mostrarToast(mensaje);
                        }
                    }, 2000);
                }
            }
        });

        regresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarAMainActivity3();
            }
        });
    }

    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void regresarAMainActivity3() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    private List<Item> getData() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.facebook,"Facebook"));
        list.add(new Item(R.drawable.instagram,"Instagram"));

        return list;
    }
}
