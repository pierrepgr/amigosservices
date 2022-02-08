package com.amigoscode.customer.service;

import com.amigoscode.customer.dto.CustomerRequest;
import com.amigoscode.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
    }
}
