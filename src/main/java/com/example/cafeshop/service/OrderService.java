package com.example.cafeshop.service;

import com.example.cafeshop.domain.order.Order;

import java.util.List;

public interface OrderService {

    Order getById(Long orderId);

    List<Order> getAllByUserId(Long userId);

    List<Order> getAllOrders();

    Order update(Order order);

    Order create(Order order, Long userId);

    void delete(Long orderId);

}
