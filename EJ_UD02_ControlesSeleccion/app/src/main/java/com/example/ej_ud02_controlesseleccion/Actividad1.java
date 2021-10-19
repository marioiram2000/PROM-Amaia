package com.example.ej_ud02_controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class Actividad1 extends AppCompatActivity {

    private HashMap<String, String> data = new HashMap<String, String>();
    private Spinner spPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        data.put("England", "Población: 7 556 900\n Superficie total: 130 395");
        data.put("Germany", "Población: 83 240 000\n Superficie total: 357 578 17");
        data.put("Norway", "Población: 5 379 000\n Superficie total: 323 802");
        data.put("USA", "Población: 329 500 000\n Superficie total: 9 147 593");

        String[] paises = {"England", "Germany", "Norway", "USA"};
        spPaises = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, paises);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spPaises.setAdapter(adaptador);

        TextView result = findViewById(R.id.textViewResult);
        spPaises.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        result.setText(data.get((String)spPaises.getSelectedItem()));
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
    }

}