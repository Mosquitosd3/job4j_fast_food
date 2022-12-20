package notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"domain"})
public class NotificationMainApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationMainApp.class, args);
    }
}
