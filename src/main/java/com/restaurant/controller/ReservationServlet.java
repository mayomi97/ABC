package com.restaurant.controller;
import com.restaurant.service.ReservationService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reservationServlet")
public class ReservationServlet extends HttpServlet {
    private ReservationService reservationService = new ReservationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int people = Integer.parseInt(request.getParameter("people"));

        reservationService.addReservation(name, date, time, people);

        response.sendRedirect("home.jsp");
    }
}
