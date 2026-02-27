package com.smartflow.notificationservice.kafka;

import com.smartflow.notificationservice.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderEventConsumer {

    @KafkaListener(topics = "order-created", groupId = "notification-group")
    public void consume(OrderCreatedEvent event) {
        log.info("Received OrderCreated Event : {}", event);

        //Dummy Email System
        log.info("Sending NOtification for orderId: {}", event.getOrderId());
    }

}
