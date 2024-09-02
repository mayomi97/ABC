<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Order Success</h1>
    </header>
    <main>
        <h2>
            <%
                String message = (String) session.getAttribute("message");
                if (message != null) {
                    out.println(message);
                    session.removeAttribute("message"); // Remove after displaying to prevent reuse
                }
            %>
        </h2>
        <p>Thank you for your order. We will process it shortly.</p>
        <a href="index.jsp">Return to Home</a>
    </main>
</body>
</html>
