package com.koapti.lazychef.http.handler.food;

import com.koapti.lazychef.api.model.Food;
import com.koapti.lazychef.model.types.FoodType;
import com.koapti.lazychef.repository.FoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class UpdateFoodHandler {

    private final FoodRepository foodRepository;

    public void handle(final String id, final Food food) {
        com.koapti.lazychef.model.entity.Food foodEntity = foodRepository.getById(Integer.parseInt(id));
        foodRepository.save(updateFood(food, foodEntity));
    }

    private com.koapti.lazychef.model.entity.Food updateFood(final com.koapti.lazychef.api.model.Food food,
                                                             final com.koapti.lazychef.model.entity.Food foodEntity) {
        foodEntity.setName(food.getName());
        foodEntity.setCost(food.getCost().doubleValue());
        foodEntity.setType(FoodType.valueOf(food.getType().name()));
        return foodEntity;
    }
}
