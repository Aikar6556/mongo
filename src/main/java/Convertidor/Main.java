package Convertidor;

import com.google.gson.Gson;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String leer(File ruta) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(ruta));

        String resultadoTotal = "";
        String linea;
        while ((linea = br.readLine()) != null) {

            resultadoTotal += linea + "\n";


        }


        return resultadoTotal.replaceAll(" ", "");

    }

    public static ArrayList<Ciudad> parseoYAML(String contenidoYAML) {

        ArrayList<Ciudad> nuevasCiudades = new ArrayList<>();


        System.out.println(contenidoYAML);

        contenidoYAML = contenidoYAML.replaceAll("-", "");
        contenidoYAML = contenidoYAML.replaceAll(":", " ");
        contenidoYAML = contenidoYAML.replaceAll(" +", " ");
        contenidoYAML = contenidoYAML.replaceAll("\t", "");
        contenidoYAML = contenidoYAML.replaceAll("\n", " ");

        System.out.println(contenidoYAML);

        String[] arrayYAML = contenidoYAML.split(" ");


        for (int i = 0; i < arrayYAML.length; i++) {

            if (arrayYAML[i].equalsIgnoreCase("nombre")) {

                nuevasCiudades.add(new Ciudad());

                nuevasCiudades.getLast().setNombre(arrayYAML[i + 1]);


            } else if ((arrayYAML[i].equalsIgnoreCase("poblacion"))) {

                nuevasCiudades.getLast().setPoblacion(Integer.parseInt(arrayYAML[i + 1]));

            } else if ((arrayYAML[i].equalsIgnoreCase("numComunidad"))) {

                nuevasCiudades.getLast().setNumComunidad(Integer.parseInt(arrayYAML[i + 1]));

            } else if ((arrayYAML[i].equalsIgnoreCase("codCom"))) {

                nuevasCiudades.getLast().setCodCom(arrayYAML[i + 1]);

            }


        }
        return nuevasCiudades;

    }


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Manejador manejador = new Manejador();

        ArrayList<Ciudad> ciudades = new ArrayList<>();

        ciudades.add(new Ciudad("Cuenca", 200, 7, "CUE"));
        ciudades.add(new Ciudad("Ceuta", 800, 8, "CEU"));


        Scanner scanner = new Scanner(System.in);
        String path = "";


        System.out.println("Introduce el path");
        path = scanner.nextLine();
        File ubi = new File(path);


        String extension = ubi.getName().split("\\.")[1];


        switch (extension) {

            case "json":

                String contenido = leer(ubi);

                Gson gson = new Gson();
                Ciudad[] ciudads = gson.fromJson(contenido, Ciudad[].class);

                String electionJson;

                System.out.println("¿Que deseas realizar?");
                System.out.println("1-para convertir a XML");
                System.out.println("2-para convertir a YAML");

                electionJson = scanner.nextLine();

                boolean flag = true;

                while (flag)

                    if (electionJson.equalsIgnoreCase("1")) {

                        manejador.convertirXML(ciudads);
                        System.out.println("Archivo XML creado");
                        flag = false;

                    } else if (electionJson.equalsIgnoreCase("2")) {

                        manejador.convertirYAML(ciudads);
                        System.out.println("Archivo YAML creado");
                        flag = false;

                    } else {
                        System.out.println("Introduce una opcíon válido");
                        flag = true;
                        electionJson = scanner.nextLine();


                    }


                break;

            case "yaml":

                String contenidoYAML = leer(ubi);

                ArrayList<Ciudad> nuevaCiudad = parseoYAML(contenidoYAML);

                System.out.println("¿Que deseas realizar?");
                System.out.println("1 - para convertir a XML");
                System.out.println("2- para convertir a JSON");


                electionJson = scanner.nextLine();

                boolean flag2 = true;

                while (flag2)

                    if (electionJson.equalsIgnoreCase("1")) {

                        manejador.convertirXML(nuevaCiudad.toArray(Ciudad[]::new));
                        System.out.println("Archivo XML creado");
                        flag2 = false;

                    } else if (electionJson.equalsIgnoreCase("2")) {

                        manejador.convertirJSON(nuevaCiudad.toArray(Ciudad[]::new));
                        System.out.println("Archivo JSON creado");
                        flag2 = false;

                    } else {
                        System.out.println("Introduce una opcíon válido");
                        flag2 = true;
                        electionJson = scanner.nextLine();

                    }

                break;

            case "xml":


                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                CiudadHandler handler = new CiudadHandler();


                saxParser.parse(path, handler);
                Ciudad[] resutadoFinal = handler.ciudades.getXmlCiudades().toArray(Ciudad[]::new);

                System.out.println("¿Que deseas realizar?");
                System.out.println("1 - para convertir a JSON");
                System.out.println("2 - para convertir a YAML");

                System.out.println(Arrays.toString(resutadoFinal));

                String electionXML = scanner.nextLine();


                boolean flag3 = true;

                while (flag3)


                    if (electionXML.equalsIgnoreCase("1")) {


                        manejador.convertirJSON(resutadoFinal);
                        System.out.println("Archivo JSON creado");
                        flag3 = false;

                    } else if (electionXML.equalsIgnoreCase("2")) {

                        manejador.convertirYAML(resutadoFinal);
                        System.out.println("Archivo YAML creado");
                        flag3 = false;

                    } else {
                        System.out.println("Introduce una opcíon válida");
                        flag3 = true;
                        electionXML = scanner.nextLine();
                    }


                break;

            default:
                System.out.println("Ruta incorrecta!");
                break;


        }


    }


}
