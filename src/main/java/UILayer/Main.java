package UILayer;

import java.util.Scanner;

import CurrentUser.CurrentUserId;
import Eceptions.AdminNotFoundException;
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
					System.out.println("222222222");
					break;
				case "3":
					System.out.println("333333333");
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
			boolean bool =L_A_S.checkAdminCreadetials(userName, password);
			if(bool==true) {
				System.out.println("LogIn successfull...");
				String choice ="";
				do {
					System.out.println("Please select any options below:");
					System.out.println("1 -> Log In as a Admin\n"
							+ "2 -> Log In as a Customer\n"
							+ "3 -> Sign Up new customer\n"
							+ "0 -> Log out");
					System.out.print("Enter your choice: ");
					choice = sc.nextLine();
					switch(choice){
						case "1":
							System.out.println("111111111");
							break;
						case "2":
							System.out.println("222222222");
							break;
						case "3":
							System.out.println("333333333");
							break;
						case "0":
							CurrentUserId.setId(-1);
							System.out.println("See you soon Admin...Bye!");
							break;
						case "":
							System.out.println("Invalid selection...!");
							break;
						default:
							System.out.println("Wrong selection...!");
					}
					
				}while(!choice.equals("0"));
			}
			else System.out.println("Somthing went wrong");
		} catch (AdminNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
