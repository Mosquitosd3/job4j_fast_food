package domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "notifications")
public class Notification {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String numberPhone;
    private String email;

    public Notification(Order order) {
        this.name = order.getUser().getFirstname();
        this.numberPhone = order.getUser().getNumberPhone();
        this.email = order.getUser().getEmail();
    }
}
