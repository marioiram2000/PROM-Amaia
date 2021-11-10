package com.example.ej_ud02_fragmentos;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
public class DetalleActivity extends AppCompatActivity {
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