package com.koapti.lazychef.model.mappers.entity;

import com.koapti.lazychef.model.entity.Order;
import com.koapti.lazychef.model.states.OrderState;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderEntityMapper {

    public static Order toEntityMapper(final com.koapti.lazychef.api.model.Order order) {
        Order orderEntity = new Order();
        orderEntity.setId(order.getId());
        orderEntity.setTableNr(order.getTableNr());
        orderEntity.setState(OrderState.valueOf(order.getState().name()));
        return orderEntity;
    }
}
