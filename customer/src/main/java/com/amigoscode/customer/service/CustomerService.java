package com.amigoscode.customer.service;

import com.amigoscode.customer.dto.CustomerRequest;
import com.amigoscode.customer.model.Customer;
import com.amigoscode.customer.repository.Customers;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(Customers customers) {

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        this.customers.save(customer);
    }
}
