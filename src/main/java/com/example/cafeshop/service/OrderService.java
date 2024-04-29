package com.example.cafeshop.service;

import com.example.cafeshop.domain.order.Order;

import java.util.List;

public interface OrderService {

    Order getById(Long orderId);

    List<Order> getAllByUserId(Long userId);

    Order update(Order order);

    Order create(Order order);

    void delete(Long orderId);

}
