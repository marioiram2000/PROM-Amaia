package com.example.ej_ud02_controlesbasicos_2;

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

    public void actividad01(View view) {
        Intent intent = new Intent(this, actividad01_NA.class);
        startActivity(intent);
    }

    public void actividad02(View view) {
        Intent intent = new Intent(this, actividad02_S.class);
        startActivity(intent);
    }

    public void actividad03(View view) {
        Intent intent = new Intent(this, actividad03_1.class);
        startActivity(intent);
    }

    public void actividad04(View view) {
        Intent intent = new Intent(this, actividad04_1.class);
        startActivity(intent);
    }

    public void salir(View v){
        finish();
    }
}