package com.example.cafeshop.service.impl;

import com.example.cafeshop.domain.order.Order;
import com.example.cafeshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getById(Long orderId) {
        return null;
    }

    @Override
    public List<Order> getAllByUserId(Long userId) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public void delete(Long orderId) {

    }
}
