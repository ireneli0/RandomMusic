package ca.utoronto.ece.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Song
 *
 */

@Embeddable

public class Song implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Song() {
		super();
	}
	public Song(String songId, String name, String singer, String image){
		this.songId = songId;
		this.name = name;
		this.singer = singer;
		this.image = image;
	}

	private String songId;
	private String name;
	private String singer;
	private String image;

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
	public String getSongId() {
		return songId;
	}
	public void setSongId(String songId) {
		this.songId = songId;
	}
	
}
