package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Spinner;

public class ConsultarFacturas extends AppCompatActivity {

    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_facturas);

        Spinner spinner = findViewById(R.id.spinner);

        SQLiteHelper helper = new SQLiteHelper(this, "DBExamen", null, 1);
        db = helper.getWritableDatabase();

        Cursor c = db.query("Clientes", new String[]{"dni, nombre"}, null, null, null, null, null);
        if (c.moveToFirst()){
            //Recorremos el cursor hasta que no haya más registros.
            do {
                int codigo = c.getInt(0);
                String nombre =c.getString(1);
                String email = c.getString(2);
                //txtResultado.append (codigo +" - "+nombre + " - " +email+"\n" );
            }while (c.moveToNext());
        }
    }
}