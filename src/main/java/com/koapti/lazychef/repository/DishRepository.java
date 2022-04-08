package com.koapti.lazychef.repository;

import com.koapti.lazychef.model.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}