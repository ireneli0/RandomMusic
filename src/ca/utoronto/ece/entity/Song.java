package ca.utoronto.ece.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Entity implementation class for Entity: Song
 *
 */
@Entity(name="Song")

public class Song implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Song() {
		super();
	}
	public Song(String id){
		this.id = KeyFactory.createKey("Song", id);
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Key id;
	
	private String name;
	private String singer;
	private String image;
	private String description;

	public String getId() {
		return KeyFactory.keyToString(id);
	}
	public void setId(com.google.appengine.api.datastore.Key id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
