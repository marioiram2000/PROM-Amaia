package com.example.ej_ud02_controlesbasicos_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

public class actividad04_2 extends AppCompatActivity {

    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad042);
        layout = findViewById(R.id.layout);
        Bundle bundle = getIntent().getExtras();
        String color= bundle.getString("color");
        if(color.equals("azul")){
            azul();
        }else{
            rojo();
        }
    }

    private void azul(){
        layout.setBackgroundResource(R.drawable.family);
    }

    private void rojo(){
        layout.setBackgroundResource(R.drawable.matrix);
    }
}