package com.example.cafeshop.web.dto.dish;

import com.example.cafeshop.web.dto.validation.OnCreate;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
public class DishDto {

    @NotNull(message = "Name must be not null", groups = {OnUpdate.class})
    private Long id;

    @NotNull(message = "Title must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String title;

    @NotNull(message = "Description must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 1023, message = "Name length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String description;

    @NotNull(message = "Price must be not null", groups = {OnUpdate.class})
    private Double price;

    @NotNull(message = "Weight must be not null", groups = {OnUpdate.class})
    private Double weight;


    private Set<String> images;

}
