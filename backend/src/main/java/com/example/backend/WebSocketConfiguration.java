package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketConfigurer {

    private final ChatService chatService;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(chatService, "/api/ws/chat")
                .setAllowedOrigins("*")
        ;

    }
}
