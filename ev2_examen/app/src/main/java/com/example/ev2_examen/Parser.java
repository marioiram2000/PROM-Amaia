package com.example.ev2_examen;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;


import org.xml.sax.Attributes;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class Parser {

    private final URL rssURL;

    public Parser(String url) {
        //Ponemos el parametro de la url que nos han pasado
        try {
            this.rssURL = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public Tiempo parse() {
        //Obtenemos los datos que vamos a necesitar
        Tiempo tiempo = new Tiempo();
        RootElement root = new RootElement("data");

        //Del elemento dia obtenemos las temperaturas mínima y maxima

        Element dia = (Element) root.getChild("day1");
        dia.getChild("temperature_max").setEndTextElementListener(
                new EndTextElementListener() {
                    @Override
                    public void end(String body) {
                        tiempo.setTempmax(Integer.parseInt(body));
                    }
                });

        dia.getChild("temperature_min").setEndTextElementListener(
                new EndTextElementListener() {
                    @Override
                    public void end(String body) {
                        tiempo.setTempmin(Integer.parseInt(body));
                    }
                });


        //Del elemento hour1 obtenemos los datos de la hora actual
        Element horas = (Element) root.getChild("hour_hour");
        Element hora = horas.getChild("hour1");
        hora.getChild("temperature").setEndTextElementListener(
                new EndTextElementListener() {
                    @Override
                    public void end(String body) {
                        tiempo.setTemp(Integer.parseInt(body));
                    }
                });
        hora.getChild("text").setEndTextElementListener(
                new EndTextElementListener() {
                    @Override
                    public void end(String body) {
                        tiempo.setEstadocielo(body);
                    }
                });
        hora.getChild("icon").setEndTextElementListener(
                new EndTextElementListener() {
                    @Override
                    public void end(String body) {
                        tiempo.setIcono(body);
                    }
                });

        try {
            Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return tiempo;

    }

    private InputStream getInputStream() {
        try {
            return rssURL.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
