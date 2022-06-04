package com.koapti.lazychef.http.handler.order;

import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.model.mappers.entity.OrderEntityMapper;
import com.koapti.lazychef.repository.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CreateOrderHandler {

    private final OrderRepository orderRepository;

    public String handle(final Order order) {
        com.koapti.lazychef.model.entity.Order save = orderRepository.save(OrderEntityMapper.toOrderEntity(order));
        return save.getId().toString();
    }

}
