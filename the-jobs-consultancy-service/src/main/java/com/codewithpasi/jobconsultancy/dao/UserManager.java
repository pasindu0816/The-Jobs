package com.codewithpasi.jobconsultancy.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithpasi.jobsconsultancy.model.Admin;
import com.codewithpasi.jobsconsultancy.model.Appointment;
import com.codewithpasi.jobsconsultancy.model.Consultant;
import com.codewithpasi.jobsconsultancy.model.User;

public interface UserManager {
	
	public boolean registerUser(User user) throws SQLException, ClassNotFoundException;
	
	public boolean loginUser(User user) throws SQLException, ClassNotFoundException; 
	
	public boolean loginConsultant(Consultant consultant) throws SQLException, ClassNotFoundException;
	
	public boolean loginAdmin(Admin admin) throws SQLException, ClassNotFoundException;
	
	public Consultant fetchSingleConsultant(int consultantID) throws SQLException, ClassNotFoundException;

	List<Consultant> fetchAllConsultants() throws SQLException, ClassNotFoundException;
	
	public boolean addAppointment(Appointment appointment) throws SQLException, ClassNotFoundException;
	


}
