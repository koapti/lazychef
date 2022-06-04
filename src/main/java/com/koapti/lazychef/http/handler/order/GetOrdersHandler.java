package com.koapti.lazychef.http.handler.order;

import java.util.List;
import java.util.stream.Collectors;

import com.koapti.lazychef.api.model.OrderList;
import com.koapti.lazychef.model.entity.Order;
import com.koapti.lazychef.model.mappers.api.OrderApiMapper;
import com.koapti.lazychef.repository.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetOrdersHandler {

    private final OrderRepository orderRepository;

    public OrderList handle() {
        List<Order> allOrders = orderRepository.findAll();
        return OrderList.of(allOrders.stream().map(OrderApiMapper::toApiOrder).collect(Collectors.toList()));
    }
}
