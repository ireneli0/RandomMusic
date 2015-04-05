package ca.utoronto.ece.datastore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
	
}
