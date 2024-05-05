package com.example.cafeshop.web.dto.order;

import com.example.cafeshop.domain.dish.Dish;
import com.example.cafeshop.domain.order.Status;
import com.example.cafeshop.web.dto.validation.OnCreate;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Schema(description = "Order DTO")
public class OrderDto {

    @Schema(description = "Order ID", example = "1")
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    private Long id;

    @Schema(description = "Total number of dishes in the order", example = "5")
    @NotNull(message = "Total amount must be more zero", groups = {OnCreate.class, OnUpdate.class})
    private Integer totalAmount;

    @Schema(description = "Total order's price", example = "788.90")
    @NotNull(message = "Total price must be not null", groups = {OnCreate.class, OnUpdate.class})
    private Double totalPrice;

    @Schema(description = "Execution order's status ", example = "ON_THE_WAY")
    private Status status;

    @Schema(description = "Order creation time", example = "2024-01-20 17:11")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime creationTime;

    @Schema(description = "Order completion time", example = "2024-01-20 18:11")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationTime;

    private Set<Dish> dishes;

}
