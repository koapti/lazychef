package com.koapti.lazychef.ws.order;

import com.koapti.lazychef.api.model.FoodState;
import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.api.model.OrdersFood;
import com.koapti.lazychef.ws.order.message.AbstractOrderOutgoingMessage;
import com.koapti.lazychef.ws.order.message.OrderOutgoingMessageType;
import com.koapti.lazychef.ws.order.message.incoming.AddOrderIncomingMessage;
import com.koapti.lazychef.ws.order.message.incoming.RemoveOrderFoodIncomingMessage;
import com.koapti.lazychef.ws.order.message.incoming.UpdateOrderFoodStateIncomingMessage;
import com.koapti.lazychef.ws.order.message.outgoing.AddOrderOutgoingMessage;
import com.koapti.lazychef.ws.order.message.outgoing.RemoveOrderFoodOutgoingMessage;
import com.koapti.lazychef.ws.order.message.outgoing.UpdateOrderFoodStateOutgoingMessage;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class OrderMessageService {

    //private final String apiURL = "http://localhost:8081/";
    //private final RestTemplate client = new RestTemplate();

    private final Map<Integer, Order> orders = new ConcurrentHashMap<>();
    private final Map<Integer, OrdersFood> ordersFood = new ConcurrentHashMap<>();

    public AbstractOrderOutgoingMessage addOrder(AddOrderIncomingMessage orderMessage) {
        var order = orderMessage.getOrder();
        var orderId = randomId();

        if (orders.put(orderId, order) != null) {
            return new AddOrderOutgoingMessage(OrderOutgoingMessageType.FAILURE);
        }

        var ordersFoodList = orderMessage.getOrdersFood();
        var ordersFoodWithIds = ordersFoodList.stream().map(orderFood -> {
                    var id = randomId();
                    var orderFoodCandidate = OrdersFood.builder()
                            .id(id)
                            .orderId(orderId)
                            .foodId(orderFood.getFoodId())
                            .comments(orderFood.getComments())
                            .foodState(FoodState.NOT_READY)
                            .build();
                    ordersFood.put(id, orderFoodCandidate);
                    return orderFoodCandidate;
                })
                .collect(Collectors.toList());
        return new AddOrderOutgoingMessage(ordersFoodWithIds, OrderOutgoingMessageType.ADDED);
    }

    public AbstractOrderOutgoingMessage removeOrderFood(RemoveOrderFoodIncomingMessage removeOrderMessage) {
        if (ordersFood.remove(removeOrderMessage.getOrderFoodId()) == null) {
            return new RemoveOrderFoodOutgoingMessage(OrderOutgoingMessageType.FAILURE);
        }
        return new RemoveOrderFoodOutgoingMessage(removeOrderMessage.getOrderFoodId(), OrderOutgoingMessageType.FOOD_REMOVED);
    }

    public AbstractOrderOutgoingMessage updateOrderFoodState(UpdateOrderFoodStateIncomingMessage updateOrderFoodStateIncomingMessage) {
        var id = updateOrderFoodStateIncomingMessage.getOrderFoodId();
        var orderFoodToUpdate = ordersFood.get(id);
        if (orderFoodToUpdate == null) {
            return new UpdateOrderFoodStateOutgoingMessage(OrderOutgoingMessageType.FAILURE);
        }
        var newState = updateOrderFoodStateIncomingMessage.getNewState();
        orderFoodToUpdate.setFoodState(newState);

        return new UpdateOrderFoodStateOutgoingMessage(orderFoodToUpdate.getId(), orderFoodToUpdate.getFoodState(), OrderOutgoingMessageType.FOOD_STATE_UPDATED);
    }

    private Integer randomId() {
        return (int) (Math.random() * 100000 % 10000) + 1;
    }
}
