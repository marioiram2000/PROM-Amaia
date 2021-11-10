package com.example.ej_ud02_fragmentos;

import android.widget.ImageView;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int imagen;

    public Libro() {}

    public Libro(String titulo, String autor, int imagen) {
        this.titulo = titulo;
        this.autor = autor;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Libro:\n" +
                "\t TÍTULO='" + titulo + "\'\n" +
                "\t AUTOR='" + autor +"\'";
    }
}


