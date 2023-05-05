package DTOLayer;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	private String restaurantName;
	private String restaurantManagerName;
	private String restaurantContactNumber;
	private  boolean active;
	@Embedded
	private Address restaurantAddress;
	
	@OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
	private Set<Item>items;
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(String restaurantName, String restaurantManagerName,
			String restaurantCOntactNumber, Address restaurantAddress, Set<Item> items, boolean flag) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantManagerName = restaurantManagerName;
		this.restaurantContactNumber = restaurantCOntactNumber;
		this.restaurantAddress = restaurantAddress;
		this.items = items;
		this.active=flag;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantManagerName() {
		return restaurantManagerName;
	}
	public void setRestaurantManagerName(String restaurantManagerName) {
		this.restaurantManagerName = restaurantManagerName;
	}
	public String getRestaurantCOntactNumber() {
		return restaurantContactNumber;
	}
	public void setRestaurantCOntactNumber(String restaurantCOntactNumber) {
		this.restaurantContactNumber = restaurantCOntactNumber;
	}
	public Address getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(Address restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public boolean getActive() {
		return this.active;
	}
	public void setActive(boolean flag) {
		this.active=flag;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantManagerName=" + restaurantManagerName + ", restaurantCOntactNumber="
				+ restaurantContactNumber + "]";
	}
}
