package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class GestorBD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_bd);

        SQLiteHelper helper = new SQLiteHelper(this, "DBExamen", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            //Insertamoa 5 usuarios de ejemplo
            for (int i = 1; i <= 5; i++) {
                //Generamos los datos
                String dni = "00000000" + i;
                String nombre = "Usuario " + i;
                String direccion = "usuario" + i + " direccion";
                String tfno = "94500000" + i;
                //Insertamos los datos en la tabla de Usuarios
                db.execSQL("INSERT INTO Clientes (dni, nombre, direccion, tfno) VALUES (" + dni + " ,'" + nombre + "','" + direccion + "' , '" + tfno + "')");

                int num = i;
                String concepto = "Concepto " + i;
                double valor = i * 51.32;
                db.execSQL("INSERT INTO Facturas (Num, dni, concepto, valor) VALUES (" + i + " , " + dni + " , '" + concepto + "' , " + valor + ")");
            }
            //Cerramos la base de datos
            db.close();
        }
    }

    public void crearModificar(){

    }
}