<%@ page import="com.restaurant.model.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Checkout</h1>
    </header>
    <main>
        <h2>Review Your Order</h2>
        <%
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
                out.println("<p>Your cart is empty.</p>");
            } else {
        %>
        <table border="1">
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <%
                double totalPrice = 0.0;
                for (CartItem item : cart) {
                    out.println("<tr>");
                    out.println("<td>" + item.getProductName() + "</td>");
                    out.println("<td>" + item.getQuantity() + "</td>");
                    out.println("<td>RS." + item.getPrice() + "</td>");
                    out.println("</tr>");
                    totalPrice += item.getPrice();
                }
            %>
            <tr>
                <td colspan="2">Total Price</td>
                <td>RS.<%= totalPrice %></td>
            </tr>
        </table>
        <h3>Enter Your Details</h3>
        <form action="CheckoutServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br><br>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required><br><br>
            
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required><br><br>
            
            <button type="submit">Place Order</button>
        </form>
        <%
            }
        %>
    </main>
</body>
</html>
