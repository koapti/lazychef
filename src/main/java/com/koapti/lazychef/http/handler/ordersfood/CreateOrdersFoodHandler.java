package com.koapti.lazychef.http.handler.ordersfood;

import com.koapti.lazychef.api.model.OrdersFood;
import com.koapti.lazychef.http.service.FoodService;
import com.koapti.lazychef.http.service.OrderService;
import com.koapti.lazychef.model.states.FoodState;
import com.koapti.lazychef.repository.OrdersFoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CreateOrdersFoodHandler {

    private final OrdersFoodRepository ordersFoodRepository;
    private final FoodService foodService;
    private final OrderService orderService;

    public String handle(final OrdersFood ordersFood) {
        com.koapti.lazychef.model.entity.OrdersFood savedOrdersFood = ordersFoodRepository.save(createOrdersFood(ordersFood));
        return savedOrdersFood.getId().toString();
    }

    private com.koapti.lazychef.model.entity.OrdersFood createOrdersFood(final OrdersFood ordersFood) {
        com.koapti.lazychef.model.entity.OrdersFood ordersFoodEntity = new com.koapti.lazychef.model.entity.OrdersFood();
        ordersFoodEntity.setComments(ordersFood.getComments());
        ordersFoodEntity.setState(FoodState.valueOf(ordersFood.getFoodState().name()));
        ordersFoodEntity.setIdFoodFk(foodService.getFood(ordersFood.getFoodId()));
        ordersFoodEntity.setIdOrderFk(orderService.getOrder(ordersFood.getOrderId()));
        return ordersFoodEntity;
    }
}
