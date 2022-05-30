package com.koapti.lazychef.ws.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderOutgoingMessage {

    private OrderOutgoingMessageType orderOutgoingMessageType;
    private Order order;

    OrderOutgoingMessage(OrderOutgoingMessageType messageType) {
        this.orderOutgoingMessageType = messageType;
    }

}