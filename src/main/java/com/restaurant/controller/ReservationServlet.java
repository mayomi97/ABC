package com.restaurant.controller;

import com.restaurant.dao.ReservationDAO;
import com.restaurant.model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/reservation") // Ensure this matches your URL path
public class ReservationServlet extends HttpServlet {
    private ReservationDAO reservationDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        reservationDAO = new ReservationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String peopleStr = request.getParameter("people");
        String message = null;

        try {
            int people = Integer.parseInt(peopleStr);

            Reservation reservation = new Reservation(name, date, time, people);
            reservationDAO.addReservation(reservation);

            message = "Reservation successfully made!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("reservationSuccess.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            message = "Invalid number format for the number of people.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("reservationError.jsp").forward(request, response);
        } catch (Exception e) {
            message = "An unexpected error occurred: " + e.getMessage();
            request.setAttribute("message", message);
            request.getRequestDispatcher("reservationError.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Reservation> reservations = reservationDAO.getAllReservations();
            request.setAttribute("reservations", reservations);
            request.getRequestDispatcher("viewReservations.jsp").forward(request, response);
        } catch (Exception e) {
            String message = "An error occurred while retrieving reservations: " + e.getMessage();
            request.setAttribute("message", message);
            request.getRequestDispatcher("reservationError.jsp").forward(request, response);
        }
    }
}
