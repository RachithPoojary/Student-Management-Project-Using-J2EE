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
    <title>Student Details</title>
    <link rel="stylesheet" type="text/css" href="loginStyle.css">
</head>
<body>
    <h2>Student Details</h2>
    <%
        String email = request.getParameter("email");
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
            } else {
                out.println("<p>No student found with the given email.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    %>
    <table border='1'>
        <tr><th>Username</th><th>Email</th><th>Phone</th><th>Standard</th><th>Password</th></tr>
        <tr>
            <td><%= username %></td>
            <td><%= email %></td>
            <td><%= phone %></td>
            <td><%= std %></td>
            <td><%= password %></td>
        </tr>
    </table>
    <br>
    <form action="welcome.jsp" method="get">
        <input type="hidden" name="email" value="<%= email %>">
        <input type="submit" value="Go Back">
    </form>
</body>
</html>
