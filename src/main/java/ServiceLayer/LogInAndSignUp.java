package ServiceLayer;

import DAOLayer.DAOInterfaceImple;
import Eceptions.AdminNotFoundException;

public class LogInAndSignUp {
	public boolean checkAdminCreadetials(String userName, String password ) throws AdminNotFoundException{
		DAOInterfaceImple D_I_I = new DAOInterfaceImple();
		try {
			boolean bool =D_I_I.checkAdminLogIn(userName, password);
			return true;
		} catch (AdminNotFoundException e) {
			// TODO Auto-generated catch block
			throw new AdminNotFoundException(e.getMessage());
		}
	}
}
