package com.example.cafeshop.domain.dish;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "dishes")
@Data
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private Double price;

    private Double weight;


//    private Set<String> images;

}
