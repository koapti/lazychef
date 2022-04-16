package com.koapti.lazychef.repository;

import com.koapti.lazychef.model.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}