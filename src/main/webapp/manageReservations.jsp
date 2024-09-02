<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.restaurant.model.Reservation" %>
<%@ page import="com.restaurant.service.ReservationService" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Reservations - Customer Reservation Report</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Manage Reservations</h1>
        <nav>
            <a href="adminDashboard.jsp">Home</a>
            <a href="viewReports.jsp">View Reports</a>
            <a href="logout.jsp">Logout</a>
        </nav>
    </header>
    <main>
        <h2>Customer Reservation Report</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Number of People</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ReservationService reservationService = new ReservationService();
                    List<Reservation> reservations = reservationService.getAllReservations();
                    for (Reservation reservation : reservations) {
                %>
                    <tr>
                        <td><%= reservation.getName() %></td>
                        <td><%= reservation.getDate() %></td>
                        <td><%= reservation.getTime() %></td>
                        <td><%= reservation.getPeople() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </main>
</body>
</html>
