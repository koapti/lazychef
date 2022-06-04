package com.koapti.lazychef.ws.order.message;

import lombok.Getter;

@Getter
public abstract class AbstractOrderOutgoingMessage {
    private OrderOutgoingMessageType messageType;
    public AbstractOrderOutgoingMessage(OrderOutgoingMessageType messageType) {
        this.messageType = messageType;
    }
}
