package com.codewithpasi.jobsconsultancy.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithpasi.jobconsultancy.dao.ConsultantManager;
import com.codewithpasi.jobconsultancy.dao.ConsultantManagerImpl;
import com.codewithpasi.jobsconsultancy.model.Appointment;
import com.codewithpasi.jobsconsultancy.model.Consultant;

public class ConsultantService {
	
private static ConsultantService consultantServiceObj;
	
	private ConsultantService() { 
		
	}
	
	public synchronized static ConsultantService getConsultantService() {
		if(consultantServiceObj == null) {
			consultantServiceObj = new ConsultantService();
		}
		
		return consultantServiceObj;
	}
	
	private ConsultantManager getConsultantManager() {
		return new ConsultantManagerImpl();
	}
	
	public boolean loginConsultant(Consultant consultant) throws ClassNotFoundException, SQLException {
		return getConsultantManager().loginConsultant(consultant);
	}
	
	public List<Appointment> fetchAllAppointments() throws ClassNotFoundException, SQLException {
		return getConsultantManager().fetchAllAppointments();
	}

	public Appointment fetchSingleAppointment(int appointmentID) {
		// TODO Auto-generated method stub
		return null;
	}

}
