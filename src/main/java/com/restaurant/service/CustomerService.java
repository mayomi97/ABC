package com.restaurant.service;

import com.restaurant.dao.CustomerDAO;
import com.restaurant.model.Customer;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    // Method to register a customer
    public void registerCustomer(String name, String email, String password) {
        Customer customer = new Customer(name, email, password);
        customerDAO.registerCustomer(customer);
    }

    // Method to check customer login credentials
    public Customer loginCustomer(String email, String password) {
        Customer customer = customerDAO.getCustomerByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }
}

