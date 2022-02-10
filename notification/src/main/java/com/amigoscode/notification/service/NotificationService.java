package com.amigoscode.notification.service;

import com.amigoscode.notification.model.Notification;
import com.amigoscode.notification.reporitory.Notifications;
import com.amigoscode.notification.service.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotificationService {

    private final Notifications notifications;

    public void send(NotificationRequest notificationRequest) {
        this.notifications.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Amigsocode")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
