<%@ page import="java.util.List, com.restaurant.dao.ReservationDAO, com.restaurant.model.Reservation" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Report</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>Reservation Details</h2>
    <table>
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
                try {
                    ReservationDAO reservationDAO = new ReservationDAO();
                    List<Reservation> reservations = reservationDAO.getAllReservations();
                    
                    for (Reservation reservation : reservations) {
            %>
                <tr>
                    <td><%= reservation.getName() %></td>
                    <td><%= reservation.getDate() %></td>
                    <td><%= reservation.getTime() %></td>
                    <td><%= reservation.getPeople() %></td>
                </tr>
            <% 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<tr><td colspan='5'>Error loading reservation details: " + e.getMessage() + "</td></tr>");
                }
            %>
        </tbody>
    </table>
</body>
</html>
