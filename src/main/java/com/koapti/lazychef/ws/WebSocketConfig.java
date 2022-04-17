package com.koapti.lazychef.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@Order(Ordered.HIGHEST_PRECEDENCE + 99)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Autowired
    private AuthChannelInterceptorAdapter authChannelInterceptorAdapter;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app")
                .enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket")
                .setAllowedOriginPatterns("*")
                //.addInterceptors(new HttpSessionHandshakeInterceptor())
                //.setHandshakeHandler(new HandshakeHandler())
                .withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        //registration.interceptors(rmeSessionChannelInterceptor);
        registration.interceptors(authChannelInterceptorAdapter);
    }

//    class HandshakeHandler extends DefaultHandshakeHandler {
//
//        @Override
//        protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
//            String username = "ala" + Math.random();
//            return new UsernamePasswordAuthenticationToken(username, null);
//        }
//    }
//
//    class HttpSessionHandshakeInterceptor implements HandshakeInterceptor {
//
//        @Override
//        public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
//                                       WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//
//
//            // Set ip attribute to WebSocket session
//            attributes.put("ip", request.getRemoteAddress());
//
//            // ============================================= CODIGO PERSONAL
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            HttpServletRequest httpServletRequest = servletRequest.getServletRequest();
////        httpServletRequest.getCookies();
////        httpServletRequest.getParameter("inquiryId");
////        httpServletRequest.getRemoteUser();
//
//            String token = httpServletRequest.getParameter("token");
//            return true;
//        }
//
//        @Override
//        public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
//
//        }
//    }
}