package com.koapti.lazychef.repository;

import com.koapti.lazychef.model.entity.OrdersFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersFoodRepository extends JpaRepository<OrdersFood, Integer> {
}