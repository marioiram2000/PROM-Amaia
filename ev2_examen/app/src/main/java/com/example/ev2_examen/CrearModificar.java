package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CrearModificar extends AppCompatActivity {

    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_modificar);
        SQLiteHelper helper = new SQLiteHelper(this, "DBExamen", null, 1);
        db = helper.getWritableDatabase();
    }

    //Caundo se pulsa el boton submit
    public void submit(View v){
        EditText edDNI = findViewById(R.id.edDNI);
        EditText edNombre = findViewById(R.id.edNombre);
        EditText edDireccion = findViewById(R.id.edDireccion);
        EditText edTelefono = findViewById(R.id.edTelefono);

        crearModificar(edDNI.getText().toString(), edNombre.getText().toString(), edDireccion.getText().toString(), edTelefono.getText().toString());

        finish();
    }

    //Inserción o modificación de un cliente
    public void crearModificar(String dni, String nombre, String direccion, String tfno){
        //Miramos si existe el cliente con ese dni y lo modificamos o lo creamos
        Cursor c = db.query("Clientes", new String[]{"dni"}, "dni=?",new String[]{dni}, null, null, null);
        if (c.moveToFirst()){
            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("direccion", direccion);
            valores.put("tfno", tfno);

            db.update("Clientes", valores, "dni=?", new String[]{dni});
        }else{
            ContentValues valores = new ContentValues();
            valores.put("dni", dni);
            valores.put("nombre", nombre);
            valores.put("direccion", direccion);
            valores.put("tfno", tfno);

            db.insert("Clientes", null, valores);
        }
    }

}