package com.restaurant.controller;


import com.restaurant.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] items = request.getParameterValues("item");
        orderService.addOrder(items);

        response.sendRedirect("orderConfirmation.jsp");
    }
}
