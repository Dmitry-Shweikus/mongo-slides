package com.morhia.example;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.morhia.entity.Versioned;

public class VersionedExample {

    public static void main(String[] args) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.morhia.entity");
        Datastore datastore =
                morphia.createDatastore(new MongoClient(),
                        "test");
        //
        datastore.delete(datastore.find(Versioned.class));
        Versioned versioned = new Versioned();
        versioned.setName("bob");
        datastore.save(versioned);
        System.out.println(versioned.getVersion());//1
        datastore.save(versioned);
        System.out.println(versioned.getVersion());//2
        versioned.setVersion(versioned.getVersion()-1);
        System.out.println(versioned.getVersion());//1
        datastore.save(versioned);
    }
}
