package DTOLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminFullName;
	private String adminUserName;
	private String adminPassword;
	private boolean active;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String adminFullName, String adminUserName, String adminPassword) {
		super();
		this.adminFullName = adminFullName;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.active = true;
	}
	public int getAdminId() {
		return adminId;
	}
	public String getAdminFullName() {
		return adminFullName;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public boolean getActive() {
		return this.active;
	}
	public void setActive(boolean flag) {
		this.active=flag;
	}
}

