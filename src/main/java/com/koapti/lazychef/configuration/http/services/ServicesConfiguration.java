package com.koapti.lazychef.configuration.http.services;

import com.koapti.lazychef.configuration.http.services.food.FoodServiceConfiguration;
import com.koapti.lazychef.configuration.http.services.order.OrderServiceConfiguration;
import com.koapti.lazychef.configuration.http.services.user.UserServiceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        FoodServiceConfiguration.class,
        OrderServiceConfiguration.class,
        UserServiceConfiguration.class
})
public class ServicesConfiguration {
}
