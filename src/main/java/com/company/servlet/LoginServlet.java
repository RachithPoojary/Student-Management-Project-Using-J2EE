package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImpl();
       
 
    public LoginServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 		 String email = request.getParameter("email");
	        String password = request.getParameter("password");
//	        String username = request.getParameter("username");
//	        System.out.println(username);
	        System.out.println(email);

	        if (userDao.isValidUser(email, password)) {
	        	
	            HttpSession session = request.getSession();
	            session.setAttribute("email", email);
//	            session.setAttribute("username", username);
	            response.sendRedirect("welcome.jsp");
	        }
	           
	       else {
	            response.sendRedirect("login.jsp?error=1");
	        	System.out.println("Error A gya");
	        }
	}

}
