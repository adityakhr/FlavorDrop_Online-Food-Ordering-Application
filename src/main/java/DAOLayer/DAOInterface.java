package DAOLayer;

import java.util.List;

import DTOLayer.Address;
import DTOLayer.Admin;
import DTOLayer.Category;
import DTOLayer.Customer;
import DTOLayer.CustomerFoodCart;
import DTOLayer.Item;
import DTOLayer.Restaurant;
import Eceptions.SomeThingWentWrong;

public interface DAOInterface {
	public List<Admin> checkAdminLogIn() throws SomeThingWentWrong;
	public List<Customer> checkCustomerLogIn() throws SomeThingWentWrong;
	public void addCustomer(Customer customer) throws SomeThingWentWrong;
	public void addRestaurent(Restaurant restaurant) throws SomeThingWentWrong;
	public void deleteRestaurent(int id) throws SomeThingWentWrong;
	public void deleteItem(int id) throws SomeThingWentWrong;
	public void addAdmin(Admin admin) throws SomeThingWentWrong;
	public void addAnItemToRestaurant(Category category,Item item,int restaurantId) throws SomeThingWentWrong;
	public List<Customer> seeCustomerDetails() throws SomeThingWentWrong;
	public void deleteCustomer(int id) throws SomeThingWentWrong;
	public void deleteAdmin(int id) throws SomeThingWentWrong;
	
	
	
	
	
//	::::Customer Functionality::::
	public List<Restaurant> ListOfRestaurantAndFoodItems() throws SomeThingWentWrong;
	public void changeEmail(String email) throws SomeThingWentWrong;
	public void changeAddress(Address add) throws SomeThingWentWrong;
	public void changePassword(String pass) throws SomeThingWentWrong;
	public void changeMobilenumber(String number) throws SomeThingWentWrong;
	public void addToCart(int id) throws SomeThingWentWrong;
	public CustomerFoodCart checkOut() throws SomeThingWentWrong;
	public void minusTheThings(CustomerFoodCart c_F_C) throws SomeThingWentWrong;
	
	
	
}
