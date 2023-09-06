package com.codewithpasi.jobsconsultancy.model;

public class Admin {
	
	private int adminID;
	private String name;
    private String Password;


    public Admin() {
	
    }

    public Admin(int adminID, String name, String password) {
	
    	this.adminID = adminID;
    	this.name = name;
    	this.Password = password;
	
    }
    
    public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
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
    
}
