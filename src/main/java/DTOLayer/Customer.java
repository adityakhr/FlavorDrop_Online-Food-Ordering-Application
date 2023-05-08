package DTOLayer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerGender;
	private String customerEmail;
	private String customerMobileNumber;
	private String customerUserName;
	private String customerPassword;
	private boolean active;
	
	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	private CustomerFoodCart customerFoodCart;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerFirstName, String customerLastName, String customerGender,
			String customerEmail, String customerMobileNumber, String customerUserName, String customerPassword,  Address address, CustomerFoodCart customerFoodCart) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerGender = customerGender;
		this.customerEmail = customerEmail;
		this.customerMobileNumber = customerMobileNumber;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
		this.address = address;
		this.customerFoodCart = customerFoodCart;
		this.active = true;
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
	public CustomerFoodCart getCustomerFoodCart() {
		return customerFoodCart;
	}
	public void setCustomerFoodCart(CustomerFoodCart customerFoodCart) {
		this.customerFoodCart = customerFoodCart;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public boolean getActive() {
		return this.active;
	}

	public void SetActive(boolean flag) {
		this.active =flag ;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerGender=" + customerGender + ", customerEmail=" + customerEmail
				+ ", customerMobileNumber=" + customerMobileNumber + ", customerUserName=" + customerUserName
				+ "]";
	}
	
}