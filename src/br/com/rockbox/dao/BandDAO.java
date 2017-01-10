package br.com.rockbox.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.rockbox.connection.MongoConnection;
import br.com.rockbox.model.Album;
import br.com.rockbox.model.Band;
import br.com.rockbox.model.Song;

public class BandDAO {
	private MongoDatabase database;

	private MongoCollection bandsCollection;
	
	private Morphia morphia = new Morphia();
	
	private Datastore datastore;
	
	public BandDAO (){
		
		database = MongoConnection.getMongoConnection();
		bandsCollection = database.getCollection("bands");
		morphia.mapPackage("br.com.rockbox.model");
		MongoCredential credential = MongoCredential.createCredential(
				"rockbox", "rockbox",
				"rockbox".toCharArray());
		MongoClient c = new MongoClient(new ServerAddress("ds035673.mlab.com:35673"), Arrays.asList(credential));
	
		datastore = morphia.createDatastore(c, "rockbox");
		datastore.ensureIndexes();
		
	}
	
	public void insertBand(){
		Band band = new Band();
		band.setName("AC/DC");
		List<Album> albuns = new ArrayList<Album>();
		Album a = new Album();
		a.setBand(band);
		a.setTitle("High Voltage");
		a.setReleaseDate("17/02/1975");
		
		List<Song> songs = new ArrayList<Song>();
		songs.add(new Song("Baby please don't go"));
		songs.add(new Song("She's Got Balls"));
		songs.add(new Song("Little Lover"));
		songs.add(new Song("Stick Around" ));
		songs.add(new Song("Soul Stripper" ));
		songs.add(new Song("You Ain't Got a Hold on Me"));
		songs.add(new Song("Love Song"));
		songs.add(new Song("Show Business"));
		
		a.setSongs(songs);
		albuns.add(a);
		band.setAlbums(albuns);
		/*List<Musician> musicians = new ArrayList<Musician>();
		musicians.add(new Musician("Bon Scott","12/05/1950", "12/05/1970"));
		musicians.add(new Musician("Angus Young","12/05/1950", null));
		musicians.add(new Musician("Malcom Young","12/05/1950", "12/05/1970"));
		band.setMembers(musicians);*/
		datastore.save(band);
	}
	
	public List<Band> findAll(){
		System.out.println("Findall");
		List<Band> bands = new ArrayList<Band>();
		FindIterable<Document> foundUsers = bandsCollection.find();

		for (Document document : foundUsers) {
			Gson gson = new Gson();
			Band b = gson.fromJson(document.toJson(), Band.class);
			System.out.println(b.getId());
			bands.add(b);
		}

			return bands;
	}	
	
	
	public void insertBandAsDocument(Band band){
		List<Document> albunsDocument = new ArrayList<Document>();
		for (Album a: band.getAlbums()) {
			albunsDocument.add(new Document("title", a.getTitle()));
		}
		Document bandDocument = new Document();
		bandDocument.put("name", band.getName());
		bandDocument.put("albums", albunsDocument);
		bandsCollection.insertOne(bandDocument);
	}
	
	
	
	
	
	}
