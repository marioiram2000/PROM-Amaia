package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gestorBD(View v) {
        Intent i = new Intent(MainActivity.this, GestorBD.class);
        startActivity(i);
    }

    public void gestorTiempo(View v) {
        Intent i = new Intent(MainActivity.this, GestorTiempo.class);
        startActivity(i);
    }

    public void salir(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("Esperamos verte de nuevo. ¡¡¡ADIOOOOS!!!")
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .show();
    }


}