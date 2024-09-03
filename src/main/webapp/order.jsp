<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Food Order</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1 style="background-color:#c5ae89">Online Food Order</h1>
    </header>
    <main>
        <form action="AddToCartServlet" method="post">
            <div>
                <label>Fruits and Nuts Bowl:</label> RS.2000.00
                <input type="checkbox" name="productName" value="Fruits and Nuts Bowl"> 
                <img src="images/cart1.jpg" width="400" height="500" alt="Fruits and Nuts Bowl"/>
            </div>
            <div>
                <label>Fried Rice:</label> RS.1500.00
                <input type="checkbox" name="productName" value="Fried Rice"> 
                <img src="images/cart2.jpg" width="400" height="500" alt="Fried Rice"/>
            </div>
            <div>
                <label>Curry with Rice and Seafood:</label> RS.2000.00
                <input type="checkbox" name="productName" value="Curry with Rice and Seafood Served on Banana Leaf"> 
                <img src="images/cart3.jpg" width="400" height="500" alt="Curry with Rice and Seafood"/>
            </div>
            <div>
                <label>Noodle with Meat:</label> RS.1700.00
                <input type="checkbox" name="productName" value="Noodle with Meat"> 
                <img src="images/cart4.jpg" width="400" height="500" alt="Noodle with Meat"/>
            </div>
            <div>
                <label>Bowl of Noodles with Greens:</label> RS.1800.00
                <input type="checkbox" name="productName" value="Bowl of Noodles with Greens"> 
                <img src="images/cart5.jpg" width="400" height="500" alt="Bowl of Noodles with Greens"/>
            </div>
            <button type="submit">Add to Cart</button>
        </form>
    </main>
</body>
</html>
