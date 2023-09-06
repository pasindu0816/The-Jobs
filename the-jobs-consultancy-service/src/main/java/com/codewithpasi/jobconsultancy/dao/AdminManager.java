package com.codewithpasi.jobconsultancy.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithpasi.jobsconsultancy.model.Admin;
import com.codewithpasi.jobsconsultancy.model.User;

public interface AdminManager {

	public boolean loginAdmin(Admin admin) throws SQLException, ClassNotFoundException;
		
	public boolean deleteUser(int userID) throws SQLException, ClassNotFoundException;
	
	public User fetchSingleUser(int userID) throws SQLException, ClassNotFoundException;
	
	List<User> fetchAllUsers() throws SQLException, ClassNotFoundException;

	
}

