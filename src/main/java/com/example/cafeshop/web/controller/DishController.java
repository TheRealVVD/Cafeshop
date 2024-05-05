package com.example.cafeshop.web.controller;

import com.example.cafeshop.domain.dish.Dish;
import com.example.cafeshop.service.DishService;
import com.example.cafeshop.web.dto.dish.DishDto;
import com.example.cafeshop.web.mappers.DishMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dishes")
@RequiredArgsConstructor
//@Validated
public class DishController {

      private final DishService dishService;
      private final DishMapper dishMapper;

      @GetMapping
      public List<DishDto> getAllDishes() {
            List<Dish> dishes = dishService.getAllDishes();
            List<DishDto> dishDtos = dishMapper.toDto(dishes);

            return dishDtos;
      }

      @GetMapping("/{id}")
      public DishDto getById(@PathVariable Long id) {
            Dish dish = dishService.getById(id);

            return dishMapper.toDto(dish);
      }

}
