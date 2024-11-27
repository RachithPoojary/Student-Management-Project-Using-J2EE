<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <link rel="stylesheet" type="text/css" href="loginStyle.css">
</head>
<body>
    <h2>Update Student Information</h2>
    <%
        String email = request.getParameter("email");
        if (email == null || email.isEmpty()) {
            email = (String) session.getAttribute("email");
        }
        
        String username = "", phone = "", std = "", password = "";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectDB", "postgres", "root");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                username = rs.getString("username");
                phone = rs.getString("phone");
                std = rs.getString("std");
                password = rs.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    %>
    <form action="UpdateServlet" method="post">
        <input type="hidden" name="email" value="<%= email %>">
        Username: <input type="text" name="username" value="<%= username %>"><br>
        Phone: <input type="text" name="phone" value="<%= phone %>"><br>
        Standard: <input type="text" name="std" value="<%= std %>"><br>
        Password: <input type="password" name="password" value="<%= password %>"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
