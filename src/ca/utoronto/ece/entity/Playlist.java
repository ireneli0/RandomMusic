package ca.utoronto.ece.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Entity implementation class for Entity: Playlist
 *
 */
@Entity

public class Playlist implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Playlist() {
		super();
	}
	public Playlist(String id){
		this.id = KeyFactory.createKey("Playlist", id);
	}
	
	@Id
	Key id;
	
	private User user;
	private Set playlistLines = new HashSet();
	
	public String getId() {
		return KeyFactory.keyToString(id);
	}
	public void setId(com.google.appengine.api.datastore.Key id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set getPlaylistLines() {
		return playlistLines;
	}
	public void setPlaylistLines(Set playlistLines) {
		this.playlistLines = playlistLines;
	}
	
	public int getCount(){
		int count = 0;
		Iterator it = playlistLines.iterator();
		while(it.hasNext()){
			PlaylistLine line = (PlaylistLine) it.next();
			count ++;
		}
		return count;
	}
}
