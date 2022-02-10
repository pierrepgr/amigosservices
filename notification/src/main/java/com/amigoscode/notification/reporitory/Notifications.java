package com.amigoscode.notification.reporitory;

import com.amigoscode.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Notifications extends JpaRepository<Notification, Integer> {
}
