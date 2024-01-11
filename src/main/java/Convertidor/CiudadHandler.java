package Convertidor;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CiudadHandler extends DefaultHandler {

    Ciudades ciudades;
    private  StringBuilder elementValue;


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        ciudades = new Ciudades();
    }


    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {

            case "Ciudad":
                ciudades.addCiudad(new Ciudad());
                break;
            case "nombre":
                elementValue=new StringBuilder();
                break;
            case "poblacion":
                elementValue=new StringBuilder();

                break;
            case "numComunidad":
                elementValue=new StringBuilder();

                break;
            case "codCom":
                elementValue=new StringBuilder();

                break;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {

            case "nombre":
                ciudades.getXmlCiudades().getLast().setNombre(elementValue.toString());
                break;
            case "poblacion":
                ciudades.getXmlCiudades().getLast().setPoblacion(Integer.parseInt(elementValue.toString()));
                break;
            case "numComunidad":
                ciudades.getXmlCiudades().getLast().setNumComunidad(Integer.parseInt(elementValue.toString()));
                break;
            case "codCom":
                ciudades.getXmlCiudades().getLast().setCodCom(elementValue.toString());
                break;
        }
    }


}
