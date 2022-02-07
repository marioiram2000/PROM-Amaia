package com.example.ev2_examen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    String sqlCreateClientes ="CREATE TABLE Clientes (dni INTEGER PRIMARY KEY, nombre TEXT, direccion TEXT, tfno TEXT)";
    String sqlCreateFacturas ="CREATE TABLE Facturas (Num INTEGER PRIMARY KEY, dni INTEGER, concepto TEXT, valor REAL)";

    public SQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreateClientes);
        db.execSQL(sqlCreateFacturas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        //Se crea la nueva version de la tabla
        db.execSQL(sqlCreateClientes);
        db.execSQL(sqlCreateFacturas);
    }




}
