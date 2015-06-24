package com.morhia.example;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.morhia.dao.EmployeesDao;
import com.morhia.entity.Employee;
import com.morhia.entity.Worker;

public class DaoExample {

	public static void main(String[] args) {
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.morhia.entity");
		MongoClient client = new MongoClient();
		Datastore datastore = morphia.createDatastore(client, "test");
		//
		EmployeesDao dao = new EmployeesDao(datastore);

		List<Employee> allEmployees = dao.getAllEmployees();
		print("All employees", allEmployees);
		List<Employee> byName = dao.findByName("Peter");
		print("By name 'Peter'", byName);
		List<Worker> allWorkers = dao.getAllWorkers();
		print("Worker only", allWorkers);
	}

	private static void print(String caption, List<? extends Employee> employees) {
		System.out.println("------------------");
		System.out.println(caption);
		employees.stream().forEach(System.out::println);

	}

}
