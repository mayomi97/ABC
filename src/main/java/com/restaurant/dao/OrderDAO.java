package com.restaurant.dao;

import com.restaurant.model.CartItem;
import com.restaurant.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {

    public void saveOrder(Order order) {
        Connection connection = null;
        PreparedStatement orderStatement = null;
        PreparedStatement itemStatement = null;
        ResultSet generatedKeys = null;

        try {
            // Get the database connection
            connection = DBConnection.getConnection();

            // Insert order details into the "orders" table
            String insertOrderSQL = "INSERT INTO orders (total_price) VALUES (?)";
            orderStatement = connection.prepareStatement(insertOrderSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            orderStatement.setDouble(1, order.getTotalPrice());

            // Execute the statement and get the generated order ID
            int affectedRows = orderStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }

            // Get the generated order ID
            generatedKeys = orderStatement.getGeneratedKeys();
            int orderId;
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }

            // Insert each item from the cart into the "order_items" table
            String insertOrderItemSQL = "INSERT INTO order_items (order_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";
            itemStatement = connection.prepareStatement(insertOrderItemSQL);
            for (CartItem item : order.getItems()) {
                itemStatement.setInt(1, orderId);
                itemStatement.setString(2, item.getProductName());
                itemStatement.setInt(3, item.getQuantity());
                itemStatement.setDouble(4, item.getPrice());
                itemStatement.addBatch(); // Add to batch for bulk execution
            }

            // Execute batch insertion for order items
            itemStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            closeResultSet(generatedKeys);
            closeStatements(orderStatement, itemStatement);
            closeConnection(connection);
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStatements(PreparedStatement... statements) {
        for (PreparedStatement statement : statements) {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
