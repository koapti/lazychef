package com.koapti.lazychef.configuration.http;

import com.koapti.lazychef.configuration.http.handlers.order.OrderHandlersConfiguration;
import com.koapti.lazychef.configuration.http.handlers.users.UserHandlersConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        UserHandlersConfiguration.class,
        OrderHandlersConfiguration.class
})
public class HttpConfiguration {
}
