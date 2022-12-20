package notification.controller;

import domain.model.Notification;
import domain.model.Order;
import notification.service.NotificationService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification/order")
public class OrderConsumerController {
    private NotificationService service;

    public OrderConsumerController(NotificationService service) {
        this.service = service;
    }

    @KafkaListener(topics = {"order"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) {
        service.saveNotification(new Notification(input.value()));
    }
}
