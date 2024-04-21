package com.example.cafeshop.domain.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    private Long id;
    private Integer totalAmount;
    private Double totalPrice;
    private Status status;
    private LocalDateTime creationTime;
    private LocalDateTime expirationTime;
//    private Set<Dish> dishes;

}
