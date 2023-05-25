package com.neosoft.ms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.ms.model.Customer;
import com.neosoft.ms.service.OrderClient;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
    private List<Customer> customers = Arrays.asList(
            new Customer(1, "Joe Bloggs", "Joe@gmail.com", "Street 1, LA"),
            new Customer(2, "Jane Doe", "Janed@gmail.com", "Near palms LA"));
    
    private OrderClient orderClient;
    
    @GetMapping("/message")
    public String test() {
        return "Hello, This is Customer microservice";
    }
    
    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customers;
    }
    
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer custId) {
        return customers.stream()
                        .filter(customer -> customer.getCustId() == custId)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
    }
    
    @GetMapping("/{id}/orders")
    public Object getOrdersForCustomer(@PathVariable Integer custId) {
        return orderClient.getOrdersForCustomer(custId);
    }
}

