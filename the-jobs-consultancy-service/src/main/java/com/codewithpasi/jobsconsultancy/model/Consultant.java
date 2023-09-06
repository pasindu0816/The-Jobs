package com.codewithpasi.jobsconsultancy.model;

public class Consultant {
	
		private int consultantID;
	    private String name;
	    private String Password;
	    private String specialization;
	    private String availability;		
	

	public Consultant() {
		
	}
	
	public Consultant(int consultantID, String name, String password, String specialization, String availability) {
		
		this.consultantID = consultantID;
		this.name = name;
		this.Password = password;
		this.specialization = specialization;
		this.availability = availability;

	}
	
	public int getconsultantID() {
		return consultantID;
	}

	public void setconsultantID(int consultantID) {
		this.consultantID = consultantID;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
	
	
	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getAvailability() {
		return availability;
	}
	
	public void setAvailability(String availability) {
		this.availability = availability;
	
	}
}
	

