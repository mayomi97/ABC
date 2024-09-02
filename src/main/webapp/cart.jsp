<%@ page import="com.restaurant.model.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Your Cart</h1>
    </header>
    <main>
        <h2>Items in Your Cart:</h2>
        <%
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
                out.println("<p>Your cart is empty.</p>");
            } else {
                for (CartItem item : cart) {
                    out.println("<p>" + item.getProductName() + " - Quantity: " + item.getQuantity() + " - Price: " + item.getPrice() + "</p>");
                }
            }
        %>
        <a href="checkout.jsp">Proceed to Checkout</a>
    </main>
</body>
</html>
