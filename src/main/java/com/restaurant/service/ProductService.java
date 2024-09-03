package com.restaurant.service;

import com.restaurant.dao.ProductDAO;
import com.restaurant.model.Product;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAO();
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }
}
