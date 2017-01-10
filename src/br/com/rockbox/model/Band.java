package br.com.rockbox.model;

import java.util.List;

import org.mongojack.DBRef;
import org.mongojack.Id;
import org.mongojack.ObjectId;


public class Band {

	@Id
	private ObjectId id;
		
	private String name;
	
	
	private List<Album> albums;
	
	@ObjectId
	private List<DBRef<Musician, String>> members;
	
	public Band(){}
	
	
	
	



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}



	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}
	
	
	
}
