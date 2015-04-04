package ca.utoronto.ece.entity;

public class PlaylistLine {
	private String id;
	private Song song;
	private Playlist playlist;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
