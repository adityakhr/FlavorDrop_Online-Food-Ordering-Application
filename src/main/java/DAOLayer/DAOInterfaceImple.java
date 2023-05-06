package DAOLayer;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DTOLayer.Admin;
import DTOLayer.Category;
import DTOLayer.Customer;
import DTOLayer.Item;
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
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured...");
		}finally {
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
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured...");
		}finally {
			etm.close();
		}
	}



	@Override
	public void addAnItemToRestaurant(Category category, Item item, int restaurantId) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Restaurant restaurant=etm.find(Restaurant.class, restaurantId);
		if(restaurant==null || restaurant.getActive()!=true) {
			throw new SomeThingWentWrong("No Restaurant Found");
		}
		Set<Item> items = new HashSet<Item>();
		item.setRestaurant(restaurant);
		item.setCategory(category);
		
		items.add(item);
	
		category.setItems(items);
		
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			etm.merge(restaurant);
			restaurant.setItems(items);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to add...");
		}finally {
			etm.close();
		}
	}


	@Override
	public void deleteRestaurent(int id) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Restaurant restaurant=etm.find(Restaurant.class, id);
		if(restaurant==null || restaurant.getActive()!=true) {
			throw new SomeThingWentWrong("No Restaurant Found");
		}
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			restaurant.setActive(false);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to delete...");
		}finally {
			etm.close();
		}
	}


	@Override
	public void deleteItem(int id) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Item item=etm.find(Item.class, id);
		if(item==null || item.getActive()!=true) {
			throw new SomeThingWentWrong("No Food Found");
		}
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			item.setActive(false);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to delete...");
		}finally {
			etm.close();
		}
		
	}


	@Override
	public void deleteCustomer(int id) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Customer customer=etm.find(Customer.class, id);
		if(customer==null || customer.getActive()!=true) {
			throw new SomeThingWentWrong("No Customer Found");
		}
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			customer.SetActive(false);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to delete...");
		}finally {
			etm.close();
		}
		
	}
	@Override
	public void addAdmin(Admin admin) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			etm.persist(admin);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to add the admin...");
		}finally {
			etm.close();
		}
		
	}

	@Override
	public void deleteAdmin(int id) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Admin admin=etm.find(Admin.class, id);
		if(admin==null || admin.getActive()!=true) {
			throw new SomeThingWentWrong("No Admin Found");
		}
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			admin.setActive(false);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to delete...");
		}finally {
			etm.close();
		}
		
	}
	
}
