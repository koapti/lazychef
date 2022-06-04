package com.koapti.lazychef.ws.order.message.outgoing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.koapti.lazychef.api.model.OrdersFood;
import com.koapti.lazychef.ws.order.message.AbstractOrderOutgoingMessage;
import com.koapti.lazychef.ws.order.message.OrderOutgoingMessageType;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class AddOrderOutgoingMessage extends AbstractOrderOutgoingMessage {
    private List<OrdersFood> orderFoods;
    public AddOrderOutgoingMessage(List<OrdersFood> orderFoods, OrderOutgoingMessageType messageType) {
        super(messageType);
        this.orderFoods = orderFoods;
    }
    public AddOrderOutgoingMessage(OrderOutgoingMessageType messageType) {
        super(messageType);
    }
}
