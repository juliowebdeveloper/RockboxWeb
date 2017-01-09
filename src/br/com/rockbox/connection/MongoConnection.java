package br.com.rockbox.connection;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {


	private static MongoDatabase database;


	public synchronized static MongoDatabase getMongoConnection(){
		if(database !=null){
			return database;
		}

		MongoCredential credential = MongoCredential.createCredential(
				"rockbox", "rockbox",
				"rockbox".toCharArray());
		MongoClient c = new MongoClient(new ServerAddress("ds035673.mlab.com:35673"), Arrays.asList(credential));
		database = c.getDatabase("rockbox");
		return database;


	}

	public static void main(String[] args) {
		getMongoConnection();
		MongoCollection<Document> collection = database.getCollection("users");
		FindIterable<Document> docs = collection.find();
		for (Document document : docs) {
			System.out.println(document);
		}
	}

}
