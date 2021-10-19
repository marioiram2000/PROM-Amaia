package com.example.ej_ud02_controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;


public class Actividad3 extends AppCompatActivity {

    private String[] datosGV = new String [15];
    private GridView gvOpciones;
    private Titular [] datosTitular = new Titular[] {
            new Titular("w3schools", "https://www.w3schools.com/"),
            new Titular("GitHub", "https://github.com/"),
            new Titular("Spotify", "https://open.spotify.com/"),
            new Titular("Gmail", "https://mail.google.com/")
    };
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        spinner = (Spinner) findViewById(R.id.spinner);

        Adaptador adaptador = new Adaptador(this, datosTitular);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_list_item_1);
        spinner.setAdapter(adaptador);

        for (int i=1; i<=15; i++){
            datosGV[i-1]= "Dato "+i;
        }

        ArrayAdapter<String> adaptadorArray =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datosGV);
        gvOpciones = (GridView)findViewById(R.id.gvOpciones);
        gvOpciones.setAdapter(adaptadorArray);
        TextView tvOpcionSeleccionada = findViewById(R.id.tvOpcionSeleccionada);
        gvOpciones.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent,
                                            android.view.View v,
                                            int position, long id) {
                        tvOpcionSeleccionada.setText("La Opción seleccionada es: "
                                + parent.getItemAtPosition(position));
                    }
                });
    }
}