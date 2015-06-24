package com.morhia.aggregation;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "transactions", noClassnameStored = true)
public class Transaction {
    @Id
    ObjectId id;
    String user = "";
    int amount;
    String type = "";

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", user=" + user +
                ", amount=" + amount + ", type=" + type + "]";
    }

    public Transaction(String user, int amount, String type) {
        super();
        this.user = user;
        this.amount = amount;
        this.type = type;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
