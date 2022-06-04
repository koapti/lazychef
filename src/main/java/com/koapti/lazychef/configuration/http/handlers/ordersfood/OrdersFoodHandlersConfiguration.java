package com.koapti.lazychef.configuration.http.handlers.ordersfood;

import com.koapti.lazychef.http.handler.ordersfood.UpdateOrdersFoodHandler;
import com.koapti.lazychef.repository.OrdersFoodRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrdersFoodHandlersConfiguration {

    @Bean
    public UpdateOrdersFoodHandler updateOrdersFoodHandler(final OrdersFoodRepository ordersFoodRepository) {
        return UpdateOrdersFoodHandler.of(ordersFoodRepository);
    }
}
