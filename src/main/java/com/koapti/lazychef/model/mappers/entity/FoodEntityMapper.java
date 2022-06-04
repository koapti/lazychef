package com.koapti.lazychef.model.mappers.entity;

import com.koapti.lazychef.model.entity.Food;
import com.koapti.lazychef.model.types.FoodType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodEntityMapper {

    public static Food toFoodEntity(final com.koapti.lazychef.api.model.Food food) {
        Food foodEntity = new Food();
        foodEntity.setId(food.getId());
        foodEntity.setName(food.getName());
        foodEntity.setCost(food.getCost().doubleValue());
        foodEntity.setType(FoodType.valueOf(food.getType().name()));
        return foodEntity;
    }
}
