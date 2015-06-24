package com.morhia.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;

import com.morhia.entity.Employee;
import com.morhia.entity.Worker;

public class EmployeesDao {
    Datastore datastore;

    public EmployeesDao(Datastore datastore) {
        this.datastore = datastore;
    }

    public List<Employee> getAllEmployees() {
        return datastore.find(Employee.class).asList();
    }

    public List<Employee> findByName(String name) {
        return datastore.find(Employee.class).field("name").
                equal(name).asList();
    }

    public List<Worker> getAllWorkers() {
        return datastore.find(Worker.class).disableValidation().
                field("className").equal(Worker.class.getName()).
                asList();
    }


}
