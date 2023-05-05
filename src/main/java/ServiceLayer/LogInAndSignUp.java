package ServiceLayer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import CurrentUser.CurrentUserId;
import DAOLayer.DAOInterfaceImple;
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
	
	
	
	
	
	public void customerSignUp(Customer customer) throws SomeThingWentWrong{
		if(customer.getCustomerMobileNumber().length()!=10) {
			throw new SomeThingWentWrong("Mobile number is not valid...");
		}
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.addCustomer(customer);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}


	public void addARestaurant(Restaurant restaurant) throws SomeThingWentWrong{
		if(restaurant.getRestaurantCOntactNumber().length()!=10) {
			throw new SomeThingWentWrong("Restaurant's Mobile number is not valid...");
		}
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			D_I_I.addRestaurent(restaurant);
		} catch (Exception e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}

	
	
	public void addAItem(Category category,Item item,int restaurantId) throws SomeThingWentWrong {
		try {
			DAOInterfaceImple D_I_I = new DAOInterfaceImple();
			Restaurant restaurant = D_I_I.findRestaurant(restaurantId);
			
			
			
			
			
			
		} catch (SomeThingWentWrong e) {
			throw new SomeThingWentWrong(e.getMessage());
		}
	}


	
	
	
}
