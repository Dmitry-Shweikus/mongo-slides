package com.morhia.aggregation;

import static org.mongodb.morphia.aggregation.Group.addToSet;
import static org.mongodb.morphia.aggregation.Group.grouping;
import static org.mongodb.morphia.aggregation.Group.sum;
import static org.mongodb.morphia.aggregation.Group.first;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.aggregation.Sort;

import com.morhia.aggregation.utils.AggregatedTransaction;
import com.morhia.aggregation.utils.AggregatedTransactionEx;

public class AggregationExample {

	public static void main(String[] args) {
		Datastore ds = new Transactions().initObjects();
		// example #1
		System.out.println("Example #1");
		ds.createAggregation(Transaction.class)
				.group("user", grouping("amount", sum("amount")))
				.sort(Sort.ascending("_id"))
				.aggregate(AggregatedTransaction.class)
				.forEachRemaining(System.out::println);
		// example #2
		System.out.println("Example #2");
		ds.createAggregation(Transaction.class)
				.match(ds.find(Transaction.class)
                        .field("amount").lessThan(0))
				.group("user", grouping("amount", sum("amount")),
						grouping("types", addToSet("type")),
						grouping("user", first("user")))
				.sort(Sort.ascending("_id"))
				.out(AggregatedTransactionEx.class)
				.forEachRemaining(System.out::println);
	}

}
