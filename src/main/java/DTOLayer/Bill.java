package DTOLayer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private double amount;
	private int totalItems;
	private boolean active;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderId")
	private Order1 orders;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(double amount, int totalItems, Order1 orders) {
		super();
		this.amount = amount;
		this.totalItems = totalItems;
		this.active = true;
		this.orders = orders;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Order1 getOrders() {
		return orders;
	}
	public void setOrders(Order1 orders) {
		this.orders = orders;
	}
	
}
