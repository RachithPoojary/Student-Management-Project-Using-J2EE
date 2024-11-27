<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="loginStyle.css">
</head>
<body>
  <div class="container">
        <h1>Register</h1>
        <form action="RegisterServlet" method="post">
            <label for="username"> Username:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="email">Email:</label>
            <input type="text" id="username" name="email" required><br>  
             <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required><br>
             <label for="std">Standard:</label>
            <input type="text" id="std" name="std" required><br> 
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">Register</button>
        </form>
    
        <p><a href="index.html">Back to Home</a></p>
</body>
</html>