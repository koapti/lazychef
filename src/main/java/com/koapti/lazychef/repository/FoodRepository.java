package com.koapti.lazychef.repository;

import java.util.Optional;

import com.koapti.lazychef.model.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    Optional<Food> findByName(String name);
}