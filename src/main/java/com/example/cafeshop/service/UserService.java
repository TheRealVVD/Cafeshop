package com.example.cafeshop.service;

import com.example.cafeshop.domain.user.User;

public interface UserService {

    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    User create(User user);
    boolean isOrderOwner(Long userId, Long orderId);
    void delete(Long userId);

}
