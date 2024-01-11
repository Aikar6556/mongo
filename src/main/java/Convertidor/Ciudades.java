package Convertidor;

import java.util.ArrayList;
import java.util.List;

public class Ciudades {

    private List<Ciudad> xmlCiudades;

    public Ciudades() {
        this.xmlCiudades = new ArrayList<>();
    }

    public List<Ciudad> getXmlCiudades() {
        return xmlCiudades;
    }

    public void setXmlCiudades(List<Ciudad> xmlCiudades) {
        this.xmlCiudades = xmlCiudades;
    }


    public void addCiudad(Ciudad c){

        xmlCiudades.add(c);

    }


}
