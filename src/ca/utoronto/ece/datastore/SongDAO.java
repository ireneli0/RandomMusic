package ca.utoronto.ece.datastore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import ca.utoronto.ece.entity.Song;
import ca.utoronto.ece.entity.User;

public class SongDAO {
	EntityManagerFactory emf = EMF.get();
	EntityManager em = null;
	
	//add new song
	public void addNewSong(String name, String singer, String image, String description){
		Song song = new Song();
		
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
	//get song by id
	public Song getSongById(String id){
		Song s;
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELCET s FROM Song WHERE id = :currentId");
			query.setParameter("currentId", id);
			query.setMaxResults(1);
			List <Song> results = (List <Song>)query.getResultList();
			s = results.get(0);
			em.getTransaction().commit();
			
		}finally{
			em.close();
			
		}
		return s;
	}
}
