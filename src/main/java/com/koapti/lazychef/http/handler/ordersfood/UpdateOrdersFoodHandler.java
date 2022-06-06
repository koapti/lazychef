package com.koapti.lazychef.http.handler.ordersfood;

import com.koapti.lazychef.api.model.OrdersFood;
import com.koapti.lazychef.http.service.FoodService;
import com.koapti.lazychef.http.service.OrderService;
import com.koapti.lazychef.model.states.FoodState;
import com.koapti.lazychef.repository.OrdersFoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class UpdateOrdersFoodHandler {

    private final OrdersFoodRepository ordersFoodRepository;
    private final FoodService foodService;
    private final OrderService orderService;

    public void handle(final String id, final OrdersFood ordersFood) {
        com.koapti.lazychef.model.entity.OrdersFood savedOrdersFood = ordersFoodRepository.getById(Integer.valueOf(id));
        ordersFoodRepository.save(updateOrdersFood(ordersFood, savedOrdersFood));
    }

    private com.koapti.lazychef.model.entity.OrdersFood updateOrdersFood(final com.koapti.lazychef.api.model.OrdersFood ordersFood,
                                                                         final com.koapti.lazychef.model.entity.OrdersFood ordersFoodEntity) {
        ordersFoodEntity.setComments(ordersFoodEntity.getComments());
        ordersFoodEntity.setState(FoodState.valueOf(ordersFood.getFoodState().name()));
        ordersFoodEntity.setIdFoodFk(foodService.getFood(ordersFood.getId().toString()));
        ordersFoodEntity.setIdOrderFk(orderService.getOrder(ordersFood.getId().toString()));
        return ordersFoodEntity;
    }
}
