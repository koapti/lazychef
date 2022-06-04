package com.koapti.lazychef.http.handler.food;

import java.util.Optional;

import com.koapti.lazychef.api.model.Food;
import com.koapti.lazychef.http.exceptions.FoodNotFoundException;
import com.koapti.lazychef.model.mappers.api.FoodApiMapper;
import com.koapti.lazychef.repository.FoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetFoodDetailsHandler {

    private final FoodRepository foodRepository;

    public Food handle(final String id) throws FoodNotFoundException {
        Optional<com.koapti.lazychef.model.entity.Food> food = foodRepository.findById(Integer.parseInt(id));
        if (food.isPresent()) {
            return FoodApiMapper.toApiFood(food.get());
        }
        throw new FoodNotFoundException("Food was not found");
    }
}
