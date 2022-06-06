package com.koapti.lazychef.http.service;

import com.koapti.lazychef.model.entity.Order;
import com.koapti.lazychef.repository.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class OrderService {

    private final OrderRepository orderRepository;

    public Order getOrder(final String id) {
        return getOrderFromRepository(id);
    }

    private Order getOrderFromRepository(final String id) {
        return orderRepository.getById(Integer.valueOf(id));
    }
}
