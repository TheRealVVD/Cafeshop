package com.example.cafeshop.domain.user;

import com.example.cafeshop.domain.order.Order;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class User {

    private Long id;
    private String name;
    private String login;
    private Set<Role> roles;
    private List<Order> orders;

}
