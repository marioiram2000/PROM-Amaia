package com.example.ej_ud02_controlesbasicos_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class actividad04_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad041);
    }

    public void elegir(View v){
        Intent intent = new Intent(this, actividad04_2.class);
        if(v.getId() == R.id.botonAzul){
            intent.putExtra("color", "azul");
        }else{
            intent.putExtra("color", "rojo");
        }
        startActivity(intent);
    }
}