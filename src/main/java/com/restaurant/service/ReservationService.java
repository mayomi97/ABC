package com.restaurant.service;

import com.restaurant.dao.ReservationDAO;
import com.restaurant.model.Reservation;

import java.util.List;

public class ReservationService {
    private ReservationDAO reservationDAO;

    public ReservationService() {
        reservationDAO = new ReservationDAO();
    }

    // Method to add a reservation
    public void addReservation(String name, String date, String time, int people) {
        Reservation reservation = new Reservation(name, date, time, people);
        reservationDAO.addReservation(reservation);
    }

    // Method to get all reservations
    public List<Reservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }
    
}
