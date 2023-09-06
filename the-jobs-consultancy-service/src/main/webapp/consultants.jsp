<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix= "tag" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Consultants</title>
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
		          <a class="nav-link active" aria-current="page" href="#">Consultants</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="appointments.jsp">Appointments</a>
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
	
	<h3>All Consultants</h3>
	<p style='color:magenta'> ${message} </p>
	<br>
	<table class="table" >
		<thead>
			<tr>
			<th>Consultant ID</th>
			<th>Consultants Name</th>
			<th>Specialized Country</th>	
			<th>Availability</th>		
			</tr>		
		</thead>
		<tbody>
			<tag:forEach var="consultant"  items="${consultantList}">
			<tr>
				<td>${consultant.consultantID}</td>
				<td>${consultant.name}</td>
				<td>${consultant.specialization}</td>
				<td>${consultant.availability}</td>
				
				
			</tr>
			</tag:forEach>
							
		</tbody>
	</table>
</body>
</html>