<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1 style="background-color:#c5ae89">Login</h1>
    </header>
    <main>
        <form action="loginServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <button type="submit">Login</button>
        </form>
        
        <!-- Display error message if login failed -->
        <% if (request.getParameter("error") != null) { %>
            <p style="color: red;">Invalid credentials</p>
        <% } %>

        <!-- Display success message if login was successful -->
        <% if (request.getParameter("success") != null) { %>
            <p style="color: green;">Successfully logged in!</p>
        <% } %>
    </main>
</body>
</html>
