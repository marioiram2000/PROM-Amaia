package com.example.ej_ud02_controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActividad1(View v){
        Intent intent = new Intent(this, Actividad1.class);
        startActivity(intent);
    }

    public void openActividad2(View v){
        Intent intent = new Intent(this, Actividad2.class);
        startActivity(intent);
    }

    public void openActividad3(View v){
        Intent intent = new Intent(this, Actividad3.class);
        startActivity(intent);
    }
}