package EmUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Utility {
	static EntityManagerFactory con;
	static {
		con = Persistence.createEntityManagerFactory("flavorDrop");
	}
	public static EntityManager getManager() {
		return con.createEntityManager();
	}
}
