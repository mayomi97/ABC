<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reservation</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1 style="background-color:#c5ae89">Reservation</h1>
    </header>
    <main>
        <form action="ReservationServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required>
            <label for="time">Time:</label>
            <input type="time" id="time" name="time" required>
            <label for="people">Number of People:</label>
            <input type="number" id="people" name="people" required>
            <button type="submit">Reserve</button>
        </form>
    </main>
</body>
</html>
