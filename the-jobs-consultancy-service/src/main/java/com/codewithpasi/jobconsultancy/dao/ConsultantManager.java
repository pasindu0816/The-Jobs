package com.codewithpasi.jobconsultancy.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithpasi.jobsconsultancy.model.Appointment;
import com.codewithpasi.jobsconsultancy.model.Consultant;

public interface ConsultantManager {
	
	public boolean loginConsultant(Consultant consultant) throws SQLException, ClassNotFoundException;
	
	public List<Appointment> fetchAllAppointments() throws SQLException, ClassNotFoundException;

}