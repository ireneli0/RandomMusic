package ca.utoronto.ece.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity(name="User")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public User(){
		
	}
	public User(String id) {
		this.id = KeyFactory.createKey("User", id);
		
	}
   @Id
   Key id;
   
   private String name;

   public String getId() {
	   return KeyFactory.keyToString(id);
   }

   public void setId(com.google.appengine.api.datastore.Key id) {
	   this.id = id;
   }

   public String getName() {
	   return name;
   }

   public void setName(String name) {
	   this.name = name;
   }
   
   
   
}
