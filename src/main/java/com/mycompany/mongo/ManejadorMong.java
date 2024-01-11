package com.mycompany.mongo;

import com.mongodb.client.*;
import org.bson.Document;

public class ManejadorMong {

    String url ="mongodb://localhost:27017";

    MongoClient mongoClient;

    MongoDatabase database;

    MongoCollection<Document> collection;



    public void conexion(){

        // Conectar con la base de datos
        mongoClient = MongoClients.create(url);


    }

    public void crearBD(String nombre){

        database = mongoClient.getDatabase(nombre);


    }

    public void crearColection(String nombre){

        database.createCollection(nombre);

    }

    public void insertar(String tabla, Document d){

        collection = database.getCollection(tabla);
        collection.insertOne(d);

    }

    public void update(Document original, Document modificado, String tabla){
        collection = database.getCollection(tabla);

        Document updateObject = new Document();

        updateObject.put("$set",modificado);

        collection.updateOne(original,updateObject);

    }

    /*
    public Document read(Document document){


        return FindIterable<Document> cursor = collection.find(document);





    }

     */




}
