package Convertidor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manejador {


    public void convertirXML(Ciudad[] ciudads) throws IOException {

        FileWriter fw= new FileWriter("./src/main/java/Convertidor/archives/archivo.xml");

        fw.write("<Ciudades>");

        for (int i=0;i<ciudads.length;i++){
            fw.write(ciudads[i].toStringXML());

        }
        fw.write("</Ciudades>");
        fw.close();
    }

    public void convertirJSON(Ciudad[] ciudads) throws IOException {

        FileWriter fw= new FileWriter("./src/main/java/Convertidor/archives/archivo.json");

        fw.write("[\n");


        for (int i=0;i<ciudads.length;i++){
            fw.write(ciudads[i].toStringJSON());
            if (i<ciudads.length-1) {
                fw.write("},\n");
            }else{
                fw.write("}\n");
            }


        }
        fw.write("]\n");
        fw.close();
    }

    public void convertirYAML(Ciudad[] ciudads) throws IOException {


        FileWriter fw= new FileWriter("./src/main/java/Convertidor/archives/archivo.yaml");


        for (int i=0;i<ciudads.length;i++){

            ciudads[i].getCodCom().replaceAll("'","");
            fw.write(ciudads[i].toStringYAML());

        }
        fw.close();
    }











}
