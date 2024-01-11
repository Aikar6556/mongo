package Convertidor;

public class Ciudad {

    Manejador manejador;

    private String nombre;
    private int poblacion;
    private int numComunidad;
    private String codCom;


    public Ciudad(String nombre, int poblacion, int numComunidad, String codCom) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.numComunidad = numComunidad;
        this.codCom = codCom;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getNumComunidad() {
        return numComunidad;
    }

    public void setNumComunidad(int numComunidad) {
        this.numComunidad = numComunidad;
    }

    public String getCodCom() {
        return codCom;
    }

    public void setCodCom(String codCom) {
        this.codCom = codCom;
    }


    public String toStringXML() {
        return "<Ciudad>\n" +
                "<nombre>" + nombre + "</nombre>\n"+
                "<poblacion>" + poblacion +"</poblacion>\n"+
                "<numComunidad>" + numComunidad +"</numComunidad>\n"+
                "<codCom>'" + codCom + "</codCom>\n"+
                "</Ciudad>";

    }

    public String toStringJSON(){

        return


                "{\n \"nombre\""+":" + "\""+nombre +"\"\n,"+
                "\"poblacion\""+":"+ poblacion +"\n,"+
                "\"numComunidad\""+":"+numComunidad +"\n,"+
                "\"codCom\""+":" +"\""+ codCom+"\""+"\n"
                ;
    }

    public String toStringYAML(){

        return

                "- "+"nombre: " + nombre + "\n"+
                        "  poblacion: "+ poblacion+"\n"+
                        "  numComunidad: "+numComunidad+"\n"+
                        "  codCom: "+codCom+"\n";


    }


}
