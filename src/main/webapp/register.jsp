<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Customer Registration</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1 style="background-color:#c5ae89">Register</h1>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="login.jsp">Login</a>
        </nav>
    </header>
    <main>
        <form action="RegisterServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br><br>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            
            <input type="submit" value="Register">
        </form>
    </main>
</body>
</html>
