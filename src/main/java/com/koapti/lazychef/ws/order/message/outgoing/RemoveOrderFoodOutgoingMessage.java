package com.koapti.lazychef.ws.order.message.outgoing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.koapti.lazychef.ws.order.message.AbstractOrderOutgoingMessage;
import com.koapti.lazychef.ws.order.message.OrderOutgoingMessageType;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemoveOrderFoodOutgoingMessage extends AbstractOrderOutgoingMessage {
    private Integer orderFoodId;
    public RemoveOrderFoodOutgoingMessage(Integer orderFoodId, OrderOutgoingMessageType type) {
        super(type);
        this.orderFoodId = orderFoodId;
    }
    public RemoveOrderFoodOutgoingMessage(OrderOutgoingMessageType type) {
        super(type);
    }
}
