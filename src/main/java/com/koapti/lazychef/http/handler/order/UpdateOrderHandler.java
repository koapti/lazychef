package com.koapti.lazychef.http.handler.order;

import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.model.mappers.entity.OrderEntityMapper;
import com.koapti.lazychef.repository.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class UpdateOrderHandler {

    private final OrderRepository orderRepository;

    public void handle(final String id, final Order order) {
        com.koapti.lazychef.model.entity.Order orderEntity = orderRepository.getById(Integer.parseInt(id));
        orderRepository.save(updateOrder(order, orderEntity));
    }

    private com.koapti.lazychef.model.entity.Order updateOrder(final com.koapti.lazychef.api.model.Order order,
                                                               final com.koapti.lazychef.model.entity.Order orderEntity) {
        com.koapti.lazychef.model.entity.Order orderEntityTemp = OrderEntityMapper.toEntityMapper(order);
        orderEntity.setState(orderEntityTemp.getState());
        orderEntity.setTableNr(orderEntityTemp.getTableNr());
        return orderEntity;
    }
}
