package com.codewithpasi.jobsconsultancy.dao.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDriverManagerMySqlImpl implements DbDriverManager {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost:3306/the_jobs";
				String userName = "root";
				String password = "password";
				
				
				return DriverManager.getConnection(url, userName, password);
				
		
	}

}