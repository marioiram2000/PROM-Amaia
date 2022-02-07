package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class CrearFacturas extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_facturas);
        SQLiteHelper helper = new SQLiteHelper(this, "DBExamen", null, 1);
        db = helper.getWritableDatabase();
    }

    //Cuando le damos al boton submit
    public void submit(View v) {
        EditText edNum = findViewById(R.id.edDNI);
        EditText edDNI = findViewById(R.id.edNombre);
        EditText edConcepto = findViewById(R.id.edDireccion);
        EditText edValor = findViewById(R.id.edTelefono);

        crear(edNum.getText().toString(), edDNI.getText().toString(), edConcepto.getText().toString(), edValor.getText().toString());
        finish();
    }

    //Inserción de una factura
    public void crear(String num, String dni, String concepto, String valor) {
        Cursor c = db.query("Clientes", new String[]{"dni"}, "dni=?", new String[]{dni}, null, null, null);
        if (c.moveToFirst()) {
            ContentValues valores = new ContentValues();
            valores.put("Num", num);
            valores.put("dni", dni);
            valores.put("concepto", concepto);
            valores.put("valor", valor);

            db.insert("Facturas", null, valores);
        }
    }
}