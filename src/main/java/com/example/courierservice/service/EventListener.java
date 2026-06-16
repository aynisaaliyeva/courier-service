package com.example.courierservice.service;

import com.example.courierservice.config.RabbitMQConfig;
import com.example.courierservice.enums.CourierStatus;
import com.example.courierservice.event.OrderAssignedEvent;
import com.example.courierservice.event.OrderDeliveredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventListener {

    private final CourierService courierService;

    @RabbitListener(queues = RabbitMQConfig.ORDER_ASSIGNED_QUEUE)
    public void onOrderAssigned(OrderAssignedEvent event) {
        if (event.getCourierId() != null) {
            courierService.updateCourierStatus(event.getCourierId(), CourierStatus.BUSY);
        }
    }

    @RabbitListener(queues = RabbitMQConfig.ORDER_DELIVERED_QUEUE)
    public void onOrderDelivered(OrderDeliveredEvent event) {
        if (event.getCourierId() != null) {
            courierService.updateCourierStatus(event.getCourierId(), CourierStatus.FREE);
        }
    }
}