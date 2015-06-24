package com.morhia.entity.antijoin;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;


@Entity("employes")
public class EmployeeExtended {
	@Id
	protected ObjectId id;
	
	String name;

    @Reference(lazy = true)
	Company company;

	@Embedded
	BankAccount bankAccount;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

    @Override
    public String toString() {
        return "EmployeeExtended{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
