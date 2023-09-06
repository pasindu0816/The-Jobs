<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix= "tag" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Jobs Consultation Centre</title>
    <link rel="stylesheet" href="css/home.css">
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
		          <a class="nav-link "  href="consulHome.jsp">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="#">Appointments</a>
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
		<h3>All Consultants</h3>
		<p style='color:magenta'> ${message} </p>
		<br>
		<table class="table" >
			<thead>
				<tr>
				<th>Appointment ID</th>
				<th>Appointment Date</th>
				<th>Appointment Time</th>	
				<th>Job Country</th>		
				</tr>		
			</thead>
			<tbody>
				<tag:forEach var="appointment"  items="${appointmentList}">
				<tr>
					<td>${appointment.appointmentID}</td>
					<td>${appointment.appointmentDate}</td>
					<td>${appointment.appointmentTime}</td>
					<td>${appointment.jobCountry}</td>
					
					
				</tr>
				</tag:forEach>
								
			</tbody>
	</table>
		
		
		
	</body><br><br>
		<footer>
	        <p>&copy; 2023 The Jobs Consultation Centre</p>
	   	</footer>
</html>	   	
		        