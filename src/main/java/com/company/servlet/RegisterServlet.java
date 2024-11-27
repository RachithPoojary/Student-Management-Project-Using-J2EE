package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.User;
import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private static UserDao userDao = new UserDaoImpl();
       
   
    public RegisterServlet() {
        super();
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String std = request.getParameter("std");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setStd(std);
        user.setPassword(password);

     
        if (userDao.addUser(user)) {
            response.sendRedirect("login.jsp?registration=success");
        } else {
            response.sendRedirect("register.jsp?error=1");
        }
    }

}
