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

import com.codewithpasi.jobsconsultancy.service.UserService;
import com.codewithpasi.jobsconsultancy.model.Admin;
import com.codewithpasi.jobsconsultancy.model.Appointment;
import com.codewithpasi.jobsconsultancy.model.Consultant;
import com.codewithpasi.jobsconsultancy.model.User;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message = "";
	
	private UserService getUserService() {
		return UserService.getUserService();
	}
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionType= request.getParameter("actiontype");
		
		if(actionType.equals("single")) {
			fetchSingleConsultant(request, response);
		}
		else {
			fetchAllConsultants(request, response);
		}

				
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionType = request.getParameter("actiontype");
		
		if (actionType.equals ("register")) {
			registerUser(request, response);
		}
		else if (actionType.equals("login")) {
			loginUser(request, response);
		}
		else if (actionType.equals("loginAdmin")) {
			loginAdmin(request, response);
		}
		else if (actionType.equals("loginConsul")) {
			loginConsultant(request, response);
		}
		else if (actionType.equals("add")) {
			addAppointment(request, response);
		}	
		
		else if (actionType.equals("delete")) {
			//deleteProduct(request, response);
		}
		
	}



	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		clearMessage();
		
		User user = new User();
		user.setuserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		
		try {
			if(getUserService().registerUser(user)) {
				
				message = "Registration Successful!";
			}
			else {
				message = "Failed to register the user!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = "Operation failed! " +e.getMessage();
		}
		
		request.setAttribute("feedbackmessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("loggedhome.jsp");
		rd.forward(request, response);
		
	}
	
    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	clearMessage();

    	User user = new User();
    	user.setuserName(request.getParameter("username"));
    	user.setPassword(request.getParameter("password"));

    	try {
			if(getUserService().loginUser(user)) { 
				
				message = "Successfully Logged in!";
			}
			else {
				message = "Failed to Log in!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = "Operation failed! " +e.getMessage();
		}
		
		request.setAttribute("feedbackmessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("loggedhome.jsp");
		rd.forward(request, response);  
    	
    	
	}
    
    private void loginConsultant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	clearMessage();

    	Consultant consultant = new Consultant();
    	consultant.setname(request.getParameter("username"));
    	consultant.setPassword(request.getParameter("password"));

    	try {
			if(getUserService().loginConsultant(consultant)) { 
				
				message = "Successfully Logged in!";
			}
			else {
				message = "Failed to Log in!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = "Operation failed! " +e.getMessage();
		}
		
		request.setAttribute("feedbackmessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("consulHome.jsp");
		rd.forward(request, response);  
    	
    	
	}
    
    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	clearMessage();

    	Admin admin = new Admin();
    	admin.setname(request.getParameter("username"));
    	admin.setPassword(request.getParameter("password"));

    	try {
			if(getUserService().loginAdmin(admin)) { 
				
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
    
    	private void fetchSingleConsultant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		clearMessage();
		
		int consultantID = Integer.parseInt(request.getParameter("consultantID"));
		
		try {
			Consultant consultant = getUserService().fetchSingleConsultant(consultantID);
			if(consultant.getconsultantID() > 0) {
				request.setAttribute("consultant", consultant);
			}
			else {
				message = "No record Found!";
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("feedbackmessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("consultants.jsp");
		rd.forward(request, response);
		
    	}
    	
    
    	private void fetchAllConsultants(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Consultant> consultantList = new ArrayList<Consultant>();
		
		try {
			consultantList =getUserService().fetchAllConsultants();
					
			if(!(consultantList.size() > 0)) {
				message = "No record found!";
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("consultantList" , consultantList);
		request.setAttribute("feedbackMessage", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("consultants.jsp");
		rd.forward(request, response);
		
	}
    	
    	private void addAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		clearMessage();
    		
    		Appointment appointment = new Appointment();
    		appointment.setDate(request.getParameter("date"));
    		appointment.setTime(request.getParameter("time"));
    		appointment.setCountry(request.getParameter("country"));

    		
    		try {
    			if(getUserService().addAppointment(appointment)) {
    				
    				message = "The appointment request has been successfully sent!";
    			}
    			else {
    				message = "Failed to request the appointment!";
    			}
    		} catch (ClassNotFoundException | SQLException e) {
    			
    			message = "Operation failed! " +e.getMessage();
    		}
    		
    		request.setAttribute("feedbackmessage", message);
    		RequestDispatcher rd = request.getRequestDispatcher("appointments.jsp");
    		rd.forward(request, response);
    		
    	}



	private void clearMessage() {
		
		message = "";
		
	}

}
