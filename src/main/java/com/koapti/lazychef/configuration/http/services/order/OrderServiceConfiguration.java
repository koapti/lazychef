package com.koapti.lazychef.configuration.http.services.order;

import com.koapti.lazychef.http.service.OrderService;
import com.koapti.lazychef.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfiguration {

    @Bean
    public OrderService orderService(final OrderRepository orderRepository) {
        return OrderService.of(orderRepository);
    }
}
