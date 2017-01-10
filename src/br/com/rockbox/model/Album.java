package br.com.rockbox.model;

import java.util.List;

import org.mongodb.morphia.annotations.Reference;

public class Album {
	
	private String title;
	
	private String releaseDate;
	
	private List<Song> songs;
	
	@Reference
	private Band band;
	
	
	
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}
	
	
	
	

}
