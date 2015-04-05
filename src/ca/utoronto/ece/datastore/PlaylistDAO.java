package ca.utoronto.ece.datastore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ca.utoronto.ece.entity.Playlist;
import ca.utoronto.ece.entity.PlaylistLine;
import ca.utoronto.ece.entity.Song;
import ca.utoronto.ece.entity.User;

public class PlaylistDAO {
	EntityManagerFactory emf = EMF.get();
	EntityManager em = null;
	
	//add New Playlist
	public void addNewPlaylist(Playlist playlist){
		try{
			em = emf.createEntityManager();
			em.persist(playlist);
		}finally{
			em.close();
		}
	}
	
	//find playlist by id
	public Playlist findById(String id){
		Playlist playlist = new Playlist();
		
		
		return playlist;
		
	}
	
	//add song(playlistline) to playlist
	public void addSongToPlaylist(Song song, Playlist playlist){
		PlaylistLine playlistLine = new PlaylistLine();
		playlistLine.setSong(song);
		playlistLine.setPlaylist(playlist);
		
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Playlist pl = em.find(Playlist.class, playlist.getId());
			
			HashSet playlistLines = (HashSet)pl.getPlaylistLines();
			playlistLines.add(playlistLine);
			pl.setPlaylistLines(playlistLines);
			
			em.getTransaction().commit();
			
		}finally{
			em.close();
		}
	}
	
	//delete song(playlistline) from playlist
	public void deleteSongFromPlaylist(PlaylistLine playlistLine, Playlist playlist){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			
			
			em.getTransaction().commit();
			
		}finally{
			em.close();
		}
	}
}
