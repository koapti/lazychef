package com.koapti.lazychef.model.mappers.api;

import com.koapti.lazychef.api.model.FoodState;
import com.koapti.lazychef.api.model.OrdersFood;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrdersFoodApiMapper {

    public static OrdersFood toApiOrdersFood(final com.koapti.lazychef.model.entity.OrdersFood ordersFood) {
        return OrdersFood.builder()
                .id(ordersFood.getId())
                .comments(ordersFood.getComments())
                .foodState(FoodState.valueOf(ordersFood.getState().name()))
                .foodId(ordersFood.getIdFoodFk().getId())
                .orderId(ordersFood.getIdOrderFk().getId())
                .build();
    }
}
