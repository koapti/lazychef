package com.koapti.lazychef.ws.order;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class OrderMessageService {

    private final String apiURL = "http://localhost:8081/";
    private final RestTemplate client = new RestTemplate();

    private final Map<Integer, Order> orders = new ConcurrentHashMap<>();

    public OrderOutgoingMessage addOrder(Order order) {
        var id = (int) (Math.random() * 1000 % 100);
        var newOrder = Order.builder()
                .id(id)
                .tableNr(order.getTableNr())
                .foodIds(order.getFoodIds())
                .build();

        if (orders.put(id, newOrder) == null) {
            return new OrderOutgoingMessage(OrderOutgoingMessageType.ADDED, newOrder);
        }
        return new OrderOutgoingMessage(OrderOutgoingMessageType.FAILURE);
    }

    public OrderOutgoingMessage removeOrderFood(Order order) {
        if(order.getFoodIds().size() != 1) {
            return new OrderOutgoingMessage(OrderOutgoingMessageType.FAILURE);
        }
        var foodIdToRemove = order.getFoodIds().get(0);
        var possibleOrder = orders.get(order.getId());
        if(possibleOrder == null) {
            return new OrderOutgoingMessage(OrderOutgoingMessageType.FAILURE);
        }

        if(possibleOrder.getFoodIds().remove(foodIdToRemove)) {
            return new OrderOutgoingMessage(OrderOutgoingMessageType.FOOD_REMOVED, order);
        }

        return new OrderOutgoingMessage(OrderOutgoingMessageType.FAILURE);
    }

}
