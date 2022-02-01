package com.example.ej_ud03_android_tratamientoxml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class RssHandler extends DefaultHandler {
    private List<Noticia> noticias; //Lista de noticias
    private Noticia noticiaActual; //Noticia Actual
    private StringBuilder sbTexto; //Texto del elemento

    public List<Noticia> getNoticias() {
        return noticias;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        noticias = new ArrayList<Noticia>();
        sbTexto = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (localName.equals("item")) {
            noticiaActual = new Noticia();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        if (this.noticiaActual != null)
            sbTexto.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if (this.noticiaActual != null) {
            switch (localName) {
                case "title":
                    noticiaActual.setTitulo(sbTexto.toString());
                    break;
                case "link":
                    noticiaActual.setLink(sbTexto.toString());
                    break;
                case "description":
                    noticiaActual.setDescripcion(sbTexto.toString());
                    break;
                case "guid":
                    noticiaActual.setGuid(sbTexto.toString());
                    break;
                case "pubDate":
                    noticiaActual.setFecha(sbTexto.toString());
                    break;
                case "item":
                    noticias.add(noticiaActual);
                    break;
            }
            sbTexto.setLength(0);
        }
    }
}