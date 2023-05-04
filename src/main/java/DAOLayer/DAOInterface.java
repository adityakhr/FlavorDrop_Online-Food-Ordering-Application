package DAOLayer;

import Eceptions.AdminNotFoundException;

public interface DAOInterface {
	public boolean checkAdminLogIn(String userName, String password) throws AdminNotFoundException;
}
