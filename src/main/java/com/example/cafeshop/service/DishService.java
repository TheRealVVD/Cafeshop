package com.example.cafeshop.service;

import com.example.cafeshop.domain.dish.Dish;

import java.util.List;

public interface DishService {

    Dish getById(Long dishId);
    List<Dish> getAllDishes();
    Dish create(Dish dish);
    Dish update(Dish dish);
    void delete(Long dishId);

}
