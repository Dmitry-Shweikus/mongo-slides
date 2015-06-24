package com.morhia.aggregation.utils;

import java.util.Arrays;

public class AggregatedTransactionEx extends AggregatedTransaction {

	String[] types; 
	String user;
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	@Override
	public String toString() {
		return "Tx [types=" + Arrays.toString(types)
				+ ", user=" + user + ", _id=" + _id + ", amount=" + amount
				+ "]";
	}
	
	

}
