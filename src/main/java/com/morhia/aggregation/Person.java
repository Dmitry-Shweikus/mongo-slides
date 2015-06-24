package com.morhia.aggregation;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(noClassnameStored = true)
public class Person {
	@Id
	public ObjectId id;

	public String name;

	public String[] interests;

	public Person(String name, String... interests) {
		super();
		this.name = name;
		this.interests = interests;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", interests="
				+ Arrays.toString(interests) + "]";
	}
	
}
