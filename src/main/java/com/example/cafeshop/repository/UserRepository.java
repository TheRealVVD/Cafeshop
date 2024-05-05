package com.example.cafeshop.repository;

import com.example.cafeshop.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Query(value = """
            SELECT exists(
                SELECT 1 
                FROM users_orders
                WHERE user_id = :userId
                AND order_id = :orderId
            )
            """, nativeQuery = true)
    boolean isOrderOwner(@Param("userId") Long userId,
                         @Param("orderId") Long orderId);

}
