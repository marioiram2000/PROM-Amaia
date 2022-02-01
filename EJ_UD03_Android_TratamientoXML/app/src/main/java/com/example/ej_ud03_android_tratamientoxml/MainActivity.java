package com.example.ej_ud03_android_tratamientoxml;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String url = "https://www.europapress.es/rss/rss.aspx";
    private TextView txtResultado;
    private List<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
    }

    public void cargarConSAXSimplificado(View v) {
        //Carga del XML mediante tarea Asincrona
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }

    //Tarea Asíncrona para cargar un XML en segundo plano
    private class CargarXmlTask extends AsyncTask<String, Integer, Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserSAXSimplificado saxparserSimplificado =
                    new RssParserSAXSimplificado(params[0]);
            noticias = saxparserSimplificado.parse();
            return true;
        }

        protected void onPostExecute(Boolean result) {
            //Tratamos la lista de noticias
            //Por ejemplo: escribimos los títulos en pantalla
            txtResultado.setText("");
            if (noticias != null) {
                for (int i = 0; i < noticias.size(); i++) {
                    String anterior = txtResultado.getText().toString();
                    String txt = anterior + "\n" + "\n" +noticias.get(i).getTitulo();
                    txtResultado.setText(txt);
                }
            }
        }
    }
}