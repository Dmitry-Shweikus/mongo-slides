package com.morhia.example;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.morhia.entity.Address;
import com.morhia.entity.Author;
import com.morhia.entity.PhoneNumber;

public class MorhiaSaveExample {
	public static void main(String[] params) {
		final Morphia morphia = new Morphia();
		morphia.mapPackage("com.morhia.entity");
		MongoClient client = new MongoClient();
		final Datastore datastore = morphia.createDatastore(client, "test");
		//
		Address address = new Address();
		address.setCity("Vienna");
		address.setPostalCode("1190");

		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setNumber("+43 123 4567890");
		phoneNumber.setType("mobile");

		Author author = new Author();
		author.setName("Philipp");
		author.setAlive(true);
		author.setAge(30);
		author.setHeight(181.5);
		author.setAddress(address);
		author.getPhoneNumbers().add(phoneNumber);

		datastore.save(author);
	}
}
