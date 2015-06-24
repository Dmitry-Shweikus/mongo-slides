package com.morhia.aggregation;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class Transactions {
	public static final String WITHDRAWAL = "withdrawal";
	public static final String FEE = "fee";
	public static final String EXPENSE = "expense";
	public static final String INCOME = "income";
	public Datastore initObjects() {
        Datastore datastore = getDatastore();
		datastore.delete(datastore.find(Transaction.class));
		datastore.save(new Transaction("u1", 100, INCOME));
		datastore.save(new Transaction("u1", -15, EXPENSE));
		datastore.save(new Transaction("u1", -10, EXPENSE));
		datastore.save(new Transaction("u1", -5, EXPENSE));
		datastore.save(new Transaction("u1", -20, WITHDRAWAL));
		datastore.save(new Transaction("u1", -20, FEE));

		datastore.save(new Transaction("u2", 70, INCOME));
		datastore.save(new Transaction("u2", 80, INCOME));
		datastore.save(new Transaction("u2", -50, EXPENSE));
		datastore.save(new Transaction("u2", -30, WITHDRAWAL));
		datastore.save(new Transaction("u2", -20, FEE));

		datastore.save(new Transaction("u3", 50, INCOME));
		datastore.save(new Transaction("u3", -50, EXPENSE));
		datastore.save(new Transaction("u3", -30, WITHDRAWAL));
		datastore.save(new Transaction("u3", -10, FEE));
		
		return datastore;
	}

    private Datastore getDatastore() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.morhia.aggregation");
        MongoClient client = new MongoClient();
        return morphia.createDatastore(client, "test");
    }
}
