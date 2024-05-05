package com.example.cafeshop.web.controller;

import com.example.cafeshop.domain.order.Order;
import com.example.cafeshop.service.OrderService;
import com.example.cafeshop.web.dto.order.OrderDto;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import com.example.cafeshop.web.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();

        return orderMapper.toDto(orders);
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id) {
        Order order = orderService.getById(id);

        return orderMapper.toDto(order);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.delete(id);
    }

    @PutMapping
    public OrderDto update(@Validated(OnUpdate.class) @RequestBody OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Order updatedOrder = orderService.update(order);

        return orderMapper.toDto(updatedOrder);
    }

}
