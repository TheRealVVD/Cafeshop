package com.example.cafeshop.service.impl;

import com.example.cafeshop.domain.user.User;
import com.example.cafeshop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public boolean isOrderOwner(Long userId, Long orderId) {
        return false;
    }

    @Override
    public void delete(Long userId) {

    }
}
