package com.morhia.aggregation;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.MapreduceType;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

public class MapReduceExample2 {

	public static void main(String[] args) {
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.morhia.aggregation");
		MongoClient client = new MongoClient();
		Datastore datastore = morphia.createDatastore(client, "test");
		
		datastore.delete(datastore.find(Person.class));
		datastore.save(new Person("Fred","it","science"));
		datastore.save(new Person("Bob","sport","management","it"));
		datastore.save(new Person("John","science","it"));
		datastore.save(new Person("Bill","sport"));

		String map = "function() {"
					+ "for(var i = 0;i < this.interests.length;i++)"
					+ "  {emit(this.interests[i],1);}"
				+ "}";
		String reduce = "function(key, values) {" +
                "return Array.sum(values);}";
		Query<Person> q = datastore.find(Person.class);
		datastore.mapReduce(MapreduceType.REPLACE, q, map, reduce,null,
                null,ReduceResult.class).forEach(System.out::println);
	}
	public static class ReduceResult {
		public String _id;
		public int value;

		@Override
		public String toString() {
			return "ReduceResult [_id=" + _id + ", value=" + value + "]";
		}
	}	

}
