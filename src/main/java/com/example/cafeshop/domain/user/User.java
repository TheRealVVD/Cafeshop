package com.example.cafeshop.domain.user;

import com.example.cafeshop.domain.order.Order;
import com.example.cafeshop.web.dto.validation.OnCreate;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Data
public class User {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @NotNull(message = "Login must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String login;

    @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String password;
    private String passwordConfirmation;
    private Set<Role> roles;
    private List<Order> orders;

}
