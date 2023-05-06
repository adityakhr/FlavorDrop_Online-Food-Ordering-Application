package DAOLayer;

import java.util.List;

import DTOLayer.Admin;
import DTOLayer.Category;
import DTOLayer.Customer;
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
	public void deleteCustomer(int id) throws SomeThingWentWrong;
	public void deleteAdmin(int id) throws SomeThingWentWrong;
}
