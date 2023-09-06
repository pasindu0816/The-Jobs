package com.codewithpasi.jobsconsultancy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithpasi.jobsconsultancy.model.Admin;
import com.codewithpasi.jobsconsultancy.model.Consultant;
import com.codewithpasi.jobsconsultancy.model.User;
import com.codewithpasi.jobsconsultancy.service.AdminService;



public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message = "";

	private AdminService getAdminService() {
		return AdminService.getAdminService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String actionType = request.getParameter("actiontype");
		
		if(actionType.equals("single")) {
			fetchSingleUser(request,response);
		}
		else {
			fetchAllUsers(request,response);
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionType = request.getParameter("actiontype");
		
		if(actionType.equals("delete")) {
			deleteUser(request,response);
		}

		else if(actionType.equals("loginAdmin")) {
			loginAdmin(request,response);
		}
	}
	

	 private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	clearMessage();

	    	Admin admin = new Admin();
	    	admin.setname(request.getParameter("username"));
	    	admin.setPassword(request.getParameter("password"));

	    	try {
				if(getAdminService().loginAdmin(admin)) { 
					
					message = "Successfully Logged in!";
				}
				else {
					message = "Failed to Log in!";
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				message = "Operation failed! " +e.getMessage();
			}
			
			request.setAttribute("feedbackmessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
			rd.forward(request, response);  
	    	
	    	
		}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		clearMessage();
		int userid = Integer.parseInt(request.getParameter("userid"));
		try {
			if(getAdminService().deleteUser(userid)) {
				message = "User successfully deleted! User:" + userid;
			}
			else {
				message = "Failed to delete the User! User:" + userid;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		//request.setAttribute("feedbackMessage", message);
		//RequestDispatcher rd = request.getRequestDispatcher("search-al-and-delete.jsp");
		//rd.forward(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		response.sendRedirect("getadmin?actiontype=all");
		
	}
	
	private void fetchSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
	}
	
	private void fetchAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    clearMessage();
	    
	    List<User> userList = new ArrayList<User>();
	    
	    try {
	        userList = getAdminService().fetchAllUsers();
	        if (!(userList.size() > 0)) {
	            message = "No records found!";
	        }
	       
	    } catch (ClassNotFoundException | SQLException e) {
	        message = e.getMessage();
	    }
	    
	    request.setAttribute("userList", userList);
	    request.setAttribute("feedbackMessage", message);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("adminPanel.jsp");
	    rd.forward(request, response);
	}

		
	private void clearMessage() {
		message = "";
	}
}
