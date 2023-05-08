package UILayer;


import java.util.List;
import java.util.Scanner;
import java.util.Set;

import CurrentUser.CurrentUserId;
import DTOLayer.Address;
import DTOLayer.Admin;
import DTOLayer.Category;
import DTOLayer.Customer;
import DTOLayer.CustomerFoodCart;
import DTOLayer.Item;
import DTOLayer.Order1;
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
			choice = sc.nextLine().trim();
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
					System.err.println("Invalid selection...!");
					break;
				default:
					System.err.println("Wrong selection...!");
			}
			
		}while(!choice.equals("0"));
		sc.close();
	}

	
	
	
//		::::::::Admin Log In::::::::
	
	
	
	private static void adminLogIn(Scanner sc) {
		System.out.println("Enter your username:");
		String userName = sc.nextLine().trim();
		System.out.println("Enter your password:");
		String password = sc.nextLine().trim();
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
						+ "5 -> See Customer Details\n"
						+ "6 -> Delete Customer\n"
						+ "7 -> Add New Admin\n"
						+ "8 -> Delete Admin\n"
						+ "0 -> Log out");
				System.out.print("Enter your choice: ");
				choice = sc.nextLine().trim();
				switch(choice){
					case "1":
						addRestaurant(sc);
						break;
					case "2":
						deleteRestaurant(sc);
						break;
					case "3":
						addFoodItem(sc);
						break;
					case "4":
						deleteFoodItem(sc);
						break;
					case "5":
						seeCustomerDetails();
						break;
					case "6":
						deleteCustomer(sc);
						break;
					case "7":
						addAdmin(sc);
						break;
					case "8":
						deleteAdmin(sc);
						break;
					case "0":
						System.out.println("See you soon "+CurrentUserId.getName()+"...Bye!");
						CurrentUserId.setId(-1);
						CurrentUserId.setName("");
						break;
					case "":
						System.err.println("Invalid selection...!");
						break;
					default:
						System.err.println("Wrong selection...!");
				}
				
			}while(!choice.equals("0"));
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
//	::::::::Admin Functionalities Starts::::::::
	
	
	
	public static void addRestaurant(Scanner sc) {
		System.out.println("Enter the Restaurant Name: ");
		String restaurantName = sc.nextLine().trim();
		System.out.println("Enter the Name of Restaurant Manager Name: ");
		String restaurantManagerName = sc.nextLine().trim();
		System.out.println("Enter the Contact Number of Restaurant: ");
		String restaurantContactNumber = sc.nextLine().trim();
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
		
		
		Restaurant restaurant = new Restaurant(restaurantName, restaurantManagerName, restaurantContactNumber, address);
		
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		
		try {
			L_A_S.addARestaurant(restaurant);
			System.out.println("Restaurant added...");
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public static void addFoodItem(Scanner sc) {
		try {
			
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
			Item item = new Item(itemName, quantity, price, null, category);
			
			
			LogInAndSignUp L_A_S = new LogInAndSignUp();
			
			
			L_A_S.addAItem(category, item, restaurantId);
			System.out.println("Item Added to Restaurant Menu...");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public static void deleteFoodItem(Scanner sc) {
		try {
			System.out.println("Enter the Food Item Id: ");
			int id =sc.nextInt();
			sc.nextLine();
			LogInAndSignUp L_A_S = new LogInAndSignUp();
			L_A_S.deleteAItem(id);
			System.out.println("Item deleted from Menu...");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public static void deleteRestaurant(Scanner sc) {
		try {
			System.out.println("Enter the Restaurant Id: ");
			int restaurantId =sc.nextInt();
			sc.nextLine();
			
			LogInAndSignUp L_A_S = new LogInAndSignUp();
			
			L_A_S.deleteARestaurant(restaurantId);
			System.out.println("Restaurant deleted...");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void seeCustomerDetails() {
		Scanner sc = new Scanner(System.in);
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		
		try {
			List<Customer>customers=L_A_S.seeCustomerDetails();
			if(!customers.isEmpty()) {
				for(Customer rs: customers) {
					System.out.println("Customer-Id: "+rs.getCustomerId()+", Customer-Name: "+rs.getCustomerFirstName()+" "+rs.getCustomerLastName());
				}
				System.out.println("Do you want to have a look of Customers orders? ((Y/N)||(y/n))");
				String ans=sc.nextLine().trim();
				switch(ans) {
					case "Y":
						System.out.println("Please enter the Customer id: ");
						String id = sc.nextLine().trim();
						int count=0;
						int count2=0;
						for(Customer rs: customers) {
							if(String.valueOf(rs.getCustomerId()).equals(id) && rs.getActive()) {
//								for(Order order:rs.getCustomerFoodCart().getOrder()) {
//									if(order.getActive()){
//										for(Item item: order.getItems()) {
//											System.out.println(item);
//											++count2;
//										}
//									}
//								}
								++count;
							}
						}
						if(count2==0) {
							System.err.println("No Order found...");
						}
						if(count==0) {
							System.err.println("No Customer found with this id...");
						}
						break;
					case "y":
						System.out.println("Please enter the Customer id: ");
						String id1 = sc.nextLine().trim();
						int count1=0;
						int count21=0;
						for(Customer rs: customers) {
							if(String.valueOf(rs.getCustomerId()).equals(id1) && rs.getActive()) {
//								for(Order order:rs.getCustomerFoodCart().getOrder()) {
//									if(order.getActive()){
//										for(Item item: order.getItems()) {
//											System.out.println(item);
//											++count21;
//										}
//									}
//								}
								++count1;
							}
						}
						if(count21==0) {
							System.err.println("No Order found...");
						}
						if(count1==0) {
							System.err.println("No Customer found with this id...");
						}
						break;
					case "N":
						System.out.println("All right...");
						break;
					case "n":
						System.out.println("All right...");
						break;
					default:
						System.err.println("You haven't selected correct option...");
							
				}
			}else {
				System.err.println("No customer found...");
			}
			
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void deleteCustomer(Scanner sc) {
		try {
			System.out.println("Enter the customer Id: ");
			int id =sc.nextInt();
			sc.nextLine();
			LogInAndSignUp L_A_S = new LogInAndSignUp();
			L_A_S.deleteACustomer(id);
			System.out.println("Customer deleted...");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void addAdmin(Scanner sc) {
		System.out.println("Enter the admin Full Name: ");
		String adminFullName =sc.nextLine().trim();
		System.out.println("Enter the admin User Name: ");
		String adminUserName =sc.nextLine().trim();
		System.out.println("Enter the admin Password: ");
		String adminPassword =sc.nextLine().trim();
		Admin admin = new Admin(adminFullName, adminUserName, adminPassword);
		
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			L_A_S.addAAdmin(admin);
			System.out.println("Admin added...");
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void deleteAdmin(Scanner sc) {
		try {
			System.out.println("Enter the admin Id: ");
			int id =sc.nextInt();
			sc.nextLine();
			LogInAndSignUp L_A_S = new LogInAndSignUp();
			
			L_A_S.deleteAAdmin(id);
			System.out.println("Admin deleted...");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
//	::::::::Admin Functionalities Ends::::::::
	
	
	
	
//	::::::::Customer Log In & Sign Up::::::::
	
	
	
	
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
		Customer customer = new Customer(firstName, lastName, gender, email, mobile,userName,password, address);
		
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		
		try {
			L_A_S.customerSignUp(customer);
			System.out.println("Account created...Please Log In now");
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void customerLogIn(Scanner sc) {
		System.out.println("Enter your username:");
		String userName = sc.nextLine().trim();
		System.out.println("Enter your password:");
		String password = sc.nextLine().trim();
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			L_A_S.checkCustomerCreadetials(userName, password);
			System.out.println("LogIn successfull...Welcome "+CurrentUserId.getName());
			String choice ="";
			do {
				System.out.println("Please select any options below:");
				System.out.println("1 -> List of restaurants & their food items\n"
						+ "2 -> Order food\n"
						+ "3 -> Checkout\n"
						+ "4 -> Update details\n"
						+ "0 -> Log out");
				System.out.print("Enter your choice: ");
				choice = sc.nextLine().trim();
				switch(choice){
					case "1":
						listOfRestaurantAndFoodItems();
						break;
					case "2":
						orderFood(sc);
						break;
					case "3":
						checkOut();
						break;
					case "4":
						updateDetails(sc);
						break;
					case "0":
						System.out.println("See you soon "+CurrentUserId.getName()+"...Bye!");
						CurrentUserId.setId(-1);
						CurrentUserId.setName("");
						break;
					case "":
						System.err.println("Invalid selection...!");
						break;
					default:
						System.err.println("Wrong selection...!");
				}
				
			}while(!choice.equals("0"));
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
	
	
	
	





//	::::::::Customers Functionalities::::::::

	
	



	private static void listOfRestaurantAndFoodItems() {
		Scanner sc =new Scanner(System.in);
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			List<Restaurant> restaurant=L_A_S.ListOfRestaurantAndFood();
			for(Restaurant rs: restaurant) {
				System.out.println("Restaurant-Id: "+rs.getRestaurantId()+", Restaurant-Name: "+rs.getRestaurantName());
			}
			System.out.println("Do you want to have a look of Items? ((Y/N)||(y/n))");
			String ans=sc.nextLine().trim();
			switch(ans) {
				case "Y":
					System.out.println("Please enter the restaurant id: ");
					String id = sc.nextLine().trim();
					int count=0;
					int count2=0;
					for(Restaurant rs: restaurant) {
						if(String.valueOf(rs.getRestaurantId()).equals(id)) {
							for(Item items:rs.getItems()) {
								System.out.println(items);
								++count2;
							}
							++count;
						}
					}
					if(count2==0) {
						System.err.println("No Item found...");
					}
					if(count==0) {
						System.err.println("No restaurant found with this id...");
					}
					break;
				case "y":
					System.out.println("Please enter the restaurant id: ");
					String id1 = sc.nextLine().trim();
					int count1=0;
					int count12=0;
					for(Restaurant rs: restaurant) {
						if(String.valueOf(rs.getRestaurantId()).equals(id1)) {
							for(Item items:rs.getItems()) {
								if(items.getActive()) {
									System.out.println(items);
									++count12;
								}
							}
							++count1;
						}
					}
					if(count12==0) {
						System.err.println("No Item found...");
					}
					if(count1==0) {
						System.err.println("No restaurant found with this id...");
					}
					break;
				case "N":
					System.out.println("All right...");
					break;
				case "n":
					System.out.println("All right...");
					break;
				default:
					System.err.println("You haven't selected correct option...");
						
			}
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
	}


	private static void updateDetails(Scanner sc) {
		System.out.println("Select an option below");
		System.out.println("1 -> Change Email\n"
				+ "2 -> Change Address\n"
				+ "3 -> Change Mobile Number\n"
				+ "4 -> Change Password");
		String option=sc.nextLine().trim();
		switch(option) {
			case "1":
				System.out.println("Enter your new email: ");
				String email = sc.nextLine().trim();
				changeCustomerEmail(email);
				break;
			case "2":
				changeCustomerAddress(newAddress(sc));
				break;
			case "3":
				System.out.println("Enter your new number: ");
				String number = sc.nextLine().trim();
				changeCustomerNumber(number);
				break;
			case "4":
				System.out.println("Enter your new password: ");
				String pass = sc.nextLine().trim();
				changeCustomerPassword(pass);
				break;
			default:
				System.err.println("Wrong selection...");
		}
	}


//    ::::Customer update functionality starts::::

	private static void changeCustomerEmail(String email) {
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			L_A_S.changeEmail(email);
			System.out.println("Email Has Been Changed...");
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
		
	}
	private static Address newAddress(Scanner sc) {
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
		
		Address add = new Address(buiding, street, area, city, state, country, pincode);
		
		return add;
		
	}
	private static void changeCustomerAddress(Address add) {
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			L_A_S.changeAddress(add);
			System.out.println("Address Has Been Changed...");
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
		
	}
	private static void changeCustomerNumber(String number) {
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			L_A_S.changeMobile(number);
			System.out.println("Number Has Been Changed...");
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
		
	}
	private static void changeCustomerPassword(String pass) {
		LogInAndSignUp L_A_S = new LogInAndSignUp();
		try {
			L_A_S.changePassword(pass);
			System.out.println("Password Has Been Changed...you can log out.");
		} catch (SomeThingWentWrong e) {
			System.err.println(e.getMessage());
		}
	}
//  ::::Customer update functionality ends::::
	
	
	private static void orderFood(Scanner sc) {
		try {
			System.out.println("Enter the id of food item");
			int id  = sc.nextInt();
			sc.nextLine();
			LogInAndSignUp L_A_S = new LogInAndSignUp();
			L_A_S.addToCart(id);
			System.out.println("Added to cart...");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	
	private static void checkOut() {
		try {
			LogInAndSignUp L_A_S = new LogInAndSignUp();
			CustomerFoodCart C_F_C=L_A_S.checkOut();
			if(C_F_C.getOrder()==null) {
				System.err.println("No item found with your Cart");
			}else {
				int count=0;
				double amount=0;
				Set<Order1> orders= C_F_C.getOrder();
				for(Order1 or: orders) {
					if(or.getActive() && or.getItems().size()>0) {
						for(Item it:or.getItems()) {
							System.out.println(it);
							amount+=it.getPrice();
						}
						++count;
					}
				}
				if(count>0) {
					System.out.println("\nAmount: "+amount+"\nThese are the items in your cart...Do you want to make Payment?");
					Scanner sc = new Scanner(System.in);
					String k = sc.nextLine().trim();
					switch(k) {
						case"y":
							L_A_S.minusTheThings(C_F_C);
							System.out.println("Puchase Done...");
							break;
						case"Y":
							L_A_S.minusTheThings(C_F_C);
							System.out.println("Puchase Done...");
							break;
						case"N":
							System.out.println("All Right...");
							break;
						case"n":
							System.out.println("All Right...");
							break;
						default:
							System.err.println("Wrong Selection...");
					}
				}else {
					System.err.println("No order found");
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	
}
