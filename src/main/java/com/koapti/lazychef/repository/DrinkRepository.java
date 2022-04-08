package com.koapti.lazychef.repository;

import com.koapti.lazychef.model.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}