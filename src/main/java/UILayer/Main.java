package UILayer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import CurrentUser.CurrentUserId;
import DTOLayer.Address;
import DTOLayer.Category;
import DTOLayer.Customer;
import DTOLayer.Item;
import DTOLayer.Restaurant;
import Eceptions.SomeThingWentWrong;
import ServiceLayer.LogInAndSignUp;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("+ + + + + + + + + + + + + + + + + +\n"
		+"+   Hello Welcome To FlavorDrop   +\n"
				+ "+ + + + + + + + + + + + + + + + + +");
		String choice ="";
		do {
			System.out.println("Please select any options below:");
			System.out.println("1 -> Log In as a Admin\n"
					+ "2 -> Log In as a Customer\n"
					+ "3 -> Sign Up new customer\n"
					+ "0 -> Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextLine();
			switch(choice){
				case "1":
					adminLogIn(sc);
					break;
				case "2":
					customerLogIn(sc);
					break;
				case "3":
					customerSignUp(sc);
					break;
				case "0":
					System.out.println("Thanks for visiting this application...GoodBye!");
					break;
				case "":
					System.out.println("Invalid selection...!");
					break;
				default:
					System.out.println("Wrong selection...!");
			}
			
		}while(!choice.equals("0"));
		sc.close();
	}

	private static void adminLogIn(Scanner sc) {
		System.out.println("Enter your username:");
		String userName = sc.nextLine();
		System.out.println("Enter your password:");
		String password = sc.nextLine();
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			L_A_S.checkAdminCreadetials(userName, password);
			System.out.println("LogIn successfull...Welcome "+CurrentUserId.getName());
			String choice ="";
			do {
				System.out.println("Please select any options below:");
				System.out.println("1 -> Add Restaurant\n"
						+ "2 -> Delete Restaurant\n"
						+ "3 -> Add Food Item in Restaurant's food items\n"
						+ "4 -> Delete Food Item\n"
						+ "5 -> Delete Customer\n"
						+ "6 -> Add New Admin\n"
						+ "7 -> Delete Admin\n"
						+ "0 -> Log out");
				System.out.print("Enter your choice: ");
				choice = sc.nextLine();
				switch(choice){
					case "1":
						addRestaurant(sc);
						break;
					case "2":
						addFoodItem(sc);
						break;
					case "3":
						System.out.println("33");
						break;
					case "4":
						System.out.println("44");
						break;
					case "5":
						System.out.println("55");
						break;
					case "6":
						System.out.println("66");
						break;
					case "7":
						System.out.println("77");
						break;
					case "0":
						System.out.println("See you soon "+CurrentUserId.getName()+"...Bye!");
						CurrentUserId.setId(-1);
						CurrentUserId.setName("");
						break;
					case "":
						System.out.println("Invalid selection...!");
						break;
					default:
						System.out.println("Wrong selection...!");
				}
				
			}while(!choice.equals("0"));
		} catch (SomeThingWentWrong e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void customerLogIn(Scanner sc) {
		System.out.println("Enter your username:");
		String userName = sc.nextLine();
		System.out.println("Enter your password:");
		String password = sc.nextLine();
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			L_A_S.checkCustomerCreadetials(userName, password);
			System.out.println("LogIn successfull...Welcome "+CurrentUserId.getName());
			String choice ="";
			do {
				System.out.println("Please select any options below:");
				System.out.println("1 -> See the restaurants\n"
						+ "2 -> See all items of perticular restaurant\n"
						+ "3 -> Add to foodcart\n"
						+ "4 -> update address\n"
						+ "5 -> Checkout\n"
						+ "6 -> Update details\n"
						+ "0 -> Log out");
				System.out.print("Enter your choice: ");
				choice = sc.nextLine();
				switch(choice){
					case "1":
						System.out.println("11");
						break;
					case "2":
						System.out.println("22");
						break;
					case "3":
						System.out.println("33");
						break;
					case "4":
						System.out.println("44");
						break;
					case "5":
						System.out.println("55");
						break;
					case "6":
						System.out.println("66");
						break;
					case "0":
						System.out.println("See you soon "+CurrentUserId.getName()+"...Bye!");
						CurrentUserId.setId(-1);
						CurrentUserId.setName("");
						break;
					case "":
						System.out.println("Invalid selection...!");
						break;
					default:
						System.out.println("Wrong selection...!");
				}
				
			}while(!choice.equals("0"));
		} catch (SomeThingWentWrong e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	private static void customerSignUp(Scanner sc) {
		System.out.println("Enter your First Name:");
		String firstName = sc.nextLine().trim();
		System.out.println("Enter your Last Name:");
		String lastName = sc.nextLine().trim();
		System.out.println("Enter your User Name:");
		String userName = sc.nextLine().trim();
		System.out.println("Enter your Password:");
		String password = sc.nextLine().trim();
		System.out.println("Enter your Gender:");
		String gender = sc.nextLine().trim();
		System.out.println("Enter your Email:");
		String email = sc.nextLine().trim();
		System.out.println("Enter your Mobile Number:");
		String mobile = sc.nextLine().trim();
		System.out.println("Enter your Building Name:");
		String buiding = sc.nextLine().trim();
		System.out.println("Enter your Street Name:");
		String street = sc.nextLine().trim();
		System.out.println("Enter your Area:");
		String area = sc.nextLine().trim();
		System.out.println("Enter your City:");
		String city = sc.nextLine().trim();
		System.out.println("Enter your State:");
		String state = sc.nextLine().trim();
		System.out.println("Enter your Country:");
		String country = sc.nextLine().trim();
		System.out.println("Enter your Pincode:");
		String pincode = sc.nextLine().trim();
		
		Address address = new Address(buiding, street, area, city, state, country, pincode);
		
		Customer customer = new Customer(firstName, lastName, gender, email, mobile,userName,password, address, true);
		
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		
		try {
			L_A_S.customerSignUp(customer);
			System.out.println("Account created...Please Log In now");
		} catch (SomeThingWentWrong e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	public static void addRestaurant(Scanner sc) {
		System.out.println("Enter the Restaurant Name: ");
		String restaurantName = sc.nextLine();
		System.out.println("Enter the Name of Restaurant Manager Name: ");
		String restaurantManagerName = sc.nextLine();
		System.out.println("Enter the Name of Restaurant: ");
		String restaurantContactNumber = sc.nextLine();
		System.out.println("Enter Restaurant Building Name:");
		String buiding = sc.nextLine().trim();
		System.out.println("Enter Restaurant Street Name:");
		String street = sc.nextLine().trim();
		System.out.println("Enter Restaurant Area:");
		String area = sc.nextLine().trim();
		System.out.println("Enter Restaurant City:");
		String city = sc.nextLine().trim();
		System.out.println("Enter Restaurant State:");
		String state = sc.nextLine().trim();
		System.out.println("Enter Restaurant Country:");
		String country = sc.nextLine().trim();
		System.out.println("Enter Restaurant Pincode:");
		String pincode = sc.nextLine().trim();
		
		Address address = new Address(buiding, street, area, city, state, country, pincode);
		
		
		Restaurant restaurant = new Restaurant(restaurantName, restaurantManagerName, restaurantContactNumber, address, null, true);
		
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		
		try {
			L_A_S.addARestaurant(restaurant);
			System.out.println("Restaurant added...");
		} catch (SomeThingWentWrong e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void addFoodItem(Scanner sc) {
		System.out.println("Enter the Item Name: ");
		String itemName = sc.nextLine().trim();
		System.out.println("Enter the Quantity of Item: ");
		int quantity =sc.nextInt(); 
		sc.nextLine();
		System.out.println("Enter the Price of Item: ");
		double price = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter Restaurant Id:");
		int restaurantId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Category Name:");
		String categoryName = sc.nextLine().trim();
		Category category = new Category(categoryName, null);
		Item item = new Item(itemName, quantity, price, null, category, true);
		
		
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		
		try {
			L_A_S.addAItem(category, item, restaurantId);
			System.out.println("Restaurant added...");
		} catch (SomeThingWentWrong e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
