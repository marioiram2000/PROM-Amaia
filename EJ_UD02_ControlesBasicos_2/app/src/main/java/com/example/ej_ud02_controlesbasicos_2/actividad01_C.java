package com.example.ej_ud02_controlesbasicos_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class actividad01_C extends AppCompatActivity {

    public String name;
    public String lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad01_c);
        Bundle bundle =getIntent().getExtras();
        name= bundle.getString("name");
        lastname =bundle.getString("lastname");
        TextView mensaje = findViewById(R.id.mensaje);
        String txt = "Hola "+name.toUpperCase()+ " "+lastname.toUpperCase()+ " ¿Aceptas las condiciones?";
        mensaje.setText(txt);
    }

    public void verificar(View v){
        Intent intent = new Intent();
        intent.putExtra("aceptada" , v.getId() == R.id.aceptar);
        setResult(RESULT_OK, intent);
        finish();
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK) {
            name = data.getExtras().getString("name");
            lastname = data.getExtras().getString("lastname");
        }
    }
}