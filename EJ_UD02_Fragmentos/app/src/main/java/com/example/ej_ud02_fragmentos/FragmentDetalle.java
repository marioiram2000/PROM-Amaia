package com.example.ej_ud02_fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class FragmentDetalle extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container,false);
    }
    public void mostrarDetalle (Libro l) {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imagenLibro);
        imageView.setImageResource(l.getImagen());
        TextView txtDetalle = (TextView) getView().findViewById(R.id.txtDetalle);
        txtDetalle.setText(l.toString());
    }
}
