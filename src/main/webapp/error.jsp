<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .message {
            font-size: 24px;
            color: #f44336; /* Red color for error */
        }
        .button {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: #f44336;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .button a {
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="message">
        <h1>Something went wrong!</h1>
        <p><%= session.getAttribute("message") %></p>
    </div>
    <div>
        <button class="button"><a href="index.jsp">Back to Home</a></button>
    </div>
    <% session.removeAttribute("message"); %> <!-- Clear message after displaying -->
</body>
</html>
