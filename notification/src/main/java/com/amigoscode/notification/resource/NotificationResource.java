package com.amigoscode.notification.resource;

import com.amigoscode.notification.service.NotificationService;
import com.amigoscode.notification.service.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/notifications")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotificationResource {

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification {}", notificationRequest);
        this.notificationService.send(notificationRequest);
    }
}
