package DAOLayer;

import java.util.List;

import DTOLayer.Admin;
import DTOLayer.Customer;
import DTOLayer.Restaurant;
import Eceptions.SomeThingWentWrong;

public interface DAOInterface {
	public List<Admin> checkAdminLogIn() throws SomeThingWentWrong;
	public List<Customer> checkCustomerLogIn() throws SomeThingWentWrong;
	public void addCustomer(Customer customer) throws SomeThingWentWrong;
	public void addRestaurent(Restaurant restaurant) throws SomeThingWentWrong;
	public Restaurant findRestaurant(int id) throws SomeThingWentWrong;
}
