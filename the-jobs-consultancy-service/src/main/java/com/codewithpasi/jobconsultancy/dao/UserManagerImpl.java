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
import com.codewithpasi.jobsconsultancy.model.Appointment;
import com.codewithpasi.jobsconsultancy.model.Consultant;
import com.codewithpasi.jobsconsultancy.model.User;


public class UserManagerImpl implements UserManager{

	public UserManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
			
			DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
			DbDriverManager driverManager = driverFactory.getDbdriver("MySql");
			
			return driverManager.getConnection();
		}

	@Override
	public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
	
		
		String query = "INSERT INTO user (username,password, email) VALUES (?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getuserName());
		ps.setString(2, user.getPassword());  
		ps.setString(3, user.getEmail());          

		
		boolean result = false;
		if (ps.executeUpdate() > 0) 
			result = true;
		
		ps.close();
		connection.close();
		return result;
		
	}
	
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getuserName());
		ps.setString(2, user.getPassword());
		
		ResultSet resultSet = ps.executeQuery();
		
		boolean result = resultSet.next();
		
		ps.close();
		connection.close();
		return result;
		
	}
	
	
	@Override
	public Consultant fetchSingleConsultant(int consultantID) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "SELECT consultantID, name, specialization, availability FROM consultant WHERE consultantID=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, consultantID);
		
		Consultant consultant = new Consultant();
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			consultant.setconsultantID(rs.getInt("consultantID"));
			consultant.setname(rs.getString("name"));
			consultant.setSpecialization(rs.getString("specialization"));
			consultant.setAvailability(rs.getString("availability"));

		}
		
		ps.close();
		connection.close();
		
		return consultant;
		
	}
	
	
	public List<Consultant> fetchAllConsultants() throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "SELECT consultantID, name, specialization, availability FROM consultant";
		Statement st = connection.createStatement();
		
		List<Consultant> consultantList = new ArrayList<Consultant>();
		
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			Consultant consultant = new Consultant();
			consultant.setconsultantID(rs.getInt("consultantID"));
			consultant.setname(rs.getString("name"));
			consultant.setSpecialization(rs.getString("specialization"));
			consultant.setAvailability(rs.getString("availability"));

			
			consultantList.add(consultant);
			
		}
		
		st.close();
		connection.close();
		
		return consultantList;
	}
	
		

		@Override
		public boolean addAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
			
			Connection connection = getConnection();
			 
			String query = "INSERT INTO appointment (appointmentDate, appointmentTime, jobCountry) VALUES (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, appointment.getDate());
			ps.setString(2, appointment.getTime()); 
			ps.setString(3, appointment.getCountry()); 
			
			boolean result = false;
			if (ps.executeUpdate() > 0) 
				result = true;
			
			ps.close();
			connection.close();
			return result;
		}

	

}
