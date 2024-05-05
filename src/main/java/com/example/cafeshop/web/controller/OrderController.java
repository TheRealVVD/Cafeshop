package com.example.cafeshop.web.controller;

import com.example.cafeshop.domain.order.Order;
import com.example.cafeshop.service.OrderService;
import com.example.cafeshop.web.dto.order.OrderDto;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import com.example.cafeshop.web.mappers.OrderMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Validated
@Tag(name = "Order Controller", description = "Order API")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    @Operation(summary = "Get all orders")
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();

        return orderMapper.toDto(orders);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID")
    public OrderDto getById(@PathVariable Long id) {
        Order order = orderService.getById(id);

        return orderMapper.toDto(order);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete order by ID")
    public void deleteById(@PathVariable Long id) {
        orderService.delete(id);
    }

    @PutMapping
    @Operation(summary = "Update order")
    public OrderDto update(@Validated(OnUpdate.class) @RequestBody OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Order updatedOrder = orderService.update(order);

        return orderMapper.toDto(updatedOrder);
    }

}
