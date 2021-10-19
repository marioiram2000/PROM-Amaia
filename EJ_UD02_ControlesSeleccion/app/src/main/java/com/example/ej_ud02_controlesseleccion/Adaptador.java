package com.example.ej_ud02_controlesseleccion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptador  extends ArrayAdapter<Titular> {

    private final Titular[] datosTitular;

    public Adaptador(@NonNull Context context, Titular[] datosTitular) {
        super(context, R.layout.listitem_titular, datosTitular);
        this.datosTitular = datosTitular;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_titular, null);
        TextView tvTitulo = (TextView)item.findViewById(R.id.tvTitulo);
        String titulo = datosTitular[position].getTitulo();
        tvTitulo.setText(titulo);
        TextView tvSubtitulo = (TextView)item.findViewById(R.id.tvSubTitulo);
        tvSubtitulo.setText(datosTitular[position].getSubtitulo());
        ImageView imageView = (ImageView) item.findViewById(R.id.imageView);

        System.out.println("-----------------------------------------"+titulo);
        if(titulo.equals("w3schools"))
            imageView.setImageResource(R.drawable.w3);
        if(titulo.equals("GitHub"))
            imageView.setImageResource(R.drawable.git);
        if(titulo.equals("Spotify"))
            imageView.setImageResource(R.drawable.spoty);
        if(titulo.equals("Gmail"))
            imageView.setImageResource(R.drawable.gmail);

        return (item);
    }
}