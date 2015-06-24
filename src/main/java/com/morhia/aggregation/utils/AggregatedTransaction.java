package com.morhia.aggregation.utils;

import java.util.Arrays;

public class AggregatedTransaction {
	String _id;
	double amount;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	@Override
	public String toString() {
		return "AggregatedTransaction [_id=" + _id + ", amount=" + amount + "]";
	}
}
