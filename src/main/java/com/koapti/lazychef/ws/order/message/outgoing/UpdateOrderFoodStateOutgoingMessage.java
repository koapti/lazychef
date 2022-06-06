package com.koapti.lazychef.ws.order.message.outgoing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.koapti.lazychef.api.model.FoodState;
import com.koapti.lazychef.ws.order.message.AbstractOrderOutgoingMessage;
import com.koapti.lazychef.ws.order.message.OrderOutgoingMessageType;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateOrderFoodStateOutgoingMessage extends AbstractOrderOutgoingMessage {
    private Integer orderFoodId;
    @JsonProperty("newState")
    private FoodState newState;
    public UpdateOrderFoodStateOutgoingMessage(OrderOutgoingMessageType type) {
        super(type);
    }
    public UpdateOrderFoodStateOutgoingMessage(Integer orderFoodId, FoodState newState, OrderOutgoingMessageType type) {
        super(type);
        this.orderFoodId = orderFoodId;
        this.newState = newState;
    }
}
