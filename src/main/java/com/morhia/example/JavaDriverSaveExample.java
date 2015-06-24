package com.morhia.example;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class JavaDriverSaveExample {
    public static void main(String[] params) {
        // connect to mongo
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
        // create object
        List<Document> phoneNumbers = new ArrayList<Document>();
        phoneNumbers.add(new Document("type", "mobile").append("number",
                "+43 123 4567890"));
        Document author = new Document("name", "Philipp")
                .append("isAlive", true)
                .append("age", 30)
                .append("height_cm", 181.5)
                .append("address",
                        new Document("city", "Vienna").append("postalCode",
                                "1190"))
                .append("phoneNumbers", phoneNumbers);
        // save
        db.getCollection("authors").insertOne(author);
    }
}
