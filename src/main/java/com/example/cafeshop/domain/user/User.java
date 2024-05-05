package com.example.cafeshop.domain.user;

import com.example.cafeshop.domain.order.Order;
import com.example.cafeshop.web.dto.validation.OnCreate;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "login", unique = true)
    private String login;

    private String password;

    @Transient
    private String passwordConfirmation;

    @ElementCollection
    @CollectionTable(name = "users_roles")
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @CollectionTable(name = "users_orders")
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> orders;

}
