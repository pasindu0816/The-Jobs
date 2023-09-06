package com.codewithpasi.jobsconsultancy.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithpasi.jobconsultancy.dao.UserManager;
import com.codewithpasi.jobconsultancy.dao.UserManagerImpl;
import com.codewithpasi.jobsconsultancy.model.Admin;
import com.codewithpasi.jobsconsultancy.model.Appointment;
import com.codewithpasi.jobsconsultancy.model.Consultant;
import com.codewithpasi.jobsconsultancy.model.User;

public class UserService {

	private static UserService userServiceObj;
	
	private UserService() { 
		
	}
	
	public synchronized static UserService getUserService() {
		if(userServiceObj == null) {
			userServiceObj = new UserService();
		}
		
		return userServiceObj;
	}
	
	private UserManager getUserManager() {
		return new UserManagerImpl();
	}
	
	
	public boolean registerUser(User user) throws ClassNotFoundException, SQLException {
		return getUserManager().registerUser(user);
	}
	
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException {
		return getUserManager().loginUser(user);
	}
	
	
	public Consultant fetchSingleConsultant(int consultantID) throws ClassNotFoundException, SQLException {
		return getUserManager().fetchSingleConsultant(consultantID);
	}
	
	public List<Consultant> fetchAllConsultants() throws ClassNotFoundException, SQLException{
		return getUserManager().fetchAllConsultants();
	}
	
	public boolean addAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
		return getUserManager().addAppointment(appointment);
	}



	public Appointment fetchSingleAppointment(int appointmentID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
