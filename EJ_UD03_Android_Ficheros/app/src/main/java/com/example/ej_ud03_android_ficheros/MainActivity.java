package com.example.ej_ud03_android_ficheros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getInputText(View view) {
        EditText myEditText = (EditText) findViewById(R.id.editTextContenido);
        return myEditText.getText().toString();
    }

    private void setFileText(View view, String text) {
        TextView tv = (TextView) findViewById(R.id.textViewContenido);
        tv.setText(text);
    }

    private void checkPermissions() {
        boolean permisoEscritura = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        boolean permisoLectura = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        if (!permisoLectura) {
            solicitarPermiso(Manifest.permission.READ_EXTERNAL_STORAGE, "Por que quiero", 0, this);
        }
        if (!permisoEscritura) {
            solicitarPermiso(Manifest.permission.WRITE_EXTERNAL_STORAGE, "Por que quiero", 0, this);
        }
    }

    public static void solicitarPermiso(final String permiso, String justificacion, final int requestCode, final Activity actividad) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad, permiso)) {
            //Informamos al usuario para qué y por qué se necesitan los permisos
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud de permiso")
                    .setMessage(justificacion)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    ActivityCompat.requestPermissions(actividad, new String[]{permiso}, requestCode);
                                }
                            })
                    .show();
        } else {
            //Muestra el cuadro de dialogo para la solicitud de los permisos
            // y registra el permiso según respuesta del usuario
            ActivityCompat.requestPermissions(actividad, new String[]{permiso}, requestCode);
        }
    }

    private boolean checkExternalStorage() {
        checkPermissions();

        boolean sdDisponible = false;
        boolean sdAccesoEscritura = false;
        //Comprobamos el estado de la memoria exterena
        String estado = Environment.getExternalStorageState();
        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
            Log.i("SD", "Todo bien");
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            Log.e("SD", "SD de lectura");
        } else {
            Log.e("SD", "No sd");
        }

        return sdDisponible && sdAccesoEscritura;
    }

    // Se guarda en /data/data/com.example.ej_ud03_android_ficheros/files/prueba_int
    public void aniadirFichInt(View view) {
        String text = getInputText(view);
        try {
            // MODE_PRIVATE crea el fichero o lo sobrescribe si ya existe
            // MODE_APPEND para añadir datos a un fichero ya existente
            FileOutputStream fos = openFileOutput("prueba_int.txt", Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(text);
            fos.close();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerFichInt(View view) {
        try {
            FileInputStream fis = openFileInput("prueba_int.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String texto = br.readLine();
            setFileText(view, texto);
            fis.close();
            br.close();
        } catch (Exception e) {
            Log.e("Ficheros", "ERROR!! al escribir fichero en memoria interna");
        }
    }

    public void borrarFichInt(View view) {
        deleteFile("prueba_int.txt");
    }

    public void aniadirFichExt(View view) {
        checkPermissions();
        if (checkExternalStorage()) {
            try {
                File ruta_sd = Environment.getExternalStorageDirectory();
                File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
                if (!f.exists()) { // Si no existe, crea el archivo.
                    f.createNewFile();
                }
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f));

                String text = getInputText(view);
                osw.write(text);

                osw.close();

                Log.i("Ficheros", "fichero escrito correctamente");
            } catch (IOException e) {
                Log.i("Externos", "Error al encontrar el archivo");
                e.printStackTrace();
            }
        }
    }

    public void leerFichExt(View view) {
        checkPermissions();
        if (checkExternalStorage()) {
            try {
                File ruta_sd = Environment.getExternalStorageDirectory();
                File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String texto = br.readLine();
                setFileText(view, texto);
                br.close();
                Log.i("Ficheros", "fichero escrito correctamente");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void borrarFichExt(View view) {
        File ruta_sd = Environment.getExternalStorageDirectory();
        File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");

        if (f.exists()) {
            if (f.delete()) {
                System.out.println("Selected File deleted successfully");
            } else {
                System.out.println("Failed to delete the selected file");
            }
        }else{
            System.out.println("Fichero no encontrado");
        }
    }

    public void leerRecurso(View view) {
        try {
            InputStream is = getResources().openRawResource(R.raw.prueba_raw);
            BufferedReader brin =
                    new BufferedReader(new InputStreamReader(is));
            String texto = "";
            String linea = brin.readLine();
            while (linea != null) {
                texto = texto + linea + "\n";
                Log.i("Ficheros", linea);
                linea = brin.readLine();
            }
            is.close();
            setFileText(view, texto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}