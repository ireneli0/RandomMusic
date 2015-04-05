package ca.utoronto.ece.datastore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import ca.utoronto.ece.entity.User;

public class UserDAO {

	EntityManagerFactory emf = EMF.get();
	EntityManager em = null;
	
	//checkUserExists
	public boolean checkUserExists(String id){
		try{
			em = emf.createEntityManager();
			User user = em.find(User.class, id);
			if(user == null)
				return false;
			else
				return true;
		}finally{
			em.close();
		}
	}
	
	//addNewUser
	public void addNewUser(String id, String name){
		User user = new User(id);
		user.setName(name);
		try{
			em = emf.createEntityManager();
			em.persist(user);
			
		}finally{
			em.close();
		}
	}	
	
	//getCurrentUserById
	public User getCurrentUserById(String id){

		User u;
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELCET u FROM User WHERE id = :currentId");
			query.setParameter("currentId", id);
			query.setMaxResults(1);
			List <User> results = (List <User>)query.getResultList();
			u = results.get(0);
			em.getTransaction().commit();
			
		}finally{
			em.close();
			
		}
		return u;
	}	
	
}
