package DTOLayer;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private int quantity;
	private double price;
	private boolean active;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="restaurant_Id")
	Restaurant restaurant;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoty_id")
	Category category;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String itemName, int quantity, double price, Restaurant restaurant, Category category, boolean flag) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.restaurant = restaurant;
		this.category = category;
		this.active=flag;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean getActive() {
		return this.active;
	}
	public void setActive(boolean flag) {
		this.active=flag;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, price, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return itemId == other.itemId && Objects.equals(itemName, other.itemName)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
	}
	
}
