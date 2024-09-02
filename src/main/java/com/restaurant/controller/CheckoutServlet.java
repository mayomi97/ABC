package com.restaurant.controller;

import com.restaurant.dao.OrderDAO;
import com.restaurant.model.CartItem;
import com.restaurant.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CheckoutServlet extends HttpServlet {

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get the session object
	        HttpSession session = request.getSession();

	        // Retrieve the cart from the session
	        @SuppressWarnings("unchecked")
	        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

	        // Check if the cart is empty
	        if (cart == null || cart.isEmpty()) {
	            response.sendRedirect("cart.jsp");
	            return;
	        }

	        // Get user details from the form
	        String name = request.getParameter("name");
	        String address = request.getParameter("address");
	        String phone = request.getParameter("phone");

	        // Calculate the total price
	        double totalPrice = cart.stream().mapToDouble(CartItem::getPrice).sum();

	        // Create an Order object
	        Order order = new Order();
	        order.setName(name);
	        order.setAddress(address);
	        order.setPhone(phone);
	        order.setItems(cart);
	        order.setTotalPrice(totalPrice);

	        // Save the order to the database
	        try {
	            OrderDAO orderDAO = new OrderDAO();
	            orderDAO.saveOrder(order);

	            // Clear the cart after placing the order
	            session.removeAttribute("cart");

	            // Set a success message in the session
	            session.setAttribute("message", "Order success. Thank you!");

	            // Redirect to order success page
	            response.sendRedirect("orderSuccess.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Set an error message in the session
	            session.setAttribute("message", "There was an error processing your order. Please try again.");

	            // Redirect to an error page
	            response.sendRedirect("error.jsp");
	        }
	    }
	}
