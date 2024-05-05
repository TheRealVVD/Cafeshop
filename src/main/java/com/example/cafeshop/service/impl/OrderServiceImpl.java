package com.example.cafeshop.service.impl;

import com.example.cafeshop.domain.exception.ResourceNotFoundException;
import com.example.cafeshop.domain.order.Order;
import com.example.cafeshop.domain.order.Status;
import com.example.cafeshop.domain.user.User;
import com.example.cafeshop.repository.OrderRepository;
import com.example.cafeshop.service.OrderService;
import com.example.cafeshop.service.UserService;
import com.example.cafeshop.web.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    public Order getById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order update(Order order) {
        if(order.getStatus() == null) order.setStatus(Status.ACCEPTED);

        orderRepository.save(order);

        return order;
    }

    @Override
    @Transactional
    public Order create(Order order, Long userId) {
        User user = userService.getById(userId);
        order.setStatus(Status.ACCEPTED);
        user.getOrders().add(order);
        userService.update(user);

        orderRepository.save(order);

        return order;
    }

    @Override
    @Transactional
    public void delete(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
