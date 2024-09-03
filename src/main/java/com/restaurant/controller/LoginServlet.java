package com.restaurant.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user credentials (example logic, replace with actual validation)
        if (isValidAdmin(username, password)) {
            response.sendRedirect("adminDashboard.jsp?success=true");
        } else if (isValidStaff(username, password)) {
            response.sendRedirect("staffDashboard.jsp?success=true");
        } else if (isValidCustomer(username, password)) {
            response.sendRedirect("home.jsp?success=true");
        } else {
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }

    private boolean isValidAdmin(String username, String password) {
        // Replace with actual admin validation logic
        return "admin".equals(username) && "adminpass".equals(password);
    }

    private boolean isValidStaff(String username, String password) {
        // Replace with actual staff validation logic
        return "staff".equals(username) && "staffpass".equals(password);
    }

    private boolean isValidCustomer(String username, String password) {
        // Replace with actual customer validation logic
        return "customer".equals(username) && "customerpass".equals(password);
    }
}
