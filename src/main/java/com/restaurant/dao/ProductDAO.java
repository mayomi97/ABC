package com.restaurant.dao;

import com.restaurant.model.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Fruits and Nuts Bowl", 2000.00));
        products.add(new Product(2, "Fried Rice", 1500.00));
        products.add(new Product(3, "Curry with Rice and Seafood", 2000.00));
        products.add(new Product(4, "Noodle with Meat", 1700.00));
        products.add(new Product(5, "Bowl of Noodles Sprinkled with Greens", 1800.00));
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : getAllProducts()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

