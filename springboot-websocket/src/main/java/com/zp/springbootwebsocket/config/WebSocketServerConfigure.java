package com.zp.springbootwebsocket.config;

import com.zp.springbootwebsocket.handler.MyStringWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author ZP
 * @date 2021/5/10.
 */
@Configuration
@EnableWebSocket
public class WebSocketServerConfigure implements WebSocketConfigurer {

    @Autowired
    private MyStringWebSocketHandler myStringWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myStringWebSocketHandler, "/connect").withSockJS();
    }
}