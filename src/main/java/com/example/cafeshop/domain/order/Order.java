package com.example.cafeshop.domain.order;

import com.example.cafeshop.domain.dish.Dish;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer totalAmount;

    private Double totalPrice;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private LocalDateTime creationTime;

    private LocalDateTime expirationTime;


//    private Set<Dish> dishes;

}
