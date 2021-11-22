package com.example.ej_ud02_dialogos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ej_ud02_dialogos.modelo.Libro;
import com.example.ej_ud02_dialogos.modelo.LibroListener;

public class FragmentListadoController extends Fragment implements LibroListener {

    public FragmentListadoController() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);/*
        FragmentListado fragmentListado = (FragmentListado) FragmentManager.findFragmentById(R.id.frgListado);
        fragmentListado.setLibroListener(this);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado_controller, container, false);
    }

    @Override
    public void onLibroSeleccionado(Libro l) {
        /*
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);
        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager().
                    findFragmentById(R.id.frgDetalle)).mostrarDetalle(l);
        }
        else {
            Intent i = new Intent(this, ActivityDetalle.class);
            i.putExtra(ActivityDetalle.EXTRA_TEXTO, l.toString());
            i.putExtra("libro", l);
            startActivity(i);
        }*/
    }
}