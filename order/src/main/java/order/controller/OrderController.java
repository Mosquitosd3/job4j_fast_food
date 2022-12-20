package order.controller;

import domain.model.Order;
import domain.model.User;
import order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        return new ResponseEntity<Order>(
                service.saveOrder(order),
                HttpStatus.CREATED
        );
    }

    @PatchMapping
    public ResponseEntity<Void> updateOrder(@RequestBody Order order) {
        service.saveOrder(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAllOrder() {
        return new ResponseEntity<List<Order>>(
                service.findAllOrder(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable int id) {
        var order = service.findOrderById(id);
        return new ResponseEntity<Order>(
                order.orElse(new Order()),
                order.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOrder(@RequestBody Order order) {
        service.deleteOrder(order);
        return ResponseEntity.ok().build();
    }
}
