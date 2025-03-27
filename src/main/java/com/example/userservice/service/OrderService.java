package com.example.userservice.service;

import com.example.userservice.messaging.MessagePublisher;
import com.example.userservice.model.EmailNotification;
import com.example.userservice.model.Order;
import com.example.userservice.model.User;
import com.example.userservice.repository.OrderRepository;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.request.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final MessagePublisher messagePublisher;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, MessagePublisher messagePublisher, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.messagePublisher = messagePublisher;
        this.userRepository = userRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public Order createOrder(OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUserId()).orElseThrow(() ->
                new RuntimeException("Usuario no encontrado"));

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setDate(orderRequest.getDate());
        newOrder.setRuc(orderRequest.getRuc());
        newOrder.setAddress(orderRequest.getAddress());
        newOrder.setNro(UUID.randomUUID().toString().substring(0, 8).toUpperCase());

        Order savedOrder = orderRepository.save(newOrder);
        logger.info("Order created successfully: {}", savedOrder.getId());

        try {
            EmailNotification notification = EmailNotification.forNewOrderRegistration(savedOrder);
            messagePublisher.publishEmailNotification(notification);
        } catch (Exception e) {
            logger.error("Failed to process email notification: {}", e.getMessage());
        }

        return savedOrder;
    }

}
