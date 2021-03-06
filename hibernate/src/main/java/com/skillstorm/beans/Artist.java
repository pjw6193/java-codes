package com.skillstorm.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // manage this entity (keep the mapping in memory)
@Table(name="Artist")
public class Artist {

	@Id // Primary Key
	@Column(name="ArtistId") // use the Java property as the database column name
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK is generated by the database (stmt.getGeneratedKeys)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	// fetchType (LAZY, EAGER) - query for an artist, will I get the associated albums? EAGER yes, LAZY join
	@OneToMany(mappedBy = "artist") // owner is the other field
	private Set<Album> albums; // the other side (inverse)

	public Artist() {
		super();
	}
	
///////////////////////////
	public Artist(String name) {
		super();
		this.name = name;
	}

	public Artist(int artistId, String name) {
		super();
		this.id = artistId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int artistId) {
		this.id = artistId;
	}
///////////////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + id + ", name=" + name + "]";
	}

}
