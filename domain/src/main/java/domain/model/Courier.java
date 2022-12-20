package domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Courier {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String numberPhone;
    private List<Order> orders = new ArrayList<>();
    private String email;
    private String password;
}
