<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Order Confirmation</h1>
    </header>
    <main>
   
        <p>Thank you, <strong>${customerName}</strong>! Your order has been placed successfully.</p>

        <h2>Order Summary</h2>
        <table>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>
            <c:forEach var="item" items="${cart.products}">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
                <td>${item.price * item.quantity}</td>
            </tr>
            </c:forEach>
        </table>

        <h3>Total Amount: $<c:out value="${cart.totalAmount}" /></h3>

        <p>Your order will be delivered to: <strong>${deliveryAddress}</strong></p>

        <a href="index.jsp">Continue Shopping</a>
    </main>
</body>
</html>
