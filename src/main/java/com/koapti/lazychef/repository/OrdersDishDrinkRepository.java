package com.koapti.lazychef.repository;

import com.koapti.lazychef.model.entity.OrdersDishesDrink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDishDrinkRepository extends JpaRepository<OrdersDishesDrink, Integer> {
}