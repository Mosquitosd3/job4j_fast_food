package domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notification {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String numberPhone;
    private String email;

    public Notification(User user) {
        this.name = user.getFirstname();
        this.numberPhone = user.getNumberPhone();
        this.email = user.getEmail();
    }
}
