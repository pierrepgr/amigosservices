package com.amigoscode.customer.dto;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email) {
}
