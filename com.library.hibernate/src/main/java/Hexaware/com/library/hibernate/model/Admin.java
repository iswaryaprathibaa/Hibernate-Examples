package Hexaware.com.library.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	private int adminId;
	private String adminPassword;
	public int getAdminId() {
		return adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Admin(int adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + "]";
	}
	
	
}
