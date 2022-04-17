package com.koapti.lazychef.ws;

//@Configuration
//@Order(Ordered.HIGHEST_PRECEDENCE + 99)
//public class WebSocketAuthenticationSecurityConfig implements WebSocketMessageBrokerConfigurer {
//    @Autowired
//    private AuthChannelInterceptorAdapter authChannelInterceptorAdapter;
//
//    @Override
//    public void registerStompEndpoints(final StompEndpointRegistry registry) {
//        // Endpoints are already registered on WebSocketConfig, no need to add more.
//    }
//
//    @Override
//    public void configureClientInboundChannel(final ChannelRegistration registration) {
//        registration.interceptors(authChannelInterceptorAdapter);
//    }
//
//}