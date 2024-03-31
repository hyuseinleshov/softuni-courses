package bg.softuni.softunigamestorefix.services.impl;

import bg.softuni.softunigamestorefix.repositories.OrderRepository;
import bg.softuni.softunigamestorefix.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
