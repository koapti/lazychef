package com.koapti.lazychef.http.service;

import java.util.Optional;

import com.koapti.lazychef.model.entity.Food;
import com.koapti.lazychef.repository.FoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class FoodService {

    private final FoodRepository foodRepository;

    public boolean isFoodPresent(final String name) {
        return checkFood(name);
    }

    public Food getFood(final Integer id) {
        return getFoodFromRepository(id);
    }

    private Food getFoodFromRepository(final Integer id) {
        return foodRepository.getById(id);
    }

    private boolean checkFood(final String name) {
        Optional<Food> food = foodRepository.findByName(name);
        return food.isPresent();
    }
}
