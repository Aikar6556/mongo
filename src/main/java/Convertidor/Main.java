package Convertidor;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String leer(File ruta) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(ruta));

        String resultadoTotal ="";
        String linea;
        while ((linea=br.readLine())!=null){

            resultadoTotal+=linea+"\n";


        }


        return resultadoTotal.replaceAll(" ","");

    }



    public static void main(String[] args) throws IOException {
        Manejador manejador = new Manejador();

        ArrayList<Ciudad> ciudades = new ArrayList<>();

        ciudades.add(new Ciudad("Cuenca",200,7,"CUE"));
        ciudades.add(new Ciudad("Ceuta",800,8,"CEU"));



        Scanner scanner = new Scanner(System.in);
        String path = "";



        System.out.println("Introduce el path");
        path = scanner.nextLine();
        File ubi = new File(path);



        String extension = ubi.getName().split("\\.")[1];
        System.out.println(extension);




        switch (extension){

            case "json":

                String contenido = leer(ubi);

                Gson gson = new Gson();
                Ciudad[] ciudads = gson.fromJson(contenido,Ciudad[].class);

                String  electionJson;

                System.out.println("¿Que deseas realizar?");
                System.out.println("1-para convertir a XML");
                System.out.println("2-para convertir a YAML");

                electionJson = scanner.nextLine();

                boolean flag = true;

                while (flag)

                if (electionJson.equalsIgnoreCase("1")){

                    manejador.convertirXML(ciudads);
                    System.out.println("Archivo XML creado");
                    flag = false;

                } else if (electionJson.equalsIgnoreCase("2")) {

                    manejador.convertirYAML(ciudads);
                    System.out.println("Archivo YAML creado");
                    flag = false;

                }else {
                    System.out.println("Introduce una opcíon válido");
                    flag = true;
                    electionJson = scanner.nextLine();



                }


                break;

            case "yaml":

                String contenidoYAML = leer(ubi);

                System.out.println(contenidoYAML);

                contenidoYAML = contenidoYAML.replaceAll("-","");
                contenidoYAML = contenidoYAML.replaceAll(":"," ");
                contenidoYAML = contenidoYAML.replaceAll(" +"," ");
                contenidoYAML = contenidoYAML.replaceAll("\t","");
                contenidoYAML = contenidoYAML.replaceAll("\n",  " ");



                System.out.println(contenidoYAML);




                System.out.println("¿Que deseas realizar?");
                System.out.println("1 - para convertir a XML");
                System.out.println("2- para convertir a JSON");
                break;

            case "xml":

                System.out.println("¿Que deseas realizar?");
                System.out.println("1 - para convertir a JSON");
                System.out.println("2- para convertir a YAML");

                break;



        }




    }







}
