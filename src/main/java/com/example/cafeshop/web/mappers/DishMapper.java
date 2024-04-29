package com.example.cafeshop.web.mappers;

import com.example.cafeshop.domain.dish.Dish;
import com.example.cafeshop.web.dto.dish.DishDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {

    DishDto toDto(Dish dish);
    List<DishDto> toDto(List<Dish> dishes);
    Dish toEntity(DishDto dishDto);
    List<Dish> toEntity(List<DishDto> dishDtos);

}
