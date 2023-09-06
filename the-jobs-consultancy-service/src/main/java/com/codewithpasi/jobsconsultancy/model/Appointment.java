package com.codewithpasi.jobsconsultancy.model;

public class Appointment {
	
	private int appointmentID;
	private String date;
	private String time;
	private String country;
	
	public Appointment() {
		
	}
	
	public Appointment(int appointmentID, String appointmentDate, String appointmentTime, String jobCountry) {
		
		this.appointmentID = appointmentID;
		this.date = appointmentDate;
		this.time = appointmentTime;
		this.country = jobCountry;
	}
	
	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String appointmentDate) {
		this.date = appointmentDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String appointmentTime) {
		this.time = appointmentTime;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String jobCountry) {
		this.country = jobCountry;
	}


}
