package com.amigoscode.notification;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;
    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;
    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(this.notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(this.notificationQueue())
                .to(this.internalTopicExchange())
                .with(this.internalNotificationRoutingKey);
    }
}
