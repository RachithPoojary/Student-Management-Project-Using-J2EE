package com.company.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        if (email == null || email.isEmpty()) {
            email = (String) session.getAttribute("email");
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectDB", "postgres", "root");

            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            out.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"loginStyle.css\"></head><body><table border='1'>");
            out.println("<tr><th>Username</th><th>Email</th><th>Phone</th><th>Standard</th><th>Password</th></tr>");

            if (rs.next()) {
                String name = rs.getString("username");
                String phone = rs.getString("phone");
                String standard = rs.getString("std");
                String password = rs.getString("password");

                out.println("<tr><td>" + name + "</td><td>" + email + "</td><td>" + phone + "</td><td>" + standard + "</td><td>" + password + "</td></tr>");
            } else {
                out.println("<p>No student found with the given email.</p>");
            }

            out.println("</table></body></html>");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
