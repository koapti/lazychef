package com.koapti.lazychef.http.handler.order;

import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.model.mappers.entity.OrderEntityMapper;
import com.koapti.lazychef.repository.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CreateOrderHandler {

    private final OrderRepository orderRepository;

    public void handle(final Order order) {
        orderRepository.save(OrderEntityMapper.toEntityMapper(order));
    }

}
