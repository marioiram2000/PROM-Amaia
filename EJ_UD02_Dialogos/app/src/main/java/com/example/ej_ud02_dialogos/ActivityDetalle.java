package com.example.ej_ud02_dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ej_ud02_dialogos.modelo.Libro;

public class ActivityDetalle extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "com.example.ejfragments.EXTRA_TEXTO";
    public static final int IMAGEN = R.drawable.libro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle detalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        Bundle extras = getIntent().getExtras();
        Libro libro = (Libro) extras.get("libro");
        detalle.mostrarDetalle(libro);
    }
}