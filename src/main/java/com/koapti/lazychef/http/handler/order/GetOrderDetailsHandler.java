package com.koapti.lazychef.http.handler.order;

import java.util.Optional;

import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.http.exceptions.OrderNotFoundException;
import com.koapti.lazychef.model.mappers.api.OrderApiMapper;
import com.koapti.lazychef.repository.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetOrderDetailsHandler {

    private final OrderRepository orderRepository;

    public Order handle(final String id) throws OrderNotFoundException {
        Optional<com.koapti.lazychef.model.entity.Order> order = orderRepository.findById(Integer.parseInt(id));
        if (order.isPresent()) {
            return OrderApiMapper.toApiOrder(order.get());
        }
        throw new OrderNotFoundException("Order was not found");
    }
}
