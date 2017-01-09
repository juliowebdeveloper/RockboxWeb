package br.com.rockbox.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.rockbox.connection.MongoConnection;
import br.com.rockbox.model.User;

public class UserDAO {
	

private MongoDatabase database;
	
	private MongoCollection userCollection;
	
	public UserDAO (){
		database = MongoConnection.getMongoConnection();
		userCollection = database.getCollection("users");
	}
	
	public  ArrayList<User> findUsers(){
		ArrayList<User> users = new ArrayList<User>();
		
		
		FindIterable<Document> foundUsers = userCollection.find();
		
		for (Document document : foundUsers) {
			Gson gson = new Gson();
			User u = gson.fromJson(document.toJson(), User.class);
			System.out.println(u.getUsername());
			users.add(u);
		}
	
		
		return users;
	}
	
	public  User findUser(String username){
		
		FindIterable<Document> foundUsers =  userCollection.find (new Document("username",username)).limit(1);
		
		User u = new User();
		for (Document doc : foundUsers) {
			Gson gson = new Gson();
			u = gson.fromJson(doc.toJson(), User.class);
			System.out.println(u.getUsername());
	
		}

		return u;
	}
	
	
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		dao.findUsers();
	}

}
