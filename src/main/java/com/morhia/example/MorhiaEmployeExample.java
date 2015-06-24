package com.morhia.example;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.morhia.entity.Employee;
import com.morhia.entity.Manager;
import com.morhia.entity.Worker;

public class MorhiaEmployeExample {

	public static void main(String[] args) {
		final Morphia morphia = new Morphia();
		morphia.mapPackage("com.morhia.entity");
        MongoClient client = new MongoClient();
        final Datastore datastore =
                morphia.createDatastore(client, "test");
		datastore.delete(datastore.find(Employee.class));
		
		//
		Manager manager = new Manager();
		manager.setName("Peter");
		manager.setApproveFunds(true);
		
		Worker worker = new Worker();
		worker.setName("Philipp");
		worker.setYearsExperience(10);
		
		Worker withoutExperience = new Worker();
		withoutExperience.setName("New worker");
		
		datastore.save(manager, worker, withoutExperience);
	}

}
