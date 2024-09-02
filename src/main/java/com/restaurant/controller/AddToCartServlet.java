package com.restaurant.controller;

import com.restaurant.model.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session object
        HttpSession session = request.getSession();

        // Get the current cart, or create a new one if it doesn't exist
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Get selected products from the form
        String[] selectedProducts = request.getParameterValues("productName");

        if (selectedProducts != null) {
            for (String productName : selectedProducts) {
                // Here, you should ideally retrieve product details from the database
                // For simplicity, we'll just create a CartItem with dummy data
                CartItem item = new CartItem(productName, 1, getProductPrice(productName));
                cart.add(item);
            }
        }

        // Update the session with the new cart
        session.setAttribute("cart", cart);

        // Redirect to the cart page or back to the product list
        response.sendRedirect("cart.jsp");
    }

    // This method should ideally fetch product prices from the database
    private double getProductPrice(String productName) {
        switch (productName) {
            case "Fruits and Nuts Bowl":
                return 2000.00;
            case "Fried Rice":
                return 1500.00;
            case "Curry with Rice and Seafood Served on Banana Leaf":
                return 2000.00;
            case "Noodle with Meat":
                return 1700.00;
            case "Bowl of Noodles with Greens":
                return 1800.00;
            default:
                return 0.00;
        }
    }
}
