package br.com.rockbox.model;

import org.bson.types.ObjectId;
import org.mongojack.Id;
import org.mongojack.MongoCollection;

@MongoCollection(name="musicians")
public class Musician {

	@Id
	private ObjectId id;
	
	private String name;
	
	private String birthDate;
	
	private String deathDate;
	
	public Musician(){}
	
	
	public Musician(String name, String birthDate, String deathDate) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}


	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}
	
	
	
}
