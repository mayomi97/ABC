package com.restaurant.dao;

import com.restaurant.model.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/abc_restaurant";
    private static final String USER = "root";
    private static final String PASSWORD = "Mayo970628$";

    // Method to add a reservation
    public void addReservation(Reservation reservation) {
        String query = "INSERT INTO reservations (name, date, time, people) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            stmt.setString(1, reservation.getName());
            stmt.setString(2, reservation.getDate()); // Ensure date format is compatible
            stmt.setString(3, reservation.getTime()); // Ensure time format is compatible
            stmt.setInt(4, reservation.getPeople());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the error or rethrowing a custom exception
        }
    }

    // Method to get all reservations
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                String name = rs.getString("name");
                String date = rs.getString("date");
                String time = rs.getString("time");
                int people = rs.getInt("people");
                
                reservations.add(new Reservation(name, date, time, people));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the error or rethrowing a custom exception
        }
        
        return reservations;
    }
}
