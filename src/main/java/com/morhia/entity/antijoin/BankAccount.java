package com.morhia.entity.antijoin;


public class BankAccount {
	String account;

	public BankAccount() {
		super();
	}

	public BankAccount(String account) {
		super();
		this.account = account;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

    @Override
    public String toString() {
        return "BankAccount{" +
                "account='" + account + '\'' +
                '}';
    }
}
