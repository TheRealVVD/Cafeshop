package com.example.cafeshop.service.impl;

import com.example.cafeshop.domain.exception.ResourceNotFoundException;
import com.example.cafeshop.domain.user.Role;
import com.example.cafeshop.domain.user.User;
import com.example.cafeshop.repository.UserRepository;
import com.example.cafeshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
    }

    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User create(User user) {
        Set<Role> roles = Set.of(Role.ROLE_USER);
        user.setRoles(roles);
        userRepository.save(user);

        return user;
    }

    @Override
    public boolean isOrderOwner(Long userId, Long orderId) {
        return userRepository.isOrderOwner(userId, orderId);
    }

    @Override
    public void delete(Long userId) {

    }
}
