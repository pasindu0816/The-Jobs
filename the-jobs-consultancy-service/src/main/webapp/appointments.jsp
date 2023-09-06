<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "tag" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Appointments</title>
	<!-- latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<!-- latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
	
</head>
<body>

	<header>
		  <nav class="navbar navbar-expand-lg bg-body-tertiary">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">The Jobs</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNav">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link" href="loggedhome.jsp">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="getconsultants?actiontype=all">Consultants</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="#">Appointments</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="myprofile.jsp">My Profile</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="logout.jsp">Log out</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<br>
	</header>
	
	<h3>place your appointments</h3>
	<div >
		<p>${feedbackmessage}</p>
		<br>
		<form action = "setappointment" method= "post">
			<label for="appointmentDate">Appointment Date:</label>
			<input class="form-control" type= "date" name= "date" id= "appointmentDate"/>
			<br>
			<label for="appointmentTime">Time:</label>
			<input class="form-control" type= "time" id= "appointmentTime" name="time"/>	
			<br>
			<label for="specializedCountry">Job Country:</label>
			<input class="form-control" type= "text" id= "specializedCountry" name= "country"/>	
			<br>
			<input type="hidden" name="actiontype" value="add"/>
			<button class="btn btn-primary" type="submit">Submit</button>	
		</form>
	</div>
	</body>

	</html>