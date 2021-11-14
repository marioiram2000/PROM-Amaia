package com.example.ej_ud02_dialogos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ej_ud02_dialogos.modelo.Libro;

public class FragmentDetalle extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container,false);
    }
    public void mostrarDetalle (Libro l) {
        ImageView imageView = getView().findViewById(R.id.imagenLibro);
        imageView.setImageResource(l.getImagen());
        TextView txtDetalle = getView().findViewById(R.id.txtDetalle);
        txtDetalle.setText(l.toString());
    }
}