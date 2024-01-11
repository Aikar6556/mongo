/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mongo;

import com.mongodb.client.*;
import org.bson.Document;

/**
 *
 * @author user
 */
public class Mongo {

    public static void main(String[] args) {

        String url ="mongodb://localhost:27017";

        //crear un cliente de conexion con MongoDB


        MongoClient mongoClient = MongoClients.create(url);
                //MongoClients.create("mongodb://127.0.0.1:27017/");

        //Crear un objeto que se conecta a una base de datos en concreto;

        MongoDatabase database = mongoClient.getDatabase("usersDB");

        //crear una colección llamada usuarios dentro de usersDB
        //database.createCollection("usuarios");

        System.out.println("Colección creada");

        MongoCollection<Document> collection = database.getCollection("usuarios");
        Document document = new Document();
        document.put("name", "Shubham");
        document.put("company", "Baeldung");


        collection.insertOne(document);


        FindIterable<Document> cursor = collection.find(document);



        try(final MongoCursor<Document> cursorIterator = cursor.cursor()){

            while (cursorIterator.hasNext()){

                System.out.println(cursorIterator.next());

            }

        }














    }
}
