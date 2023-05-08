package DTOLayer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private double amount;
	private int totalItems;
	private boolean active;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	private CustomerFoodCart foodCartDetails;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(double amount, int totalItems, CustomerFoodCart foodCartDetails) {
		super();
		this.amount = amount;
		this.totalItems = totalItems;
		this.active = true;
		this.foodCartDetails = foodCartDetails;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public CustomerFoodCart getFoodCartDetails() {
		return foodCartDetails;
	}
	public void setFoodCartDetails(CustomerFoodCart foodCartDetails) {
		this.foodCartDetails = foodCartDetails;
	}	
}
