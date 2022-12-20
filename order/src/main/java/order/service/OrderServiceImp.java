package order.service;

import domain.model.Order;
import order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {
    private OrderRepository repository;

    public OrderServiceImp(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public List<Order> findAllOrder() {
        List<Order> orders = new ArrayList<>();
        repository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public Optional<Order> findOrderById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteOrder(Order order) {
        repository.delete(order);
    }
}
