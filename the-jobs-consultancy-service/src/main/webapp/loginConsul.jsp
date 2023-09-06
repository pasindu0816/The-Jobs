<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix= "tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <p>${feedbackmessage}</p>
        <form action="loginConsultant" method="POST">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <br>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>  
                
                <input type="hidden" name="actiontype" value="loginConsul"/>  
            </div>
            <br>
            <button type="submit">Login</button>
        </form>
        <div class= "text">
        <p>Not a registered Consultant?</p>
        <p >Admin Login >>> <a href="loginAdmin.jsp">click here</a></p>
        <p >User Login >>> <a href="login.jsp">click here</a></p>
        </div>
        
        
    </div>
</body>
</html>
