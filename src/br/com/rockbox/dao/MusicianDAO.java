package br.com.rockbox.dao;

import java.util.Arrays;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import br.com.rockbox.model.Musician;

public class MusicianDAO {
	
	
	private Morphia morphia = new Morphia();
	
	private Datastore datastore;
	
	public MusicianDAO (){
		
		morphia.mapPackage("br.com.rockbox.model");
		MongoCredential credential = MongoCredential.createCredential(
				"rockbox", "rockbox",
				"rockbox".toCharArray());
		MongoClient c = new MongoClient(new ServerAddress("ds035673.mlab.com:35673"), Arrays.asList(credential));
	
		datastore = morphia.createDatastore(c, "rockbox");
		datastore.ensureIndexes();
		
	}
	
	public void saveMusician(){
		final Musician bonScott = new Musician("Bon Scott", "12/04/1930","12/04/1970");
		datastore.save(bonScott);
	}
	
	

}
