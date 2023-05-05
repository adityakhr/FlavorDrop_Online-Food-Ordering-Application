package DTOLayer;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private LocalDate orderDate;
	
	@OneToOne(mappedBy="order",cascade = CascadeType.ALL)
	private Bill bill;
	
	
	@ManyToOne
	@JoinColumn(name = "cartId")
	private CustomerFoodCart customerFoodCartDetails;
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order( LocalDate orderDate, CustomerFoodCart customerFoodCartDetails, Bill bill) {
		super();
		this.orderDate = orderDate;
		this.customerFoodCartDetails = customerFoodCartDetails;
		this.bill = bill;
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
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderDate, orderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderDate, other.orderDate) && orderId == other.orderId;
	}
	
}
