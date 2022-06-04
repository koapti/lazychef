package com.koapti.lazychef.model.mappers.api;

import java.math.BigDecimal;

import com.koapti.lazychef.api.model.Food;
import com.koapti.lazychef.api.model.FoodType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodApiMapper {

    public static Food toApiFood(com.koapti.lazychef.model.entity.Food food) {
        return Food.builder()
                .id(food.getId())
                .name(food.getName())
                .cost(BigDecimal.valueOf(food.getCost()))
                .type(FoodType.valueOf(food.getType().name()))
                .build();
    }
}
