package order.service;

import domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> findAllOrder();
    Optional<Order> findOrderById(int id);
    void deleteOrder(Order order);
}
