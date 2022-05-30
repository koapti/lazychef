package com.koapti.lazychef.ws.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    @Autowired
    private OrderMessageService orderMessageService;

    @MessageMapping("/order/add")
    @SendTo("/topic/orders")
    public OrderOutgoingMessage addOrder(Order order) {
        return orderMessageService.addOrder(order);
    }

    @MessageMapping("/order/remove-food")
    @SendTo("/topic/orders")
    public OrderOutgoingMessage removeOrderFood(Order order) {
        return orderMessageService.removeOrderFood(order);
    }

    @MessageMapping("/order/update-order-state")
    @SendTo("/topic/orders")
    public OrderOutgoingMessage updateOrderState(OrderIncomingMessage orderIncomingMessage) {
        return null;
    }

    @MessageMapping("/order/update-food-state")
    @SendTo("/topic/orders")
    public OrderOutgoingMessage updateFoodState(OrderIncomingMessage orderIncomingMessage) {
        return null;
    }
}