package com.koapti.lazychef.ws.order;

import com.koapti.lazychef.ws.order.message.AbstractOrderOutgoingMessage;
import com.koapti.lazychef.ws.order.message.incoming.AddOrderIncomingMessage;
import com.koapti.lazychef.ws.order.message.incoming.RemoveOrderFoodIncomingMessage;
import com.koapti.lazychef.ws.order.message.incoming.UpdateOrderFoodStateIncomingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class OrderControllerWS {
    @Autowired
    private OrderMessageService orderMessageService;

    @MessageMapping("/order/add")
    @SendTo("/topic/orders")
    public AbstractOrderOutgoingMessage addOrder(AddOrderIncomingMessage addOrderMessage) {
        return orderMessageService.addOrder(addOrderMessage);
    }

    @MessageMapping("/order/remove-food")
    @SendTo("/topic/orders")
    public AbstractOrderOutgoingMessage removeOrderFood(RemoveOrderFoodIncomingMessage removeOrderMessage) {
        return orderMessageService.removeOrderFood(removeOrderMessage);
    }

//    @MessageMapping("/order/update-order-state")
//    @SendTo("/topic/orders")
//    public AbstractOrderOutgoingMessage updateOrderState(OrderIncomingMessage orderIncomingMessage) {
//        return orderMessageService.removeOrderFood(removeOrderMessage);
//    }

    @MessageMapping("/order/update-food-state")
    @SendTo("/topic/orders")
    public AbstractOrderOutgoingMessage updateFoodState(UpdateOrderFoodStateIncomingMessage updateOrderFoodStateIncomingMessage) {
        return orderMessageService.updateOrderFoodState(updateOrderFoodStateIncomingMessage);
    }
}