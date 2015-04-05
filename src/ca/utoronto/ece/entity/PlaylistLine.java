package ca.utoronto.ece.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Entity implementation class for Entity: PlaylistLine
 *
 */
@Entity(name = "PlaylistLine")

public class PlaylistLine implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public PlaylistLine() {
		super();
	}
	public PlaylistLine(String id){
		this.id = KeyFactory.createKey("PlaylistLine", id);
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Key id;
	
	private String songId;
	private String playlistId;

	public String getId() {
		return KeyFactory.keyToString(id);
	}
	public void setId(com.google.appengine.api.datastore.Key id) {
		this.id = id;
	}
	public String getSongId() {
		return songId;
	}
	public void setSongId(String songId) {
		this.songId = songId;
	}
	public String getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}
   
}
