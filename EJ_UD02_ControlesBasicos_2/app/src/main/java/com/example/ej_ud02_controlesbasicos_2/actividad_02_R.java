package com.example.ej_ud02_controlesbasicos_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class actividad_02_R extends AppCompatActivity {


    int aciertos;
    int fallos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad02_r);
        Bundle bundle = getIntent().getExtras();
        String correcto = bundle.getString("correcto");
        aciertos = bundle.getInt("aciertos");
        fallos = bundle.getInt("fallos");
        ((TextView)findViewById(R.id.textView12)).setText("El resultado de la operación es " +correcto);
    }

    public  void volver(View v){
        Intent intent = new Intent(this, actividad02_S.class);
        intent.putExtra("aciertos", aciertos);
        intent.putExtra("fallos", fallos);
        startActivity(intent);
    }
}