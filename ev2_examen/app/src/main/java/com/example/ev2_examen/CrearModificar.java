package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CrearModificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_modificar);
    }

    public void submit(View v){
        EditText edNum = findViewById(R.id.edNum);
        EditText edDNI = findViewById(R.id.edDNI);
        EditText edConcepto = findViewById(R.id.edConcepto);
        EditText edValor = findViewById(R.id.edValor);

        
    }
}