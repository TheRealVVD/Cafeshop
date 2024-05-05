package com.example.cafeshop.web.dto.dish;

import com.example.cafeshop.web.dto.validation.OnCreate;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
@Schema(description = "Dish DTO")
public class DishDto {

    @Schema(description = "Dish ID", example = "17")
    @NotNull(message = "Name must be not null", groups = {OnUpdate.class})
    private Long id;

    @Schema(description = "Dish title", example = "Borsch")
    @NotNull(message = "Title must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String title;

    @Schema(description = "Dish description", example = "Ukrainian traditional soup")
    @NotNull(message = "Description must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 1023, message = "Description length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String description;

    @Schema(description = "Price per serving", example = "99.00")
    @NotNull(message = "Price must be not null", groups = {OnCreate.class, OnUpdate.class})
    private Double price;

    @Schema(description = "Weight of serving", example = "250.00 g")
    @NotNull(message = "Weight must be not null", groups = {OnCreate.class, OnUpdate.class})
    private Double weight;

//    private Set<String> images;

}
