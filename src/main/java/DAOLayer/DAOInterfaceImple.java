package DAOLayer;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import CurrentUser.CurrentUserId;
import DTOLayer.Address;
import DTOLayer.Admin;
import DTOLayer.Category;
import DTOLayer.Customer;
import DTOLayer.Item;
import DTOLayer.Restaurant;
import Eceptions.SomeThingWentWrong;
import EmUtils.Utility;
import ServiceLayer.LogInAndSignUp;
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
		
		String query = "SELECT c FROM Customer c";
		
		
		EntityTransaction ett = etm.getTransaction();
		try {
			
			Query q = etm.createQuery(query);
			
			List<Customer> list = q.getResultList();
			
			LogInAndSignUp L_I_S =new LogInAndSignUp();
			if(!L_I_S.checkCustomer(list, customer.getCustomerUserName())) {
				throw new SomeThingWentWrong("UserName Is Already Exits...");
			}
			
			
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
		String query = "SELECT r FROM Restaurant r";
		try {
			
			Query q = etm.createQuery(query);
			
			List<Restaurant> list = q.getResultList();
			
			LogInAndSignUp L_I_S =new LogInAndSignUp();
			if(!L_I_S.checkRestaurant(list, restaurant.getRestaurantName())) {
				throw new SomeThingWentWrong("Restaurant Name Is Already Exits...");
			}
			
			
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
		for(Item it:restaurant.getItems()) {
			items.add(it);
		}
		item.setRestaurant(restaurant);
		
		Category cat = etm.find(Category.class, (category.getCategoryName().equals("Veg")||category.getCategoryName().equals("veg"))?1:2);
		if(cat!=null) {
			Set<Item> items2 = new HashSet<Item>();
			for(Item ca: cat.getItems()) {
				items2.add(ca);
			}
			item.setCategory(cat);
			items2.add(item);
			cat.setItems(items2);
		}else {
			item.setCategory(category);
			items.add(item);
			category.setItems(items);
		}
		
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
	public List<Customer> seeCustomerDetails() throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		String query = "SELECT r FROM Customer r";
		Query q = etm.createQuery(query);
		try {
			List<Customer> customer=q.getResultList();
			return customer;
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured In Fetching Customers...");
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
		
		Query q= etm.createQuery("SELECT a FROM Admin a");
		List<Admin> admins = q.getResultList();
		for(Admin ad :admins) {
			if((ad.getAdminUserName().equals(admin.getAdminUserName()))&& admin.getActive()==true) {
				throw new SomeThingWentWrong("Choose different username admin...");
			}
		}
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

	
	
	
	
	
	
	
	
//	::::Customer Fuctionality::::
	
	
	
	

	@Override
	public List<Restaurant> ListOfRestaurantAndFoodItems() throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		String query = "SELECT r FROM Restaurant r";
		Query q = etm.createQuery(query);
		try {
			List<Restaurant> restaurant=q.getResultList();
			return restaurant;
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Error Occured In Fetching Restaurant...");
		}finally {
			etm.close();
		}
	}


	@Override
	public void changeEmail(String email) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Customer customer=etm.find(Customer.class, CurrentUserId.getId());
		if(customer==null || customer.getActive()!=true) {
			throw new SomeThingWentWrong("No Customer Found");
		}
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			etm.merge(customer);
			customer.setCustomerEmail(email);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to update...");
		}finally {
			etm.close();
		}
		
	}


	@Override
	public void changeAddress(Address add) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Customer customer=etm.find(Customer.class, CurrentUserId.getId());
		if(customer==null || customer.getActive()!=true) {
			throw new SomeThingWentWrong("No Customer Found");
		}
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			etm.merge(customer);
			customer.setAddress(add);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to update...");
		}finally {
			etm.close();
		}
	}


	@Override
	public void changePassword(String pass) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Customer customer=etm.find(Customer.class, CurrentUserId.getId());
		if(customer==null || customer.getActive()!=true) {
			throw new SomeThingWentWrong("No Customer Found");
		}
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			etm.merge(customer);
			customer.setCustomerPassword(pass);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to update...");
		}finally {
			etm.close();
		}
	}


	@Override
	public void changeMobilenumber(String number) throws SomeThingWentWrong {
		EntityManager etm = Utility.getManager();
		Customer customer=etm.find(Customer.class, CurrentUserId.getId());
		if(customer==null || customer.getActive()!=true) {
			throw new SomeThingWentWrong("No Customer Found");
		}
		EntityTransaction ett = etm.getTransaction();
		ett.begin();
		try {
			etm.merge(customer);
			customer.setCustomerMobileNumber(number);
			ett.commit();
		}catch(PersistenceException e) {
			throw new SomeThingWentWrong("Not able to update...");
		}finally {
			etm.close();
		}
	}


	@Override
	public void addToCart(int id) throws SomeThingWentWrong {
//		EntityManager etm = Utility.getManager();
//		Item item=etm.find(Item.class, id);
//		if(item==null || item.getActive()!=true) {
//			throw new SomeThingWentWrong("No Customer Found");
//		}
//		Customer customer = etm.find(Customer.class, CurrentUserId.getId());
//		CustomerFoodCart cfc = customer.getCustomerFoodCart();
//		
//		Set<Order> order = new HashSet<>();
//		for(Order or : cfc.getOrders()) {
//			order.add(or);
//		}
//		
//		
//		EntityTransaction ett = etm.getTransaction();
//		ett.begin();
//		try {
//			
//			ett.commit();
//		}catch(PersistenceException e) {
//			throw new SomeThingWentWrong("Not able to update...");
//		}finally {
//			etm.close();
//		}
		
	}


	
	
}
