package com.example.backend;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Service
public class ChatService extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println(message.getPayload());
        session.sendMessage(new TextMessage("Danke für Deine Nachricht '"+message.getPayload()+"' - bis zum nächsten Mal."));
    }
}
