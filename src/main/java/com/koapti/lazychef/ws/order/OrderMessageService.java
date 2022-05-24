package com.koapti.lazychef.ws.order;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Service
public class OrderMessageService {

    private final String apiURL = "http://localhost:8081/";
    private final RestTemplate client = new RestTemplate();

    private final Set<Order> orders = ConcurrentHashMap.newKeySet();

    private final Map<OrderIncomingMessageType, Function<OrderIncomingMessage, OrderOutgoingMessage>> messageHandlers = Map.of(
            OrderIncomingMessageType.ADD, this::addOrder,
            OrderIncomingMessageType.REMOVE, this::removeOrder
    );

    public Function<OrderIncomingMessage, OrderOutgoingMessage> getHandler(OrderIncomingMessageType orderIncomingMessageType) {
        return messageHandlers.get(orderIncomingMessageType);
    }

    public OrderOutgoingMessage addOrder(OrderIncomingMessage message) {
        //var response = client.postForObject(apiURL + "/1", message.getOrder(), Order.class);
        var outgoingOrder = new Order((int) (Math.random() * 1000 % 100), message.getOrder().getContent());
        if (orders.add(outgoingOrder)) {
            return new OrderOutgoingMessage(OrderOutgoingMessageType.ADDED, outgoingOrder);
        }
        return new OrderOutgoingMessage(OrderOutgoingMessageType.FAILURE, outgoingOrder);
    }

    public OrderOutgoingMessage removeOrder(OrderIncomingMessage message) {
        var order = message.getOrder();
        if (orders.remove(order)) {
            return new OrderOutgoingMessage(OrderOutgoingMessageType.REMOVED, order);
        }
        return new OrderOutgoingMessage(OrderOutgoingMessageType.FAILURE, order);
    }

}
