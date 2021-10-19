package com.example.ej_ud02_controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class Actividad2 extends AppCompatActivity {

    ListView lista;
    private Titular [] datosTitular = new Titular[] {
            new Titular("w3schools", "https://www.w3schools.com/"),
            new Titular("GitHub", "https://github.com/"),
            new Titular("Spotify", "https://open.spotify.com/"),
            new Titular("Gmail", "https://mail.google.com/")
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);


        Adaptador adaptadorListView = new Adaptador(this, datosTitular);

        lista = findViewById(R.id.listView);
        lista.setAdapter(adaptadorListView);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Titular key = (Titular) lista.getItemAtPosition(i);
                System.out.println(key.getSubtitulo());
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(key.getSubtitulo()));
                startActivity(viewIntent);
            }
        });
    }


}