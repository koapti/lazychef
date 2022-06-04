package com.koapti.lazychef.model.mappers.api;

import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.api.model.OrderState;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderApiMapper {

    public static Order toApiOrder(final com.koapti.lazychef.model.entity.Order order) {
        return Order.builder()
                .id(order.getId())
                .state(OrderState.valueOf(order.getState().name()))
                .tableNr(order.getTableNr())
                .build();
    }
}
