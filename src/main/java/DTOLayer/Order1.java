package DTOLayer;


import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Order1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private LocalDate orderDate;
	private boolean active;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="orderId")
	@JoinTable(name="customerOrders")
	private Set<Item> items;
	
	@OneToOne(mappedBy = "orders",cascade = CascadeType.ALL)
	private Bill bill;
	
	@ManyToOne
	@JoinColumn(name="foodCartId")
	private CustomerFoodCart customerFoodCart;
	public Order1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order1(String orderDate, Set<Item> items, Bill bill, CustomerFoodCart customerFoodCart) {
		super();
		this.orderDate = LocalDate.parse(orderDate);
		this.active = true;
		this.items = items;
		this.bill = bill;
		this.customerFoodCart = customerFoodCart;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public CustomerFoodCart getCustomerFoodCart() {
		return customerFoodCart;
	}
	public void setCustomerFoodCart(CustomerFoodCart customerFoodCart) {
		this.customerFoodCart = customerFoodCart;
	}
	
	
}
