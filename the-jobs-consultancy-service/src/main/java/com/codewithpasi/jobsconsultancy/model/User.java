package com.codewithpasi.jobsconsultancy.model;

public class User {
	
	private int userID;
    private String userName;
    private String Password;
    private String Email;
    //private UserRole role;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userid) {
		this.userID = userid;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

		
}


