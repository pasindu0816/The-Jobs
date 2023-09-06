package com.codewithpasi.jobsconsultancy.model;

public class User {
	
	private int userid;
    private String username;
    private String password;
    private String email;
    //private UserRole role;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUserID() {
		return userid;
	}

	public void setUserID(int userid) {
		this.userid = userid;
	}

	public String getuserName() {
		return username;
	}

	public void setuserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		
}


