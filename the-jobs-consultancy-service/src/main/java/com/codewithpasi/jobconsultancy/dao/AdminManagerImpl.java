package com.codewithpasi.jobconsultancy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithpasi.jobsconsultancy.dao.dbutils.DbDriverManager;
import com.codewithpasi.jobsconsultancy.dao.dbutils.DbDriverManagerFactory;
import com.codewithpasi.jobsconsultancy.model.Admin;
import com.codewithpasi.jobsconsultancy.model.Consultant;
import com.codewithpasi.jobsconsultancy.model.User;

public class AdminManagerImpl implements AdminManager {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
		DbDriverManager driverManager = driverFactory.getDbdriver("MySql");
		
		return driverManager.getConnection();
	}


	@Override
	public boolean loginAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, admin.getname());
		ps.setString(2, admin.getPassword());
		
		ResultSet resultSet = ps.executeQuery();
		
		boolean result = resultSet.next();
		
		ps.close();
		connection.close();
		return result;
		
	}
	


	@Override
	public boolean deleteUser(int userID) throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
		String query = "DELETE FROM user WHERE userid= ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, userID);
		
		boolean result = false;
		if (ps.executeUpdate() > 0 )
			result = true;
		
		ps.close();
		connection.close();
		
		return result;
	}


	@Override
	public User fetchSingleUser(int userID) throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
		String query = "SELECT userid, username, email FROM user WHERE userid=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, userID);
		
		User user = new User();
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user.setUserID(rs.getInt("userid"));
			user.setuserName(rs.getString("username"));
			user.setEmail(rs.getString("email"));
		}
		
		ps.close();
		connection.close();
		
		return user;
	}


	@Override
	public List<User> fetchAllUsers() throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
		String query = "SELECT userid, username, email FROM user";
		Statement st = connection.createStatement();
		
		List<User> userList = new ArrayList<User>();
		
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			User user = new User();
			user.setUserID(rs.getInt("userid"));
			user.setuserName(rs.getString("username"));
			user.setEmail(rs.getString("email"));

			
			userList.add(user);
			
		}
		
		st.close();
		connection.close();
		
		return userList;
		
	}


	

}
