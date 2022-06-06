package com.koapti.lazychef.http;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpConstants {

    public static final String USERS_HTTP_ENDPOINT = "/users";
    public static final String ORDER_HTTP_ENDPOINT = "/order";
    public static final String FOOD_HTTP_ENDPOINT = "/food";
    public static final String ORDERS_FOOD_HTTP_ENDPOINT = "/orders-food";
}
