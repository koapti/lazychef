package com.koapti.lazychef.configuration.http;

import com.koapti.lazychef.configuration.http.handlers.order.OrderHandlersConfiguration;
import com.koapti.lazychef.configuration.http.handlers.users.UserHandlersConfiguration;
import com.koapti.lazychef.http.controller.order.OrderController;
import com.koapti.lazychef.http.controller.users.UsersController;
import com.koapti.lazychef.http.handler.order.CreateOrderHandler;
import com.koapti.lazychef.http.handler.order.GetOrderDetailsHandler;
import com.koapti.lazychef.http.handler.order.GetOrdersHandler;
import com.koapti.lazychef.http.handler.order.UpdateOrderHandler;
import com.koapti.lazychef.http.handler.users.CreateUserHandler;
import com.koapti.lazychef.http.handler.users.DeleteUserHandler;
import com.koapti.lazychef.http.handler.users.GetUserDetailsHandler;
import com.koapti.lazychef.http.handler.users.GetUsersHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        UserHandlersConfiguration.class,
        OrderHandlersConfiguration.class
})
public class HttpConfiguration {

//    @Bean
//    public UsersController usersController (final CreateUserHandler createUserHandler, final GetUserDetailsHandler getUserDetailsHandler,
//                                            final GetUsersHandler getUsersHandler, final DeleteUserHandler deleteUserHandler) {
//        return UsersController.of(createUserHandler, getUserDetailsHandler, getUsersHandler, deleteUserHandler);
//    }
//
//    @Bean
//    public OrderController orderController(final CreateOrderHandler createOrderHandler, final GetOrderDetailsHandler getOrderDetailsHandler,
//                                           final GetOrdersHandler getOrdersHandler, final UpdateOrderHandler updateOrderHandler) {
//        return OrderController.of(createOrderHandler, getOrderDetailsHandler, getOrdersHandler, updateOrderHandler);
//    }
}
