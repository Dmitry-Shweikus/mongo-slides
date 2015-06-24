package com.morhia.example;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.morhia.entity.antijoin.BankAccount;
import com.morhia.entity.antijoin.Company;
import com.morhia.entity.antijoin.EmployeeExtended;

public class AntiJoinExample {

	public static void main(String[] args) {
		final Morphia morphia = new Morphia();
		morphia.mapPackage("com.morhia.entity.antijoin");
		final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
        datastore.find(EmployeeExtended.class).getCollection().drop();
        datastore.find(Company.class).getCollection().drop();
		//company
		Company company = new Company("IBM");
		datastore.save(company);
		//Peter
		EmployeeExtended employee = new EmployeeExtended();
		employee.setName("Peter");
		employee.setCompany(company);
		employee.setBankAccount(new BankAccount("123456789"));
		
		datastore.save(employee);
		
		//John
		employee = new EmployeeExtended();
		employee.setName("John");
		employee.setCompany(company);
		employee.setBankAccount(new BankAccount("1111111111"));

        Key<EmployeeExtended> saved = datastore.save(employee);
        employee = datastore.getByKey(EmployeeExtended.class, saved);
        System.out.println(employee);
    }

}
