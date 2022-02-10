package com.amigoscode.notification.service.dto;

public record NotificationRequest(Integer toCustomerId, String toCustomerName, String message) {
}
