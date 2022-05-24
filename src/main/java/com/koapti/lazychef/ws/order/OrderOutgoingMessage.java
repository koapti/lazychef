package com.koapti.lazychef.ws.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderOutgoingMessage {

    private OrderOutgoingMessageType orderOutgoingMessageType;
    private Order order;

}