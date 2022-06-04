package com.koapti.lazychef.ws.order.message.incoming;

import com.koapti.lazychef.api.model.FoodState;
import lombok.Getter;

@Getter
public class UpdateOrderFoodStateIncomingMessage {
    private Integer orderFoodId;
    private FoodState newState;
}
