package DAOLayer;


import java.util.List;
import DTOLayer.Admin;
import DTOLayer.Customer;
import DTOLayer.Restaurant;
import Eceptions.SomeThingWentWrong;
import EmUtils.Utility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class DAOInterfaceImple implements DAOInterface {

	@Override
	public List<Admin> checkAdminLogIn() throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		List<Admin> admins = null;
		try {
			String query = "SELECT a FROM Admin a";
			Query q= etm.createQuery(query);
			admins=q.getResultList();
			if(admins==null) {
				throw new SomeThingWentWrong("No Admin Found...");
			}
			return admins;
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured...");
		}finally {
			etm.close();
		}
	}
	
	
	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		EntityTransaction ett = etm.getTransaction();
		try {
			ett.begin();
			etm.persist(customer);
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured...");
		}finally {
			ett.commit();
			etm.close();
		}
	}
	
	
	@Override
	public List<Customer> checkCustomerLogIn() throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		List<Customer> customers = null;
		try {
			String query = "SELECT a FROM Customer a";
			Query q= etm.createQuery(query);
			customers=q.getResultList();
			if(customers==null) {
				throw new SomeThingWentWrong("No Admin Found...");
			}
			return customers;
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured...");
		}finally {
			etm.close();
		}
	}


	@Override
	public void addRestaurent(Restaurant restaurant) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		EntityTransaction ett = etm.getTransaction();
		try {
			ett.begin();
			etm.persist(restaurant);
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured...");
		}finally {
			ett.commit();
			etm.close();
		}
	}


	@Override
	public Restaurant findRestaurant(int id) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		try {
			Restaurant restaurant=etm.find(Restaurant.class, id);
			if(restaurant==null) {
				throw new SomeThingWentWrong("No Restaurant Found");
			}
			return restaurant;
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured...");
		}finally {
			etm.close();
		}
	}
	
}
