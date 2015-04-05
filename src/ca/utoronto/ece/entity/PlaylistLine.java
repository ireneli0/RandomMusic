package ca.utoronto.ece.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Entity implementation class for Entity: PlaylistLine
 *
 */
@Entity

public class PlaylistLine implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public PlaylistLine() {
		super();
	}
	public PlaylistLine(String id){
		this.id = KeyFactory.createKey("PlaylistLine", id);
	}
	@Id
	Key id;
	
	private Song song;
	private Playlist playlist;

	public String getId() {
		return KeyFactory.keyToString(id);
	}
	public void setId(com.google.appengine.api.datastore.Key id) {
		this.id = id;
	}
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	public Playlist getPlaylist() {
		return playlist;
	}
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
   
}
