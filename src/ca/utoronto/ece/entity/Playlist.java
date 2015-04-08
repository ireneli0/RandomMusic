package ca.utoronto.ece.entity;

import java.io.Serializable;
import java.util.Collections;
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
@Entity(name = "Playlist")

public class Playlist implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Playlist() {
		super();
	}
	public Playlist(String id){
		this.id = KeyFactory.createKey("Playlist", id);
	}	
	public Playlist(String name, String userId){
		this.name = name;
		this.userId = userId;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Key id;
	
	private String userId;
	private String name;
	
	@OneToMany(mappedBy="playlist",cascade = CascadeType.ALL) @OrderBy("id")
	private Set <PlaylistLine> playlistLines;
	
	public String getId() {
		return  KeyFactory.keyToString(id);
	}
	public void setId(com.google.appengine.api.datastore.Key id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Set<PlaylistLine> getPlaylistLines() {
		return Collections.unmodifiableSet(playlistLines);
		//return playlistLines;
	}
	public void setPlaylistLines(Set<PlaylistLine> playlistLines) {
		if (playlistLines == null){
			playlistLines = new HashSet<PlaylistLine>();
		}
//		for (PlaylistLine playlistLine : playlistLines) {
//			playlistLine.setPlaylist(this);
//		}
		this.playlistLines = playlistLines;
	}

	public void addPlaylistLine(PlaylistLine line) {
		line.setPlaylist(this);
	}
	public void removePlaylistLine(PlaylistLine line) { 
		line.setPlaylist(null);
	}

	public void internalAddPlaylistLine(PlaylistLine line) { 
		playlistLines.add(line);
	}
	public void internalRemovePlaylistLine(PlaylistLine line) { 
		playlistLines.remove(line); 
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
