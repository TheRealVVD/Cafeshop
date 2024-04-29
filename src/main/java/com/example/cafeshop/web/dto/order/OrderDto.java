package com.example.cafeshop.web.dto.order;

import com.example.cafeshop.domain.dish.Dish;
import com.example.cafeshop.domain.order.Status;
import com.example.cafeshop.web.dto.validation.OnCreate;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderDto {

    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    private Long id;

    @NotNull(message = "Total amount must be more zero", groups = {OnCreate.class, OnUpdate.class})
    private Integer totalAmount;

    @NotNull(message = "Total price must be not null", groups = {OnCreate.class, OnUpdate.class})
    private Double totalPrice;

    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime creationTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationTime;

    private Set<Dish> dishes;

}
