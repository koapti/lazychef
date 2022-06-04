package com.koapti.lazychef.configuration.http.handlers.order;

import com.koapti.lazychef.http.handler.order.CreateOrderHandler;
import com.koapti.lazychef.http.handler.order.GetOrderDetailsHandler;
import com.koapti.lazychef.http.handler.order.GetOrdersHandler;
import com.koapti.lazychef.http.handler.order.UpdateOrderHandler;
import com.koapti.lazychef.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderHandlersConfiguration {

    @Bean
    public CreateOrderHandler createOrderHandler(final OrderRepository orderRepository) {
        return CreateOrderHandler.of(orderRepository);
    }

    @Bean
    public GetOrderDetailsHandler getOrderDetailsHandler(final OrderRepository orderRepository) {
        return GetOrderDetailsHandler.of(orderRepository);
    }

    @Bean
    public GetOrdersHandler getOrdersHandler(final OrderRepository orderRepository) {
        return GetOrdersHandler.of(orderRepository);
    }

    @Bean
    public UpdateOrderHandler updateOrderHandler(final OrderRepository orderRepository) {
        return UpdateOrderHandler.of(orderRepository);
    }
}
