package com.morhia.aggregation;

import java.util.Arrays;

import org.bson.BsonDocument;
import org.mongodb.morphia.Datastore;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class SinglePurposeAggregationExample {
    public static void main(String[] params) {
        Datastore datastore = new Transactions().initObjects();
        // count
        long u1NegativeTransactions = datastore
                .getCollection(Transaction.class)
                .count(new BasicDBObject("user", "u1").
                        append("amount",
                                new BasicDBObject("$lt", 0)));
        System.out.println(u1NegativeTransactions);
        // distinct
        Object[] allUsers =
                datastore
                        .getCollection(Transaction.class)
                        .distinct("user").toArray();
        System.out.println(Arrays.toString(allUsers));

        // group #1
        String reduce = "function(cur, result) { " +
                "result.amount += cur.amount " +
                "}";
        DBObject group = datastore
                .getCollection(Transaction.class)
                .group(
                        new BasicDBObject("user", "1"),
                        new BasicDBObject("type",
                                Transactions.INCOME),
                        new BasicDBObject("amount", 0),
                        reduce);
        System.out.println(group.toString());
        // group #2
        reduce = "function(cur, result) { " +
                "result.amount += cur.amount;" +
                "result.type += cur.type + \" \"; " +
                "}";
        group = datastore.getCollection(Transaction.class).group(
                new BasicDBObject("user", "1"),
                new BasicDBObject("amount",
                        new BasicDBObject("$lt", 0)),
                new BasicDBObject("amount", 0)
                        .append("type", ""),
                reduce);
        System.out.println(group.toString());

    }
}
