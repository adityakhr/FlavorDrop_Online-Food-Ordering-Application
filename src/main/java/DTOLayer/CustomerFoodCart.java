package DTOLayer;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class CustomerFoodCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	@OneToMany(mappedBy = "customerFoodCartDetails",cascade = CascadeType.ALL)
	private Set<Order> orders;
	public CustomerFoodCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerFoodCart(Customer customer, Set<Order> orders) {
		super();
		this.customer = customer;
		this.orders = orders;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "CustomerFoodCart [cartId=" + cartId + ", customer=" + customer + "]";
	}
}
