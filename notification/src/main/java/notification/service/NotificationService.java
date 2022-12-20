package notification.service;

import domain.model.Notification;
import notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification saveNotification(Notification notification) {
        return repository.save(notification);
    }

    public List<Notification> findAllNotification() {
        List<Notification> rsl = new ArrayList<>();
        repository.findAll().forEach(rsl::add);
        return rsl;
    }

    public Optional<Notification> findNotificationById(int id) {
        return repository.findById(id);
    }

    public boolean deleteNotification(Notification notification) {
        boolean isFind = findNotificationById(notification.getId()).isPresent();
        if (isFind) {
            repository.delete(notification);
            return true;
        } else {
            return false;
        }
    }
}
