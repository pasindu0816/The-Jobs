<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "tag" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<meta charset="UTF-8">
	    <title>The Jobs - Admin</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

		<body style="min-height: 100vh; display: flex; flex-direction: column;">
		   <header>
			 <nav class="navbar navbar-expand-lg bg-body-tertiary">
				  <div class="container-fluid">
				    <a class="navbar-brand" href="#">The Jobs</a>
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
				    <div class="collapse navbar-collapse" id="navbarSupportedContent">
				      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				        <li class="nav-item">
				          <a class="nav-link" href="adminHome.jsp">Home</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link active" aria-current="page" href="#">Panel</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="logout.jsp">Log out</a>
				        </li>
	
				      </ul>
				    </div>
				  </div>
				</nav>
			</header>
			<h2>View all users & Delete Specific</h2>
			<p style='color:magenta'> ${message} </p>
			<br>
		
		<table class="table">
		<thead>
			<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>Email</th>	
			</tr>		
		</thead>
		<tbody>
			<tag:forEach var="user"  items="${userList}">
			<tr>
				<td>${user.userid}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>
					<form action=usermanager method="post">
							<input type="hidden" name="userid" value="${user.userid}">
							<input type="hidden" name="actiontype" value="delete">
						<button type="submit" class="btn btn-danger">Delete user</button>
					</form>
				</td>
						
			</tr>
			</tag:forEach>
			
							
		</tbody>
	</table>

</body>
</html>