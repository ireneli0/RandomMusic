package ca.utoronto.ece.datastore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import ca.utoronto.ece.entity.Playlist;
import ca.utoronto.ece.entity.PlaylistLine;
import ca.utoronto.ece.entity.Song;

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

	
	//add song(playlistline) to playlist
	public void addSongToPlaylist(String songId, Playlist playlist){
		PlaylistLine playlistLine = new PlaylistLine();
		//playlistLine.setSong(songId);
		playlistLine.setPlaylist(playlist);
		
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Playlist pl = em.find(Playlist.class, playlist.getId());
			pl.getPlaylistLines().add(playlistLine);
			
			em.getTransaction().commit();
			
		}finally{	
			em.close();
		}
	}
	
	//find all playlists by user id
	public List<Playlist> findAllPlaylistsByUserId(String id){
		List<Playlist> results = null;
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT p from Playlist p WHERE userId = :currentUserId");
			query.setParameter("currentUserId", id);
			results = (List<Playlist>)query.getResultList();
			
			em.getTransaction().commit();
		}finally{
			em.close();
		}
		return results;
	}
	
	//find all songs by playlist
	public List<Song> findAllSongsByPlaylist(Playlist playlist){
		List<Song> songs = null;
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT p from PlaylistLine p WHERE playlist = :currentPlaylist");
			query.setParameter("currentPlaylist", playlist);
			List <PlaylistLine>results = (List<PlaylistLine>)query.getResultList();
			for(PlaylistLine p :results){
				songs.add(p.getSong());
			}
			
			em.getTransaction().commit();
		}finally{
			em.close();
		}
		return songs;
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
	
	//find all playlist by user id
	public Playlist findById(String id){
		Playlist playlist = new Playlist();
		
		
		return playlist;
		
	}
}
