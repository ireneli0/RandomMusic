package ca.utoronto.ece.datastore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ca.utoronto.ece.entity.Song;

public class SongDAO {
	EntityManagerFactory emf = EMF.get();
	EntityManager em = null;
	
	//add new song
	public void addNewSong(String id, String name, String singer, String image, String description){
		Song song = new Song(id);
		
		song.setName(name);
		song.setSinger(singer);
		song.setImage(image);
		song.setDescription(description);
		
		try{
			em = emf.createEntityManager();
			em.persist(song);
		}finally{
			em.close();
		}
	}
}
