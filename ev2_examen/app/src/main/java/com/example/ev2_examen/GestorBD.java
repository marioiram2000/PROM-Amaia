package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class GestorBD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_bd);

        SQLiteHelper helper = new SQLiteHelper(this, "DBExamen", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            //Quitar el comentario para insertar los datos por primera vez
            /*
            for (int i = 1; i <= 5; i++) {
                //Generamos los datos
                int dni = i;
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
             */
            //Cerramos la base de datos
            db.close();
        }
    }

    public void crearModificar(View v){
        Intent i = new Intent(this, CrearModificar.class);
        startActivity(i);
    }

    public void crearFacturas(View v){
        Intent i = new Intent(this, CrearFacturas.class);
        startActivity(i);
    }

    public void consultarFacturas(View v){
        Intent i = new Intent(this, ConsultarFacturas.class);
        startActivity(i);
    }


}