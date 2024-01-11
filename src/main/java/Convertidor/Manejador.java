package Convertidor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manejador {


    public void convertirXML(Ciudad[] ciudads) throws IOException {

        FileWriter fw= new FileWriter("./src/main/java/Convertidor/archives/residuo.xml");

        fw.write("<Ciudades>");

        for (int i=0;i<ciudads.length;i++){
            fw.write(ciudads[i].toStringXML());

        }
        fw.write("</Ciudades>");
        fw.close();
    }

    public void convertirJSON(Ciudad[] ciudads) throws IOException {

        FileWriter fw= new FileWriter("./src/main/java/Convertidor/archives/residuo.json");

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


        FileWriter fw= new FileWriter("./src/main/java/Convertidor/archives/residuo.yaml");


        for (int i=0;i<ciudads.length;i++){
            fw.write(ciudads[i].toStringYAML());

        }
        fw.close();
    }











}
