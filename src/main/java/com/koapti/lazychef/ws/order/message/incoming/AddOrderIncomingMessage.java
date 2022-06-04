package com.koapti.lazychef.ws.order.message.incoming;

import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.api.model.OrdersFood;
import lombok.Getter;

import java.util.List;

@Getter
public class AddOrderIncomingMessage {
    private Order order;
    private List<OrdersFood> ordersFood;
}
