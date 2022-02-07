package com.example.ev2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    public void cargarDatos(View view) {
        if (primerclick) {
            ciudad.setVisibility(View.VISIBLE);
            fecha.setVisibility(View.VISIBLE);
            temperatura.setVisibility(View.VISIBLE);
            cielo.setVisibility(View.VISIBLE);
            primerclick = false;
        }


        fecha.setText(getResources().getString(R.string.fecha_hora) + tiempo.getFecha());
        temperatura.setText(getResources().getString(R.string.temperatura));
        cielo.setText(tiempo.getEstadocielo());


    }

    public void bilbao(View view) {
        ciudad.setText(getResources().getString(R.string.tiempo_en) + "Bilbo-Bilbao");
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8050";
        GestorTiempo.CargarXmlTask task = new GestorTiempo.CargarXmlTask();
        task.execute(url);
    }

    public void vitoria(View view) {
        ciudad.setText(getResources().getString(R.string.tiempo_en) + "Vitoria-Gasteiz");
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8043";
        GestorTiempo.CargarXmlTask task = new GestorTiempo.CargarXmlTask();
        task.execute(url);
    }

    public void donosti(View view) {
        ciudad.setText(getResources().getString(R.string.tiempo_en) + "Donostia-San Sebastian");
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=4917";
        GestorTiempo.CargarXmlTask task = new GestorTiempo.CargarXmlTask();
        task.execute(url);
    }

    public void volver(View view) {
        finish();
    }
}