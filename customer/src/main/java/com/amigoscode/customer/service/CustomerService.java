package com.amigoscode.customer.service;

import com.amigoscode.customer.dto.CustomerRequest;
import com.amigoscode.customer.dto.FraudCheckResponse;
import com.amigoscode.customer.model.Customer;
import com.amigoscode.customer.repository.Customers;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(Customers customers, RestTemplate restTemplate) {

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        this.customers.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = this.restTemplate.getForObject(
                "http://FRAUD/api/v1/frauds/{customerId}",
                FraudCheckResponse.class,
                customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
