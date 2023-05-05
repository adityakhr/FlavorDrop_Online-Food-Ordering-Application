package DTOLayer;

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
	@OneToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(double amount,int totalItems) {
		super();
		this.amount = amount;
		this.totalItems = totalItems;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", amount=" + amount + ", totalItems=" + totalItems + "]";
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
}
