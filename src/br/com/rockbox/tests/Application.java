package br.com.rockbox.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.rockbox.dao.BandDAO;
import br.com.rockbox.dao.MusicianDAO;
import br.com.rockbox.model.Album;
import br.com.rockbox.model.Band;
import br.com.rockbox.model.Song;

public class Application {
	
	public static void main(String[] args) {
			BandDAO dao = new BandDAO();
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
			//dao.insertBandAsDocument(band);
			
			List<Band> bands = dao.findAll();
			for (Band banda : bands) {
					for (Album aw : banda.getAlbums()) {
						
						System.out.println("Album Title : " +aw.getTitle());
						System.out.println("Songs for this album: ");
						for (Song song : aw.getSongs()) {
							
							System.out.println("Song title: "+song.getTitle());
						}
						
						
					}
			}
			
			MusicianDAO mdao = new MusicianDAO();
			//mdao.saveMusician();
		
	}
	

}
