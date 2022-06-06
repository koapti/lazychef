package com.koapti.lazychef.http.handler.ordersfood;

import java.util.List;
import java.util.stream.Collectors;

import com.koapti.lazychef.api.model.OrdersFoodList;
import com.koapti.lazychef.model.mappers.api.OrdersFoodApiMapper;
import com.koapti.lazychef.repository.OrdersFoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetOrdersFoodHandler {

    private final OrdersFoodRepository ordersFoodRepository;

    public OrdersFoodList handle() {
        List<com.koapti.lazychef.model.entity.OrdersFood> allOrdersFood = ordersFoodRepository.findAll();
        return OrdersFoodList.of(allOrdersFood.stream().map(OrdersFoodApiMapper::toApiOrdersFood).collect(Collectors.toList()));
    }
}
