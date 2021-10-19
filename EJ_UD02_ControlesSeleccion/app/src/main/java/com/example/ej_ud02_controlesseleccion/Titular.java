package com.example.ej_ud02_controlesseleccion;

public class Titular {
    private String titulo;
    private String subtitulo;
    public Titular(String tit, String sub){
        titulo = tit;
        subtitulo = sub;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }

    @Override
    public String toString() {
        return titulo +": "+ subtitulo;
    }
}