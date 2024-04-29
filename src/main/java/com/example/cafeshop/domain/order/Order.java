package com.example.cafeshop.domain.order;

import com.example.cafeshop.domain.dish.Dish;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Order {

    private Long id;
    private Integer totalAmount;
    private Double totalPrice;
    private Status status;
    private LocalDateTime creationTime;
    private LocalDateTime expirationTime;
    private Set<Dish> dishes;

}
