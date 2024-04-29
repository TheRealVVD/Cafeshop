package com.example.cafeshop.web.mappers;

import com.example.cafeshop.domain.order.Order;
import com.example.cafeshop.web.dto.order.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order order);
    List<OrderDto> toDto(List<Order> orders);
    Order toEntity(OrderDto orderDto);
    List<Order> toEntity(List<OrderDto> orderDtos);

}
