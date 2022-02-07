package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Icon;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GestorTiempo extends AppCompatActivity {

    public String url;

    private Tiempo tiempo;

    private TextView ciudad, fecha, cielo, temperatura;

    private boolean primerclick;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_tiempo);

        view = findViewById(android.R.id.content).getRootView();

        ciudad = findViewById(R.id.tvCiudad);
        fecha = findViewById(R.id.tvFecha);
        temperatura = findViewById(R.id.tvTemperatura);
        cielo = findViewById(R.id.tvCielo);


        primerclick = true;


    }

    //Cargamos el XML task
    private class CargarXmlTask extends AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {
            Parser domParser = new Parser(params[0]);
            tiempo = domParser.parse();
            return true;
        }

        protected void onPostExecute(Boolean result) {
            cargarDatos(view);
        }
    }

    //Cargamos los datos del xml
    public void cargarDatos(View view) {
        if (primerclick) {
            ciudad.setVisibility(View.VISIBLE);
            fecha.setVisibility(View.VISIBLE);
            temperatura.setVisibility(View.VISIBLE);
            cielo.setVisibility(View.VISIBLE);
            primerclick = false;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();

        fecha.setText(getResources().getString(R.string.fecha_hora) + " " + formatter.format(date));
        temperatura.setText(getResources().getString(R.string.temperatura) + " " + tiempo.getTemp() + " (Min: " + tiempo.getTempmin() + " / Max:" + tiempo.getTempmax() + ")");
        cielo.setText(tiempo.getEstadocielo());

        ImageView imageView = findViewById(R.id.imageView);
        switch (tiempo.getIcono()){
            case "1":
                imageView.setImageResource(R.drawable.uno);
            case "1n":
                imageView.setImageResource(R.drawable.uno_n);
            case "2":
                imageView.setImageResource(R.drawable.dos);
            case "2n":
                imageView.setImageResource(R.drawable.dos_n);
            case "4":
                imageView.setImageResource(R.drawable.cuatro);
            case "4n":
                imageView.setImageResource(R.drawable.cuatro_n);
            case "6":
                imageView.setImageResource(R.drawable.seis);
            case "6n":
                imageView.setImageResource(R.drawable.seis_n);
            case "7":
                imageView.setImageResource(R.drawable.siete);
            case "9":
                imageView.setImageResource(R.drawable.nueve);
            case "9n":
                imageView.setImageResource(R.drawable.nueve_n);
            case "11":
                imageView.setImageResource(R.drawable.once);
            case "18":
                imageView.setImageResource(R.drawable.dieciocho);
            case "19":
                imageView.setImageResource(R.drawable.diecinueve);
            case "21":
                imageView.setImageResource(R.drawable.veintiuno);
            case "21n":
                imageView.setImageResource(R.drawable.veintiuno_n);
            case "22":
                imageView.setImageResource(R.drawable.veintidos);
            case "24":
                imageView.setImageResource(R.drawable.veinticuatro);
            case "25":
                imageView.setImageResource(R.drawable.veinticinco);
            case "28":
                imageView.setImageResource(R.drawable.veintiocho);
            case "29":
                imageView.setImageResource(R.drawable.veintinueve);
            case "30":
                imageView.setImageResource(R.drawable.treinta);
            case "33":
                imageView.setImageResource(R.drawable.treintaytres);
            case "33n":
                imageView.setImageResource(R.drawable.treintaytres_n);
            case "51":
                imageView.setImageResource(R.drawable.cincuentayuno);
            case "51n":
                imageView.setImageResource(R.drawable.cincuentayuno_n);
            case "54":
                imageView.setImageResource(R.drawable.cincuentaycuatro);
            case "nd":
                imageView.setImageResource(R.drawable.nd);
        }

    }

    //En el caso de que hayamos seleccionado bilbao
    public void bilbao(View view) {
        ciudad.setText(getResources().getString(R.string.tiempo_en) + " Bilbo-Bilbao");
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8050";
        GestorTiempo.CargarXmlTask task = new GestorTiempo.CargarXmlTask();
        task.execute(url);
    }

    //En el caso de que hayamos seleccionado vitoria
    public void vitoria(View view) {
        ciudad.setText(getResources().getString(R.string.tiempo_en) + " Vitoria-Gasteiz");
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8043";
        GestorTiempo.CargarXmlTask task = new GestorTiempo.CargarXmlTask();
        task.execute(url);
    }

    //En el caso de que hayamos seleccionado donosti
    public void donosti(View view) {
        ciudad.setText(getResources().getString(R.string.tiempo_en) + " Donostia-San Sebastian");
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=4917";
        GestorTiempo.CargarXmlTask task = new GestorTiempo.CargarXmlTask();
        task.execute(url);
    }

    public void volver(View view) {
        finish();
    }
}