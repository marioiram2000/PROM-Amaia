package com.example.ej_ud02_dialogos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.ej_ud02_dialogos.modelo.Libro;

public class FragmentFormulario extends Fragment {

    private EditText et_titulo;
    private EditText et_autor;
    private EditText et_genero;
    private EditText et_sinopsis;
    private Switch s_lehido;
    private Button btn_guardar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        et_titulo = getView().findViewById(R.id.editTextTitulo);
        et_autor = getView().findViewById(R.id.editTextAutor);
        et_genero = getView().findViewById(R.id.editTextGenero);
        et_sinopsis = getView().findViewById(R.id.editTextSinopsis);
        s_lehido = getView().findViewById(R.id.switchLehido);
        btn_guardar = getView().findViewById(R.id.button);

        btn_guardar.setOnClickListener(view -> guardarLibro(view));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_formulario, container, false);
    }

    public void guardarLibro(View view){

        String titulo = et_titulo.getText().toString();
        String autor = et_autor.getText().toString();
        String genero = et_genero.getText().toString();
        String sinopsis = et_sinopsis.getText().toString();
        boolean lehido = s_lehido.isChecked();

        new Libro(titulo, autor, genero, sinopsis, R.drawable.libro ,lehido);
    }
}