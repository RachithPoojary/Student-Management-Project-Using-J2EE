<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student</title>
    <link rel="stylesheet" type="text/css" href="loginStyle.css">
</head>
<body>
    <h2>Delete Student</h2>
    <form action="DeleteServlet" method="post">
        Email: <input type="text" name="email" readonly value="<%= request.getParameter("email") %>"><br>
        <input type="submit" value="Delete">
    </form>
</body>
</html>
