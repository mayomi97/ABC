package com.restaurant.service;

import com.restaurant.dao.OrderDAO;
import com.restaurant.model.Order;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService() {
        orderDAO = new OrderDAO();
    }

    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }
    public void addOrder(String[] items) {
        // Implement the logic to handle the order here
        // For example, save the order details to a database
        for (String item : items) {
            System.out.println("Item ordered: " + item);
        }
    }
}

