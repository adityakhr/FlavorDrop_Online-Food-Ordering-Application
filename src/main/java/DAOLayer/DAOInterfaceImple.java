package DAOLayer;


import CurrentUser.CurrentUserId;
import Eceptions.AdminNotFoundException;

public class DAOInterfaceImple implements DAOInterface {

	@Override
	public boolean checkAdminLogIn(String userName, String password) throws AdminNotFoundException {
		String capitalUserName = "";
		for(int i =0 ; i<userName.length(); ++i ){
			capitalUserName+=(Character.toUpperCase(userName.charAt(i)));
		}
		String capitalPassword = "";
		for(int i =0 ; i<password.length(); ++i ){
			capitalPassword+=(Character.toUpperCase(password.charAt(i)));
		}
		if(!capitalUserName.equals("ADMIN") || !capitalPassword.equals("ADMIN")) {
			throw new AdminNotFoundException("No admin registered with these credentials...");
		}
		CurrentUserId.setId(0);
		return true;
	}
	
}
