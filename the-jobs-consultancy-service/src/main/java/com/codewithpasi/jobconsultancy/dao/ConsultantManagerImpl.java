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
import com.codewithpasi.jobsconsultancy.model.Appointment;
import com.codewithpasi.jobsconsultancy.model.Consultant;

public class ConsultantManagerImpl implements ConsultantManager{
	
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
		DbDriverManager driverManager = driverFactory.getDbdriver("MySql");
		
		return driverManager.getConnection();
	}
	

	@Override
	public boolean loginConsultant(Consultant consultant) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM consultant WHERE username = ? AND password = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, consultant.getname());
		ps.setString(2, consultant.getPassword());
		
		ResultSet resultSet = ps.executeQuery();
		
		boolean result = resultSet.next();
		
		ps.close();
		connection.close();
		return result;
	}
	

	@Override
	public List<Appointment> fetchAllAppointments() throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
		String query = "SELECT * FROM appointment";
		Statement st = connection.createStatement();
		
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			Appointment appointment = new Appointment();
			appointment.setAppointmentID(rs.getInt("appointmentID"));
			appointment.setDate(rs.getString("date"));
			appointment.setTime(rs.getString("time"));

			
			appointmentList.add(appointment);
			
		}
		
		st.close();
		connection.close();
		
		return appointmentList;
	}

}
