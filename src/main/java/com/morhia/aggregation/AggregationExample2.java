package com.morhia.aggregation;

import java.util.Arrays;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import static org.mongodb.morphia.aggregation.Group.*;
import static org.mongodb.morphia.aggregation.Projection.*;
import org.mongodb.morphia.aggregation.Sort;

import com.mongodb.MongoClient;

public class AggregationExample2 {
    public static void main(String[] args) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.morhia.aggregation");
        MongoClient client = new MongoClient();
        Datastore datastore = morphia.createDatastore(client, "test");

        datastore.getDB().getCollection("Person").drop();
        datastore.save(new Person("Fred", "it", "science"));
        datastore.save(new Person("Bob", "sport", "management", "it"));
        datastore.save(new Person("John", "science", "it"));
        datastore.save(new Person("Bill", "sport"));

        datastore
                .createAggregation(Person.class)
                .unwind("interests")
                .project(
                        projection("name"),
                        projection("interests"),
                        projection("count",add(1)))
                .group("interests",
                        grouping("count", sum("count")),
                        grouping("names", push("name")),
                        grouping("interest", first("interests")))
                .sort(new Sort("count", -1))
                .out(Interest.class).
                forEachRemaining(System.out::println);
    }
    public static class Interest {
        public Long count;
        public String interest;
        public String[] names;

        @Override
        public String toString() {
            return "Interest [count=" + count + ", interest=" + interest
                    + ", users=" + Arrays.toString(names) + "]";
        }

    }

}
