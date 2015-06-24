package com.morhia.aggregation;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.MapreduceType;
import org.mongodb.morphia.query.Query;

public class MapReduceExample {

	public static void main(String[] args) {
		Datastore datastore = new Transactions().initObjects();
		String map = "function() {emit(this.user,this.amount)}";
		String reduce = "function(key, values) {" +
                            "return Array.sum(values);" +
                        "}";
		Query<Transaction> q = datastore.find(Transaction.class)
				.field("amount").lessThan(0);
		datastore.mapReduce(MapreduceType.REPLACE, q, map, reduce,
                null, null,	ReduceResult.class)
                .forEach(System.out::println);
	}

	public static class ReduceResult {
		public String _id;
		public double value;

		@Override
		public String toString() {
			return "ReduceResult [_id=" + _id +
                    ", value=" + value + "]";
		}
	}

}
