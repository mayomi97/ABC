<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 50px;
        }
        .success-message {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            border-radius: 5px;
            display: inline-block;
        }
        .home-button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #008CBA;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .home-button:hover {
            background-color: #005f75;
        }
    </style>
</head>
<body>
    <div class="success-message">
        <h1>Reservation Successful!</h1>
        <p>Thank you for your reservation. We look forward to serving you.</p>
    </div>
    <a class="home-button" href="index.jsp">Return to Home</a>
</body>
</html>
