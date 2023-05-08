package ServiceLayer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import CurrentUser.CurrentUserId;
import DAOLayer.DAOInterfaceImple;
import DTOLayer.Address;
import DTOLayer.Admin;
import DTOLayer.Category;
import DTOLayer.Customer;
import DTOLayer.Item;
import DTOLayer.Restaurant;
import Eceptions.SomeThingWentWrong;

public class LogInAndSignUp {
	public void checkAdminCreadetials(String userName, String password ) throws SomeThingWentWrong{
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			List<Admin> admins =D_I_I.checkAdminLogIn();
			userName=userName.trim();
			password=password.trim();
			String capitalUserName = "";
			for(int i =0 ; i<userName.length(); ++i ){
				if(Character.isAlphabetic(userName.charAt(i))) {
					capitalUserName+=(Character.toUpperCase(userName.charAt(i)));
				}else {
					capitalUserName+=(userName.charAt(i));
				}
			}
			int count=0;
			for(Admin ad: admins) {
				String capitalAdminUserName = "";
				for(int i =0 ; i<ad.getAdminUserName().length(); ++i ){
					if(Character.isAlphabetic(ad.getAdminUserName().charAt(i))) {
						capitalAdminUserName+=(Character.toUpperCase(ad.getAdminUserName().charAt(i)));
					}else {
						capitalAdminUserName+=(ad.getAdminUserName().charAt(i));
					}
				}
				if(capitalUserName.equals(capitalAdminUserName) && password.equals(ad.getAdminPassword())) {
					++count;
					if(ad.getActive()!=true) {
						throw new SomeThingWentWrong("No admin registered with these credentials...");
					}
					CurrentUserId.setId(ad.getAdminId());
					CurrentUserId.setName(ad.getAdminFullName());
				}
			}
			if (count==0){
				throw new SomeThingWentWrong("No admin registered with these credentials...");
			}
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	
	
	
	public void checkCustomerCreadetials(String userName, String password ) throws SomeThingWentWrong {
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			List<Customer> customers =D_I_I.checkCustomerLogIn();
			userName=userName.trim();
			password=password.trim();
			String capitalUserName = "";
			for(int i =0 ; i<userName.length(); ++i ){
				if(Character.isAlphabetic(userName.charAt(i))) {
					capitalUserName+=(Character.toUpperCase(userName.charAt(i)));
				}else {
					capitalUserName+=(userName.charAt(i));
				}
			}
			int count=0;
			for(Customer ad: customers) {
				String capitalCustomerUserName = "";
				for(int i =0 ; i<ad.getCustomerUserName().length(); ++i ){
					if(Character.isAlphabetic((ad.getCustomerUserName().charAt(i)))) {
						capitalCustomerUserName+=(Character.toUpperCase(ad.getCustomerUserName().charAt(i)));
					}else {
						capitalCustomerUserName+=(ad.getCustomerUserName().charAt(i));
					}
				}
				if(capitalUserName.equals(capitalCustomerUserName) && password.equals(ad.getCustomerPassword())) {
					++count;
					if(ad.getActive()==false) {
						throw new SomeThingWentWrong("No customer registered with these credentials...");
					}
					CurrentUserId.setId(ad.getCustomerId());
					CurrentUserId.setName(ad.getCustomerFirstName()+" "+ad.getCustomerLastName());
				}
			}
			if (count==0){
				throw new SomeThingWentWrong("No customer registered with these credentials...");
			}
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	
	public boolean checkCustomer(List<Customer>list, String userName) {
		for(Customer cu: list) {
			if(cu.getCustomerUserName().equals(userName)) {
				return false;
			}
		}
		return true;
	}
	public void customerSignUp(Customer customer) throws SomeThingWentWrong{
		if(customer.getCustomerMobileNumber().length()!=10) {
			throw new SomeThingWentWrong("Mobile number is not valid...");
		}
		for(int i=0 ; i<customer.getCustomerMobileNumber().length();++i) {
			if(!(Character.isDigit(customer.getCustomerMobileNumber().charAt(i)))) {
				throw new SomeThingWentWrong("Mobile number is not valid...");
			}
		}
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.addCustomer(customer);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}

	public boolean checkRestaurant(List<Restaurant>list, String restaurantName) {
		for(Restaurant re: list) {
			if(re.getRestaurantName().equals(restaurantName)) {
				return false;
			}
		}
		return true;
	}
	public void addARestaurant(Restaurant restaurant) throws SomeThingWentWrong{
		if(restaurant.getRestaurantCOntactNumber().length()!=10) {
			throw new SomeThingWentWrong("Restaurant's Mobile number is not valid...");
		}
		for(int i=0 ; i<restaurant.getRestaurantCOntactNumber().length();++i) {
			if(!(Character.isDigit(restaurant.getRestaurantCOntactNumber().charAt(i)))) {
				throw new SomeThingWentWrong("Contact number is not valid...");
			}
		}
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.addRestaurent(restaurant);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}

	
	
	public void addAItem(Category category,Item item,int restaurantId) throws SomeThingWentWrong {
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.addAnItemToRestaurant(category, item, restaurantId);
		} catch (SomeThingWentWrong e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	public void deleteAItem(int id) throws SomeThingWentWrong{
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.deleteItem(id);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}

	public void deleteARestaurant(int id) throws SomeThingWentWrong{
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.deleteRestaurent(id);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	public List<Customer> seeCustomerDetails() throws SomeThingWentWrong{
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			List<Customer> customers=D_I_I.seeCustomerDetails();
			return customers;
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	public void deleteACustomer(int id) throws SomeThingWentWrong{
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.deleteCustomer(id);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	public void addAAdmin(Admin admin) throws SomeThingWentWrong{
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.addAdmin(admin);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	
	public void deleteAAdmin(int id) throws SomeThingWentWrong{
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.deleteAdmin(id);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	::::Customer Functionality::::
	
	
	
	public List<Restaurant> ListOfRestaurantAndFood() throws SomeThingWentWrong {
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			List<Restaurant> restaurants = D_I_I.ListOfRestaurantAndFoodItems();
			if(restaurants.size()==0) {
				throw new SomeThingWentWrong("No Restaurant found...");
			}
			return restaurants;
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	public void changeEmail(String email) throws SomeThingWentWrong {
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.changeEmail(email);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	public void changeAddress(Address add) throws SomeThingWentWrong {
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.changeAddress(add);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	public void changeMobile(String mobile) throws SomeThingWentWrong {
		for(int i=0 ; i<mobile.length();++i) {
			if(!(Character.isDigit(mobile.charAt(i)))) {
				throw new SomeThingWentWrong("Contact number is not valid...");
			}
		}
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.changeMobilenumber(mobile);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	public void changePassword(String pass) throws SomeThingWentWrong {
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.changePassword(pass);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
	
	
	
	public static void addToCart(int id) throws SomeThingWentWrong {
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.addToCart(id);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}
	
}
