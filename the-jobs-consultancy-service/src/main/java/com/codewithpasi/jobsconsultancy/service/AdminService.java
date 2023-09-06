package com.codewithpasi.jobsconsultancy.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithpasi.jobconsultancy.dao.AdminManager;
import com.codewithpasi.jobconsultancy.dao.AdminManagerImpl;
import com.codewithpasi.jobsconsultancy.model.Admin;
import com.codewithpasi.jobsconsultancy.model.User;

public class AdminService {
	
private static AdminService adminServiceObj;
	
	private AdminService() { 
		
	}
	
	public synchronized static AdminService getAdminService() {
		if(adminServiceObj == null) {
			adminServiceObj = new AdminService();
		}
		
		return adminServiceObj;
	}
	
	private AdminManager getAdminManager() {
		return new AdminManagerImpl();
	}
	
	public boolean loginAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		return getAdminManager().loginAdmin(admin);
	}
	
	public boolean deleteUser(int userID) throws ClassNotFoundException, SQLException {
		return getAdminManager().deleteUser(userID);
	}
	
	public User fetchSingleUser(int userID) throws ClassNotFoundException, SQLException {
		return getAdminManager().fetchSingleUser(userID);
	}
	
	public List<User> fetchAllUsers() throws ClassNotFoundException, SQLException {
		return getAdminManager().fetchAllUsers();
	}

}
