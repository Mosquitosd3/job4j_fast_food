package notification.controller;

import domain.model.Notification;
import notification.repository.NotificationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private NotificationRepository repository;

    public NotificationController(NotificationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Notification> findAllNotification() {
        List<Notification> rsl = new ArrayList<>();
        repository.findAll().forEach(rsl::add);
        return rsl;
    }
}
