package com.example.cafeshop.repository;

import com.example.cafeshop.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = """
            SELECT * FROM orders o
            JOIN users_orders uo ON uo.order_id = o.id
            WHERE user_id = :userId
            """, nativeQuery = true)
    List<Order> findAllByUserId(@Param("userId") Long userId);

}
