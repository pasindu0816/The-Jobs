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

import com.codewithpasi.jobsconsultancy.service.ConsultantService;
import com.codewithpasi.jobsconsultancy.model.Admin;
import com.codewithpasi.jobsconsultancy.model.Appointment;
import com.codewithpasi.jobsconsultancy.model.Consultant;
import com.codewithpasi.jobsconsultancy.model.User;


public class ConsultantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message = "";
	
	private ConsultantService getConsultantService() {
		return ConsultantService.getConsultantService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String actionType = request.getParameter("actiontype");
				
		if(actionType.equals("single")) {
			try {
				fetchSingleAppointment(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else {
			fetchAllAppointments(request, response);
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String actionType = request.getParameter("actiontype");
		
		if(actionType.equals("loginConsul")) {
			loginConsultant(request,response);
		}
		
	}
	
	
	 private void loginConsultant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	clearMessage();

	    	Consultant consultant = new Consultant();
	    	consultant.setname(request.getParameter("username"));
	    	consultant.setPassword(request.getParameter("password"));

	    	try {
				if(getConsultantService().loginConsultant(consultant)) { 
					
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
	 
	 private void fetchSingleAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			
			clearMessage();
			
			int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
			
			Appointment appointment = getConsultantService().fetchSingleAppointment(appointmentID);
			if(appointment.getAppointmentID() > 0) {
				request.setAttribute("appointment", appointment);
			}
			else {
				message = "Not record found";
			}
			request.setAttribute("feedbackMessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("getappointment?actiontype=all");
			rd.forward(request, response);
		}
 


	private void fetchAllAppointments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	clearMessage();
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		try {
			appointmentList =getConsultantService().fetchAllAppointments();
					
			if(!(appointmentList.size() > 0)) {
				message = "No record found!";
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("appointmentList" , appointmentList);
		request.setAttribute("feedbackMessage", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("consulAppointments.jsp");
		rd.forward(request, response);
		
	}
	
	private void clearMessage() {
		
		message = "";
		
	}

}

