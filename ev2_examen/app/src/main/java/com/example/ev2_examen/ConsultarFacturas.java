package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ConsultarFacturas extends AppCompatActivity {

    private SQLiteDatabase db;
    private ArrayList<String> spinnerData;
    private TextView tvNum;
    private TextView tvDni;
    private TextView tvNombre;
    private TextView tvConcepto;
    private TextView tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_facturas);

        Spinner spinner = findViewById(R.id.spinner);
        tvNum = findViewById(R.id.tvNum);
        tvDni = findViewById(R.id.tvDni);
        tvNombre = findViewById(R.id.tvNombre);
        tvConcepto = findViewById(R.id.tvConcepto);
        tvValor = findViewById(R.id.tvValor);

        SQLiteHelper helper = new SQLiteHelper(this, "DBExamen", null, 1);
        db = helper.getWritableDatabase();

        //Ponemos los clientes en el spinner
        spinnerData = new ArrayList<>();
        Cursor c = db.query("Clientes", new String[]{"dni, nombre"}, null, null, null, null, null);
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros.
            do {
                int dni = c.getInt(0);
                String nombre = c.getString(1);
                spinnerData.add(dni + ", " + nombre);
            } while (c.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerData);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Manejamos los eventos del spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String str = spinnerData.get(position);
                String dni = str.split(", ")[0];
                String nombre = str.split(", ")[1];

                tvDni.setText("");
                tvNombre.setText("");
                tvNum.setText("");
                tvConcepto.setText("");
                tvValor.setText("");

                obtenerFacturas(dni, nombre);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    //Obtenemos las facturas del cliente pasado
    private void obtenerFacturas(String dni, String nombre) {
        Cursor c = db.query("Facturas", new String[]{"Num, dni, concepto, valor"}, "dni=?", new String[]{dni}, null, null, null);
        if (c.moveToFirst()) {
            do {
                int num = c.getInt(0);
                String concepto = c.getString(2);
                double valor = c.getDouble(3);
                tvDni.setText(tvDni.getText()+"\n"+dni);
                tvNombre.setText(tvNombre.getText()+"\n"+nombre);
                tvNum.setText(tvNum.getText()+"\n"+num);
                tvConcepto.setText(tvConcepto.getText()+"\n"+concepto);
                tvValor.setText(tvValor.getText()+"\n"+valor+"€");
            } while (c.moveToNext());
        }
    }
}