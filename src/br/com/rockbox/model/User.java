package br.com.rockbox.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

@XmlRootElement(name="user")
public class User {
	
	
	@Id
	private ObjectId id;
	
	private String username;
	
	private String name;
	
	private List<Band> bands ;
	
	public User(){
		
	}
	
	
	
	public User(String username, String name, List<Band> bands) {
		super();
		this.username = username;
		this.name = name;
		this.bands = bands;
	}






	public List<Band> getBands() {
		return bands;
	}



	public void setBands(List<Band> bands) {
		this.bands = bands;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", bands=" + bands + "]";
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public ObjectId getId() {
		return id;
	}



	public void setId(ObjectId id) {
		this.id = id;
	}
	
	
	

}
