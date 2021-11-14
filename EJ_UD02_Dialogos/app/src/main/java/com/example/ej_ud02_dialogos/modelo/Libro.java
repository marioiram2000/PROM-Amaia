package com.example.ej_ud02_dialogos.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Libro {

    private static ArrayList<Libro>libros;

    private String titulo;
    private String autor;
    private String genero;
    private String sinopsis;
    private int imagen;
    private boolean lehido;

    public Libro() {
    }

    public Libro(String titulo, String autor, String genero, String sinopsis, int imagen, boolean lehido) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
        this.lehido = lehido;
        libros.add(this);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", imagen=" + imagen +
                ", lehido=" + lehido +
                '}';
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public boolean isLehido() {
        return lehido;
    }

    public void setLehido(boolean lehido) {
        this.lehido = lehido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return imagen == libro.imagen && lehido == libro.lehido && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && Objects.equals(genero, libro.genero) && Objects.equals(sinopsis, libro.sinopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, genero, sinopsis, imagen, lehido);
    }
}
