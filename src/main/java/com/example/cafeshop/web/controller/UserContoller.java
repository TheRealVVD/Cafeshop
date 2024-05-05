package com.example.cafeshop.web.controller;

import com.example.cafeshop.domain.order.Order;
import com.example.cafeshop.domain.user.User;
import com.example.cafeshop.service.OrderService;
import com.example.cafeshop.service.UserService;
import com.example.cafeshop.web.dto.order.OrderDto;
import com.example.cafeshop.web.dto.user.UserDto;
import com.example.cafeshop.web.dto.validation.OnCreate;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import com.example.cafeshop.web.mappers.OrderMapper;
import com.example.cafeshop.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "User API")
public class UserContoller {

    private final UserService userService;
    private final UserMapper userMapper;

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PutMapping
    @Operation(summary = "Update user")
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);

        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);

        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by ID")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/orders")
    @Operation(summary = "Get all user orders")
    public List<OrderDto> getOrdersByUserId(@PathVariable Long id) {
        List<Order> orders = orderService.getAllByUserId(id);

        return orderMapper.toDto(orders);
    }

    @PostMapping("/{id}/orders")
    @Operation(summary = "Add order to user")
    public OrderDto addOrder(@PathVariable Long id,
                             @Validated(OnCreate.class) @RequestBody OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Order createdOrder = orderService.create(order, id);

        return orderMapper.toDto(createdOrder);

    }

}
