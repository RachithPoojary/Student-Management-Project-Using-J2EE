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
import com.company.dao.User;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static UserDao userDao = new UserDaoImpl();

    public WelcomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        if (email != null) {
            User user = userDao.getUserByEmail(email);
            if (user != null) {
                session.setAttribute("username", user.getUsername());
                request.setAttribute("message", request.getParameter("message"));
            } else {
                request.setAttribute("message", "User not found.");
            }
        } else {
            request.setAttribute("message", "No email found in session.");
        }

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
