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
	private boolean active;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	@OneToMany(mappedBy = "customerFoodCart",cascade = CascadeType.ALL)
	private Set<Order1> order;
	@OneToMany(mappedBy="foodCartDetails",cascade = CascadeType.ALL)
	private Set<Bill> bill;
	public CustomerFoodCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerFoodCart(Customer customer, Set<Order1> order, Set<Bill> bill) {
		super();
		this.active = true;
		this.customer = customer;
		this.order = order;
		this.bill = bill;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Order1> getOrder() {
		return order;
	}
	public void setOrder(Set<Order1> order) {
		this.order = order;
	}
	public Set<Bill> getBill() {
		return bill;
	}
	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}
}
