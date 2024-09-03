<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1 style="background-color:#c5ae89">ABC Restaurant - Menu</h1>
    </header>
    <main>
         <a href="index.jsp">Home</a>
        <h2>Our Specialties</h2>
        <p>Explore our menu and enjoy a variety of dishes!</p>
        <!-- Drinks Section -->
        <section class="menu-section" id="drinks">
            <h2>Drinks Menu</h2>
            <img src="images/drinks.jpg" width="400" 
     height="500" alt="Drinks Image"/>
            <div class="menu-content">
                <h3>Fresh Juices</h3>
                <ul>
                    <li>Orange Juice</li>
                    <li>Apple Juice</li>
                    <li>pineapple Juice</li>
                    <li>Mango Juice</li>
                </ul>
                <h3>Soft Drinks</h3>
                <ul>
                    <li>Coke</li>
                    <li>Sprite</li>
                    <li>Red bull</li>
                    
                </ul>
                 <h3>Hot Drinks</h3>
                <ul>
                    <li>Coffe</li>
                    <li>Chocolate Milk</li>
                    <li>Cuppuccino</li>
                    <li>Cafe Latte</li>
                    <li>Mexican Coffe</li>
                    
                </ul>
            </div>
        </section>

        <!-- Desserts Section -->
        <section class="menu-section" id="desserts">
            <h2>Desserts</h2>
            <img src="images/desserts.jpg"width="400" 
     height="500" alt="Desserts Image"/>
            <div class="menu-content">
                <ul>
                    <li>Ice Cream</li>
                    <li>Fruit Salad</li>
                    <li>Black Forest Gateau</li>
                    <li>Pineapple Cake</li>
                    <li>Chocolet Whip</li>
                </ul>
            </div>
        </section>

        <!-- Tidbits Section -->
        <section class="menu-section" id="tidbits">
            <h2>Tidbits</h2>
            <img src="images/tidbits.jpg" width="400" 
     height="500"alt="Tidbits Image"/>
            <div class="menu-content">
                <ul>
                    <li>Fried Cashew Nuts</li>
                    <li>Roasted Almonds</li>
                </ul>
            </div>
        </section>

 
    </main>
</body>
</html>
