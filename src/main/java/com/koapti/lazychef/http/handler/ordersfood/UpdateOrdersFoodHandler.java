package com.koapti.lazychef.http.handler.ordersfood;

import com.koapti.lazychef.api.model.OrdersFood;
import com.koapti.lazychef.model.states.FoodState;
import com.koapti.lazychef.model.types.FoodType;
import com.koapti.lazychef.repository.OrdersFoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class UpdateOrdersFoodHandler {

    private final OrdersFoodRepository ordersFoodRepository;

    public void handle(final String id, final OrdersFood ordersFood) {
        com.koapti.lazychef.model.entity.OrdersFood savedOrdersFood = ordersFoodRepository.getById(Integer.valueOf(id));
        ordersFoodRepository.save(updateOrdersFood(ordersFood, savedOrdersFood));
    }

    private com.koapti.lazychef.model.entity.OrdersFood updateOrdersFood(final com.koapti.lazychef.api.model.OrdersFood ordersFood,
                                                                         final com.koapti.lazychef.model.entity.OrdersFood ordersFoodEntity) {
        ordersFoodEntity.setComments(ordersFoodEntity.getComments());
        ordersFoodEntity.setState(FoodState.valueOf(ordersFood.getFoodState().name()));
        // TODO: OBGADAC TEN ENDPOINT
        return ordersFoodEntity;
    }
}
