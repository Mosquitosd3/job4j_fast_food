package order.service;

import domain.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> findAllOrder();
    Order findOrderById(int id);
    void deleteOrder(int id);
}
