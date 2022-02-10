package com.amigoscode.customer.service;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.customer.dto.CustomerRequest;
import com.amigoscode.customer.model.Customer;
import com.amigoscode.customer.repository.Customers;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(Customers customers, NotificationClient notificationClient, FraudClient fraudClient) {

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        this.customers.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = this.fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        this.notificationClient.sendNotification(
            new NotificationRequest(
                    customer.getId(),
                    customer.getEmail(),
                    String.format("Hi %s, welcome to Amigoscode...",
                    customer.getFirstName())));
    }
}
